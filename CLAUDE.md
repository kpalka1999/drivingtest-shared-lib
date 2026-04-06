# shared-lib/CLAUDE.md

## Responsibility
Plain JAR library shared by all 7 services. Contains only types that are genuinely
needed by two or more services. Zero Spring Boot dependency — no auto-configuration,
no beans, no application context.

Package: `com.drivingtest.portal`

---

## What Lives Here

| Package | Contents |
|---------|---------|
| `enums` | `LicenseType`, `QuestionScope`, `QuestionDifficulty`, `SessionStatus`, `PointValue`, `Role`, `ExamResultStatus` |
| `exception` | `ResourceNotFoundException`, `ConflictException`, `ValidationException`, `MailDeliveryException` |
| `util` | `HashUtil` (SHA-256 hex hashing) |
| `dto` | 15 shared DTOs (`QuestionDto`, `AnswerDto`, `ExamSessionDto`, `SessionQuestionDto`, `ExamResultDto`, `ErrorResponse`, etc.) |
| `dto/auth` | 9 auth DTOs (`LoginRequest`, `RegisterRequest`, `TokenResponse`, `UserDto`, etc.) |

## What Does NOT Live Here

- `AuthException` — extends Spring Security's `AuthenticationException`; stays in auth-service.
- Any `@Component`, `@Service`, `@Repository`, `@Bean` annotation — this is a library, not a Spring app.
- Any class that is only used by one service — put it in that service's package directly.

---

## Local Commands
```bash
# Build only shared-lib
./mvnw clean install -pl shared-lib

# shared-lib has no tests of its own (pure data types)
# but changes here trigger recompile in all 7 dependents:
./mvnw clean verify
```

---

## Rules for Adding to shared-lib

1. **Two-service rule.** A type belongs here only if two or more services import it.
   If only one service needs it, put it there and move it here when a second consumer appears.
2. **No Spring dependencies.** `pom.xml` must never add `spring-boot-starter-*`.
   `jackson-databind` and `lombok` are acceptable (pure serialization/boilerplate).
3. **No business logic.** DTOs are records or simple POJOs. Utility classes are stateless.
   Nothing here should have side effects or I/O.
4. **Backwards compatibility matters.** Every service depends on this JAR.
   Removing or renaming a field in a shared DTO is a breaking change across the entire system —
   coordinate with all consumers before doing it.

---

## DO NOT
- Add `@SpringBootApplication` or any Spring Boot dependency.
- Add service-specific logic (exam scoring, auth token generation, etc.).
- Create enums or DTOs that duplicate what lives in a service's own package.

package com.drivingtest.portal.enums;

/**
 * Structural type of a question.
 * <ul>
 *   <li>TAK_NIE — yes/no question; correct answer is T (TAK) or N (NIE) in the source data.</li>
 *   <li>MULTIPLE_CHOICE — three-option question; correct answer is A, B, or C.</li>
 * </ul>
 */
public enum QuestionType {
    TAK_NIE,
    MULTIPLE_CHOICE
}

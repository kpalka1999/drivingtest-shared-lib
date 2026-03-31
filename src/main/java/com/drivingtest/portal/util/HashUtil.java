package com.drivingtest.portal.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for one-way cryptographic hashing used to store sensitive tokens
 * (refresh tokens, verification codes, password-reset tokens) in the database.
 */
public final class HashUtil {

    private HashUtil() {}

    /**
     * Computes the SHA-256 digest of the input string and returns it as a lowercase
     * hexadecimal string (64 characters).
     *
     * @param input the plaintext value to hash
     * @return 64-character lowercase hex SHA-256 digest
     * @throws IllegalStateException if SHA-256 is not available (should never happen on a JDK)
     */
    public static String sha256Hex(String input) {
        byte[] hash = sha256Bytes(input);
        StringBuilder sb = new StringBuilder(64);
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * Computes the SHA-256 digest of the input string and returns the raw byte array.
     * Prefer this over {@link #sha256Hex(String)} when doing constant-time comparison
     * via {@link MessageDigest#isEqual(byte[], byte[])}.
     *
     * @param input the plaintext value to hash
     * @return 32-byte SHA-256 digest
     */
    public static byte[] sha256Bytes(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available", e);
        }
    }

    /**
     * Decodes a lowercase hex string (as returned by {@link #sha256Hex(String)}) back to bytes.
     * Used together with {@link MessageDigest#isEqual(byte[], byte[])} for constant-time
     * comparison of stored token hashes.
     *
     * @param hex the 64-character lowercase hex string
     * @return the corresponding 32-byte array
     */
    public static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                 + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}

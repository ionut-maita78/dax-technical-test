package org.global.dax.shared;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class BytesUtil {

    public final static int FIXED_KEY_BYTES = 4;
    public final static int MAX_VALUE_BYTES = 2096;

    private BytesUtil() {}

    public static String limitKey(String key) {
        if (key == null) {
            return null;
        }
        return new String(fixByteArray(key.getBytes(StandardCharsets.UTF_8), FIXED_KEY_BYTES));
    }

    public static String limitValue(String value) {
        if (value == null) {
            return null;
        }
        return new String(limitByteArray(value.getBytes(StandardCharsets.UTF_8), MAX_VALUE_BYTES));
    }

    public static byte[] limitByteArray(byte[] input, int fixedSize) {
        if (input == null || fixedSize < 1) {
            throw new IllegalArgumentException("Input cannot be null and fixedSize must be at least 1.");
        }

        // If the input byte array is longer than the fixed size, truncate it
        if (input.length > fixedSize) {
            return Arrays.copyOf(input, fixedSize); // Truncate by copying only the first 'fixedSize' bytes
        }

        // If already matching, return the original array
        return input;
    }

    public static byte[] fixByteArray(byte[] input, int fixedSize) {
        if (input == null || fixedSize < 1) {
            throw new IllegalArgumentException("Input cannot be null and fixedSize must be at least 1.");
        }

        // If the input byte array is longer than the fixed size, truncate it
        if (input.length > fixedSize) {
            return Arrays.copyOf(input, fixedSize); // Truncate by copying only the first 'fixedSize' bytes
        } else if (input.length < fixedSize) {
            // If the input is shorter, create a new array and copy the existing data, padding with zeros
            byte[] limitedArray = new byte[fixedSize];
            System.arraycopy(input, 0, limitedArray, 0, input.length);
            return limitedArray; // Return the padded array
        }

        // If already matching, return the original array
        return input;
    }
}
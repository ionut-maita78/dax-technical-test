package org.global.dax.shared;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
class BytesUtilTest {

    @Test
    void limitByteArray() {
        byte[] original = {1, 2, 3, 4, 5};

        byte[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, BytesUtil.limitByteArray(original, 4));

        assertArrayEquals(original, BytesUtil.limitByteArray(original, 8));
    }

    @Test
    void fixByteArray() {
        byte[] original = {1, 2, 3, 4, 5};

        byte[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, BytesUtil.fixByteArray(original, 4));

        assertArrayEquals(original, BytesUtil.fixByteArray(original, 5));

        byte[] expectedWithPadding = {1, 2, 3, 4, 5, 0, 0, 0};
        assertArrayEquals(expectedWithPadding, BytesUtil.fixByteArray(original, 8));
    }

}

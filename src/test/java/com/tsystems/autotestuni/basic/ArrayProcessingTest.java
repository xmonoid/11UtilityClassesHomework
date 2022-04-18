package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.tsystems.autotestuni.basic.ArrayProcessing.extendArray;
import static org.junit.jupiter.api.Assertions.*;

class ArrayProcessingTest {

    @Test
    void extendArrayTest() {
        int[] original = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, extendArray(original, 6, 7));

        original = new Random().ints().limit(100).toArray();
        expected = new int[original.length + 2];
        System.arraycopy(original, 0, expected, 0, original.length);
        expected[expected.length - 2] = Integer.MIN_VALUE;
        expected[expected.length - 1] = Integer.MAX_VALUE;

        assertArrayEquals(expected, extendArray(original, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
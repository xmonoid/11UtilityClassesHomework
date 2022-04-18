package com.tsystems.autotestuni.basic;

import java.util.Arrays;

public class ArrayProcessing {

    /**
     * We have an integer array.
     * Write a method which extends the length of this array and then puts two more elements
     * at the end of the array. Return the new array.
     * The original array should not be changed.
     *
     * @param original the initial array
     * @param newOne the first new element
     * @param newTwo the second new element
     * @return the extended array
     */
    public static int[] extendArray(int[] original, int newOne, int newTwo) {
        int[] result = Arrays.copyOf(original, original.length + 2);
        result[result.length - 2] = newOne;
        result[result.length - 1] = newTwo;
        return result;
    }
}

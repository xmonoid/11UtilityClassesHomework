package com.tsystems.autotestuni.basic;

import java.util.StringTokenizer;

public class TextProcessing {

    /**
     * Write a method which counts how many numbers are contained in a specified text.
     *
     * "There is no numbers at all!" -> 0
     * "Here are 4 words" -> 1
     * "1, 2, three, 4, 5, 89" -> 5
     *
     * @param text a text with words and numbers
     * @return the number of numbers in the text
     */
    public static int numberOfWords(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, " \t,.");

        int result = 0;
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().trim().matches("^\\d+$")) {
                result++;
            }
        }
        return result;
    }
}

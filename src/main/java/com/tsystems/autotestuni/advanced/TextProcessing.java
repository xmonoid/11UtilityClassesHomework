package com.tsystems.autotestuni.advanced;

import java.util.Random;
import java.util.regex.Pattern;

public class TextProcessing {

    /**
     * Write a method which will generate a random password-like string.
     * The new string must contain at least one... :
     * - upper-case letter A-Z
     * - lower-case letter a-z
     * - digit 0-1
     * - special symbol !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
     *
     * The method should return an empty string if the length is less than 8.
     *
     * @param length the length of a new string
     * @return generated string
     */
    public static String passwordGenerator(int length) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Check validity of a phone number in Russian format.
     *
     * Mobile Number validation criteria are as follows:
     * - It should start from either +7 or 8.
     * - Then should be 9 and two digits in parentheses or without them
     * - Last 7 digits can be split by a space ( ) in any way
     * - But there cannot be two or more spaces in a row
     * - The number shouldn't end with a space
     *
     * NOTE: this is a VERY simplified criteria of real numbers.
     *
     * @param number checked number
     * @return {@code true} if the number is valid, {@code false} otherwise
     */
    public static boolean isPhoneNumberValid(String number) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}

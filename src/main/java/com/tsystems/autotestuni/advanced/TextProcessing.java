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
        if (length < 8) {
            return "";
        }
        final char[] upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        final char[] lowerCases = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] digits = "0123456789".toCharArray();
        final char[] specials = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".toCharArray();

        final StringBuilder result = new StringBuilder();

        final Random random = new Random();
        // upper case
        int nextInt = random.nextInt(upperCases.length);
        result.append(upperCases[nextInt]);
        // lower case
        nextInt = random.nextInt(lowerCases.length);
        result.append(lowerCases[nextInt]);
        // digit
        nextInt = random.nextInt(digits.length);
        result.append(digits[nextInt]);
        // special character
        nextInt = random.nextInt(specials.length);
        result.append(specials[nextInt]);

        final char[] allPossibleSymbols = new char[upperCases.length + lowerCases.length
                + digits.length + specials.length];
        System.arraycopy(upperCases, 0, allPossibleSymbols,
                0, upperCases.length);
        System.arraycopy(lowerCases, 0, allPossibleSymbols,
                upperCases.length, lowerCases.length);
        System.arraycopy(digits, 0, allPossibleSymbols,
                upperCases.length + lowerCases.length, digits.length);
        System.arraycopy(specials, 0, allPossibleSymbols,
                upperCases.length + lowerCases.length + digits.length, specials.length);

        for (int i = 4; i < length; i++) {
            nextInt = random.nextInt(allPossibleSymbols.length);
            result.append(allPossibleSymbols[nextInt]);
        }

        return result.toString();
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
        return Pattern.compile(
                "^" // beginning of the string
                + "(\\+7|8)" // either +7 or 8
                + " ?" // may be a space or not
                + "(\\(9\\d{2}\\)|9\\d{2})" // either 9+two digits in parentheses or just 9+two digits
                + "( ?\\d)" // may be a space or a dash and must be a digit
                + "{7}" // repeat the last rule 7 times
                + "$" // end of the string
                ).matcher(number).matches();
    }

}

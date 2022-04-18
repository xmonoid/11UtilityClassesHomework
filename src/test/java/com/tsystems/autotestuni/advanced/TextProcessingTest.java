package com.tsystems.autotestuni.advanced;

import org.junit.jupiter.api.Test;

import static com.tsystems.autotestuni.advanced.TextProcessing.isPhoneNumberValid;
import static com.tsystems.autotestuni.advanced.TextProcessing.passwordGenerator;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessingTest {

    @Test
    void passwordGeneratorTest() {
        for (int i = -1; i < 8; i++) {
            assertTrue(passwordGenerator(i).isEmpty(),
                    "Password must be empty if length parameter is less than 8");
        }

        for (int i = 8; i < 128; i++) {
            String password = passwordGenerator(i);
            assertEquals(i, password.length());
            assertTrue(password.matches("^.*[A-Z]+.*$"),
                    "Password must contain at least one upper case letter. Actual password is " + password);
            assertTrue(password.matches("^.*[a-z]+.*$"),
                    "Password must contain at least one lower case letter. Actual password is " + password);
            assertTrue(password.matches("^.*\\d+.*$"),
                    "Password must contain at least one digit. Actual password is " + password);
            assertTrue(password.matches("^.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]+.*$"),
                    "Password must contain at least one special" +
                            " symbol from the list: !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ Actual password is " + password);
        }
    }

    @Test
    void isPhoneNumberValidTest() {
        assertTrue(isPhoneNumberValid("+7 (900) 123 45 67"));
        assertTrue(isPhoneNumberValid("8 (900) 123 45 67"));
        assertTrue(isPhoneNumberValid("8(900) 123 45 67"));
        assertTrue(isPhoneNumberValid("8(976)5432100"));
        assertFalse(isPhoneNumberValid(" +79001234567 "));
        assertFalse(isPhoneNumberValid("+89001234567"));
        assertFalse(isPhoneNumberValid("79001234567"));
        assertFalse(isPhoneNumberValid("+7(9001)234567"));
        assertFalse(isPhoneNumberValid("+7(800)1234567"));
        assertFalse(isPhoneNumberValid("+7(900)12  345  67"));
        assertFalse(isPhoneNumberValid("+7(900)1234567 "));
        assertFalse(isPhoneNumberValid("+7(9001234567"));
        assertFalse(isPhoneNumberValid("+7900)1234567"));
    }
}
package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.Test;

import static com.tsystems.autotestuni.basic.TextProcessing.numberOfWords;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessingTest {

    @Test
    void numberOfWordsTest() {
        assertEquals(0, numberOfWords("  , (^$#@..,'"));
    }
}
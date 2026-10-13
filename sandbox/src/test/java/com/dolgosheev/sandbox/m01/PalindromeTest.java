package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "А роза упала на лапу Азора",
            "Топот",
            "12321",
            "A man, a plan, a canal: Panama",
            "Was it a car or a cat I saw?",
            "Madam, I'm Adam",
            "a",
            "1",
            "12 3 21",
            "A1b2B1a"
    })
    void shouldReturnTrueForPalindromes(String text) {
        assertThat(Palindrome.isPalindrome(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Привет",
            "!!!",
            " ",
            ".,;",
            "ab",
            "0P",
            "12 34"
    })
    void shouldReturnFalseForNonPalindromes(String text) {
        assertThat(Palindrome.isPalindrome(text)).isFalse();
    }

    @Test
    void shouldReturnFalseForEmptyString() {
        assertThat(Palindrome.isPalindrome("")).isFalse();
    }

    @Test
    void shouldReturnFalseForNull() {
        assertThat(Palindrome.isPalindrome(null)).isFalse();
    }
}
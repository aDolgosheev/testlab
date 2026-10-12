package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void returnsFizzForMultipleOfThree() {
        assertThat(FizzBuzz.fizzBuzz(9)).isEqualTo("Fizz");
    }

    @Test
    void returnsBuzzForMultipleOfFive() {
        assertThat(FizzBuzz.fizzBuzz(10)).isEqualTo("Buzz");
    }

    @Test
    void returnsFizzBuzzForMultipleOfThreeAndFive() {
        assertThat(FizzBuzz.fizzBuzz(15)).isEqualTo("FizzBuzz");
        assertThat(FizzBuzz.fizzBuzz(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void returnsNumberItselfOtherwise() {
        assertThat(FizzBuzz.fizzBuzz(7)).isEqualTo("7");
    }
}
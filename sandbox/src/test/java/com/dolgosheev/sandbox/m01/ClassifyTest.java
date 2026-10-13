package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ClassifyTest {

    @Test
    void returnsFailedForClassify() {
        assertThat(Classify.classify( 9, 8)).isEqualTo("FAILED");
    }

    @Test
    void returnsBorderlineForClassify() {
        assertThat(Classify.classify( 8, 8)).isEqualTo("BORDERLINE");
        assertThat(Classify.classify( 9.5, 10)).isEqualTo("BORDERLINE");
    }

    @Test
    void returnsPassedForClassify() {
        assertThat(Classify.classify( 2, 8)).isEqualTo("PASSED");
    }

    @Test
    void throwsForNegativeLeakRate() {
        assertThatThrownBy(() -> Classify.classify(-1, 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Wrong leak rate or limit");
    }

    @Test
    void throwsForZeroLimit() {
        assertThatThrownBy(() -> Classify.classify(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
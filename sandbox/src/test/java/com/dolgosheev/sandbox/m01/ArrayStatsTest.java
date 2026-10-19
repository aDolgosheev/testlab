package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

class ArrayStatsTest {

    // ---------- sum ----------

    @Test
    void sumOfRegularArray() {
        assertThat(ArrayStats.sum(new int[]{1, 2, 3, 4})).isEqualTo(10);
    }

    @Test
    void sumOfSingleElement() {
        assertThat(ArrayStats.sum(new int[]{5})).isEqualTo(5);
    }

    @Test
    void sumHandlesNegativeNumbers() {
        assertThat(ArrayStats.sum(new int[]{-3, 3})).isEqualTo(0);
    }

    @Test
    void sumOfEmptyArrayIsZero() {
        assertThat(ArrayStats.sum(new int[0])).isEqualTo(0);
    }

    @Test
    void sumThrowsForNull() {
        assertThatThrownBy(() -> ArrayStats.sum(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // ---------- average ----------

    @Test
    void averageOfRegularArray() {
        assertThat(ArrayStats.average(new int[]{1, 2, 3, 4})).isEqualTo(2.5, within(1e-9));
    }

    @Test
    void averageOfSingleElement() {
        assertThat(ArrayStats.average(new int[]{5})).isEqualTo(5.0, within(1e-9));
    }

    @Test
    void averageDoesNotOverflow() {
        int max = Integer.MAX_VALUE;
        assertThat(ArrayStats.average(new int[]{max, max})).isEqualTo(max, within(1e-9));
    }

    @Test
    void averageThrowsForEmptyArray() {
        assertThatThrownBy(() -> ArrayStats.average(new int[0]))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void averageThrowsForNull() {
        assertThatThrownBy(() -> ArrayStats.average(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
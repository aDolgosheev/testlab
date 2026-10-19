package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeDescriberTest {

    @Test
    void describesNull() {
        assertThat(TypeDescriber.describe(null)).isEqualTo("null");
    }

    @Test
    void describesNegativeInteger() {
        assertThat(TypeDescriber.describe(-5)).isEqualTo("отрицательное целое: -5");
    }

    @Test
    void describesNonNegativeInteger() {
        assertThat(TypeDescriber.describe(42)).isEqualTo("целое: 42");
        assertThat(TypeDescriber.describe(0)).isEqualTo("целое: 0");
    }

    @Test
    void describesDouble() {
        assertThat(TypeDescriber.describe(3.14)).isEqualTo("дробное: 3.14");
    }

    @Test
    void describesEmptyString() {
        assertThat(TypeDescriber.describe("")).isEqualTo("пустая строка");
    }

    @Test
    void describesNonEmptyString() {
        assertThat(TypeDescriber.describe("привет")).isEqualTo("строка из 6 символов");
    }

    @Test
    void describesIntArray() {
        assertThat(TypeDescriber.describe(new int[]{3, 4, 5})).isEqualTo("массив из 3 чисел, сумма 12");
    }

    @Test
    void describesUnknownTypeBySimpleName() {
        assertThat(TypeDescriber.describe(true)).isEqualTo("неизвестный тип: Boolean");
    }
}
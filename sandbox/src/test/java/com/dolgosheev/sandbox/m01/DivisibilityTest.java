package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DivisibilityTest {

    @ParameterizedTest(name = "n = {0} → {1}")
    @CsvSource({
            "-7,  0",   // отрицательное n — по условию 0
            "0,   0",   // граница n < 1
            "2,   0",   // ещё ни одного кратного 3
            "3,   1",   // первое кратное
            "10,  3",   // 3, 6, 9
            "100, 33"   // остаток отбрасывается
    })
    void countsNumbersDivisibleBy3(int n, int expected) {
        assertThat(Divisibility.countDivisibleBy3(n)).isEqualTo(expected);
    }
}
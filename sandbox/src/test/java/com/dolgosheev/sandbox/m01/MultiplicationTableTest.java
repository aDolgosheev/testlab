package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MultiplicationTableTest {

    @Test
    void shouldProduceCorrectTableForSize3() {
        // Для size = 3: width = 2
        // header : "   1 2 3"
        // row 1  : " 1 1 2 3"
        // row 2  : " 2 2 4 6"
        // row 3  : " 3 3 6 9"
        String expected = """
                \s\s\s1 2 3
                \s1 1 2 3
                \s2 2 4 6
                \s3 3 6 9
                """;

        assertThat(MultiplicationTable.multiplicationTable(3)).isEqualTo(expected);
    }

    @Test
    void shouldProduceCorrectTableForSize1() {
        String expected = """
                \s\s\s1
                \s1 1
                """;

        assertThat(MultiplicationTable.multiplicationTable(1)).isEqualTo(expected);
    }

    @Test
    void allLinesHaveSameLengthForSize12() {
        String result = MultiplicationTable.multiplicationTable(12);

        assertThat(result.lines()).hasSize(13)
                .allSatisfy(line -> assertThat(line).hasSize(52));
    }

    @Test
    void shouldNotHaveTrailingSpaces() {
        String result = MultiplicationTable.multiplicationTable(12);

        result.lines().forEach(line ->
                assertThat(line).doesNotEndWith(" "));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, 21, 100})
    void shouldThrowForInvalidSize(int size) {
        assertThatThrownBy(() -> MultiplicationTable.multiplicationTable(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("size must be between");
    }
}
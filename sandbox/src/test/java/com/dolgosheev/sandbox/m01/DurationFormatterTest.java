package com.dolgosheev.sandbox.m01;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class DurationFormatterTest {

    // ---------- formatDuration ----------

    @Test
    void formatBasic() {
        assertEquals("01:02:05", DurationFormatter.formatDuration(3725));
    }

    @Test
    void formatZero() {
        assertEquals("00:00:00", DurationFormatter.formatDuration(0));
    }

    @Test
    void formatMoreThan99Hours() {
        assertEquals("100:00:00", DurationFormatter.formatDuration(360000));
    }

    @Test
    void formatExactHour() {
        assertEquals("01:00:00", DurationFormatter.formatDuration(3600));
    }

    @Test
    void formatNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.formatDuration(-1));
    }

    // ---------- parseDuration: успешные ----------

    @Test
    void parseBasic() {
        assertEquals(3725, DurationFormatter.parseDuration("01:02:05"));
    }

    @Test
    void parseZero() {
        assertEquals(0, DurationFormatter.parseDuration("00:00:00"));
    }

    @Test
    void parseMoreThan99Hours() {
        assertEquals(360000, DurationFormatter.parseDuration("100:00:00"));
    }

    @Test
    void parseSingleDigitParts() {
        assertEquals(3725, DurationFormatter.parseDuration("1:2:5"));
    }

    // ---------- parseDuration: неверный ввод ----------

    @Test
    void parseTooFewParts() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("1:2"));
    }

    @Test
    void parseTooManyParts() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("1:02:03:04"));
    }

    @Test
    void parseTrailingColonRejected() {
        // Ловит баг: split(":") без limit отбросил бы пустую хвостовую часть.
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("01:02:05:"));
    }

    @Test
    void parseEmptyMiddlePartRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("01::05"));
    }

    @Test
    void parseBadMinutes() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("01:60:00"));
    }

    @Test
    void parseBadSeconds() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("01:00:60"));
    }

    @Test
    void parseNonNumeric() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("aa:bb:cc"));
    }

    @Test
    void parseNull() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration(null));
    }

    @Test
    void parseEmptyString() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration(""));
    }

    @Test
    void parseNegativeHours() {
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("-01:00:00"));
    }

    @Test
    void parseOverflowRejected() {
        // Ловит баг: без Math.multiplyExact hours * 3600 тихо переполнилось бы.
        assertThrows(IllegalArgumentException.class,
                () -> DurationFormatter.parseDuration("9999999999999999:00:00"));
    }

    // ---------- round-trip: parse(format(x)) == x ----------

    @ParameterizedTest
    @ValueSource(longs = {
            0L, 1L, 59L, 60L, 61L, 3599L, 3600L, 3601L, 3725L,
            86399L, 86400L, 360000L, 1_234_567L
    })
    void roundTrip(long seconds) {
        assertEquals(seconds,
                DurationFormatter.parseDuration(DurationFormatter.formatDuration(seconds)));
    }
}
package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PressureConverterTest {

    private static final double EPS = 1e-9;

    @Test
    void barToMbar() {
        assertEquals(1000.0, PressureConverter.convertPressure(1, "bar", "mbar"), EPS);
    }

    @Test
    void torrToMbar() {
        // 760 * 133.322 / 100 = 1013.2472 ≈ 1013.25
        assertEquals(1013.25, PressureConverter.convertPressure(760, "Torr", "mbar"), 0.01);
    }

    @Test
    void mbarToPa() {
        assertEquals(0.1, PressureConverter.convertPressure(1e-3, "mbar", "Pa"), EPS);
    }

    @Test
    void caseInsensitive() {
        // "BAR" и "pa" в верхнем/нижнем регистре должны работать одинаково
        assertEquals(100_000.0, PressureConverter.convertPressure(1, "BAR", "pa"), EPS);
        assertEquals(100_000.0, PressureConverter.convertPressure(1, "bAr", "PA"), EPS);
    }

    @Test
    void sameUnitIsIdentity() {
        assertEquals(42.0, PressureConverter.convertPressure(42, "bar", "bar"), EPS);
        assertEquals(7.5, PressureConverter.convertPressure(7.5, "torr", "Torr"), EPS);
    }

    @Test
    void zeroValue() {
        assertEquals(0.0, PressureConverter.convertPressure(0, "bar", "Pa"), EPS);
    }

    @Test
    void unknownFromUnit() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PressureConverter.convertPressure(1, "psi", "Pa"));
        assertEquals("Unknown unit: psi", ex.getMessage());
    }

    @Test
    void unknownToUnit() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> PressureConverter.convertPressure(1, "Pa", "atm"));
        assertEquals("Unknown unit: atm", ex.getMessage());
    }

    @Test
    void nullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> PressureConverter.convertPressure(1, null, "Pa"));
    }
}
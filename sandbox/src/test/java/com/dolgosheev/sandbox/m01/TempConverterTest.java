package com.dolgosheev.sandbox.m01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempConverterTest {

    @Test
    void convertCelsiusToKelvin() {
        assertEquals(273.15, TempConverter.celsiusToKelvin(0), 1e-9);
    }

    @Test
    void convertKelvinToCelsius() {
        assertEquals(-195.75, TempConverter.kelvinToCelsius(77.4), 1e-9);
    }
}
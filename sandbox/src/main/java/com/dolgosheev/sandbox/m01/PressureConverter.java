package com.dolgosheev.sandbox.m01;

public class PressureConverter {

    public static double convertPressure(double value, String from, String to) {
        return value * toPascalFactor(from) / toPascalFactor(to);
    }

    private static double toPascalFactor(String unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unknown unit: null");
        }
        return switch (unit.toLowerCase()) {
            case "pa"   -> 1.0;
            case "mbar" -> 100.0;
            case "bar"  -> 100_000.0;
            case "torr" -> 133.322;
            default -> throw new IllegalArgumentException("Unknown unit: " + unit);
        };
    }
}

package com.dolgosheev.sandbox.m01;

public class ArrayStats {

    public static int sum(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static double average(int[] values) {
        requireNonEmpty(values);
        long total = 0;
        for (int value : values) {
            total += value;
        }
        return (double) total / values.length;
    }

    private static void requireNonEmpty(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
    }
}
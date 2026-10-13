package com.dolgosheev.sandbox.m01;

public class SecondMax {

    public static int secondMax(int[] values) {
        if (values == null || values.length < 2) {
            throw new IllegalArgumentException("Exception");
        }

        int max = values[0];
        int second = values[0];

        for (int i : values) {
            if (i > max) {
                second = max;
                max = i;
            }
        }

        if (max == second) {
            throw new IllegalArgumentException("All array elements are identical.");
        }

        return second;
    }
}

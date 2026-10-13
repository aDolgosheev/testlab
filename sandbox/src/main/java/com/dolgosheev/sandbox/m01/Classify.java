package com.dolgosheev.sandbox.m01;

public class Classify {

    public static String classify(double leakRate, double limit) {
        if (leakRate < 0 || limit <= 0) {
            throw new IllegalArgumentException("Wrong leak rate or limit");
        }
        if (leakRate > limit) {
            return "FAILED";
        } else if (9e-1 * limit < leakRate) {
            return "BORDERLINE";
        }
        return "PASSED";
    }
}

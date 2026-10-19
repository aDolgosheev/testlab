package com.dolgosheev.sandbox.m01;

public class Divisibility {

    public static int countDivisibleBy3(int n) {
        return n < 1 ? 0 : n / 3;
    }
}

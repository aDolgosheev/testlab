package com.dolgosheev.sandbox.m01;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    public static String fizzBuzz(int number) {
        int key = (number % 3 == 0 ? 1 : 0) + (number % 5 == 0 ? 2 : 0);
        return switch (key) {
            case 0 -> String.valueOf(number);
            case 1 -> "Fizz";
            case 2 -> "Buzz";
            case 3 -> "FizzBuzz";
            default -> throw new IllegalStateException("unreachable: " + key);
        };
    }
}

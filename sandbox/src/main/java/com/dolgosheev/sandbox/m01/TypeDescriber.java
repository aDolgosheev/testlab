package com.dolgosheev.sandbox.m01;

public class TypeDescriber {

    public static String describe(Object o) {
        return switch (o) {
            case null                      -> "null";
            case Integer i when i < 0      -> "отрицательное целое: " + i;
            case Integer i                 -> "целое: " + i;
            case Double d                  -> "дробное: " + d;
            case String s when s.isEmpty() -> "пустая строка";
            case String s                  -> "строка из " + s.length() + " символов";
            case int[] arr                 -> "массив из " + arr.length + " чисел, сумма " + sum(arr);
            default                        -> "неизвестный тип: " + o.getClass().getSimpleName();
        };
    }

    private static int sum(int[] arr) {
        int total = 0;
        for (int value : arr) {
            total += value;
        }
        return total;
    }
}
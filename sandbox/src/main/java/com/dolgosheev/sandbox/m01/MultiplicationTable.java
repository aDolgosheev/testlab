package com.dolgosheev.sandbox.m01;

public class MultiplicationTable {

    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 20;

    public static String multiplicationTable(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(
                    "size must be between " + MIN_SIZE + " and " + MAX_SIZE + ", got: " + size);
        }

        int width = String.valueOf(size * size).length() + 1;
        String fmt = "%" + width + "d";
        String empty = " ".repeat(width);

        StringBuilder sb = new StringBuilder();

        // Заголовок: пустой угол + 1..size
        sb.append(empty);
        for (int j = 1; j <= size; j++) {
            sb.append(fmt.formatted(j));
        }
        sb.append('\n');

        // Строки: i + i*1 .. i*size
        for (int i = 1; i <= size; i++) {
            sb.append(fmt.formatted(i));
            for (int j = 1; j <= size; j++) {
                sb.append(fmt.formatted(i * j));
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}

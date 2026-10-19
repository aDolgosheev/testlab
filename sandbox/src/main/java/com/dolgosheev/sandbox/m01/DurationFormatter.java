package com.dolgosheev.sandbox.m01;

public class DurationFormatter {

    public static String formatDuration(long seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds must be non-negative: " + seconds);
        }
        long h = seconds / 3600;
        long m = seconds % 3600 / 60;
        long s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static long parseDuration(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Duration text is null");
        }

        // limit = -1 сохраняет хвостовые пустые строки:
        // "01:02:05:".split(":", -1) → ["01","02","05",""] — формат отклонён.
        String[] parts = text.split(":", -1);
        if (parts.length != 3) {
            throw new IllegalArgumentException("Bad duration format: " + text);
        }

        long hours   = parsePart(parts[0], "hours");
        long minutes = parsePart(parts[1], "minutes");
        long seconds = parsePart(parts[2], "seconds");

        if (hours < 0) {
            throw new IllegalArgumentException("Bad hours: " + hours);
        }
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Bad minutes: " + minutes);
        }
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Bad seconds: " + seconds);
        }

        try {
            long result = Math.multiplyExact(hours, 3600);
            result = Math.addExact(result, minutes * 60 + seconds);
            return result;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Duration too large: " + text, e);
        }
    }

    private static long parsePart(String value, String name) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Bad " + name + ": " + value, e);
        }
    }
}
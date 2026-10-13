package com.dolgosheev.sandbox.m01;

public class Palindrome {

    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;
        boolean hasLetterOrDigit = false;

        while (left < right) {
            char leftChar = text.charAt(left);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            char rightChar = text.charAt(right);

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            hasLetterOrDigit = true;

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        if (left == right && Character.isLetterOrDigit(text.charAt(left))) {
            hasLetterOrDigit = true;
        }

        return hasLetterOrDigit;
    }
}

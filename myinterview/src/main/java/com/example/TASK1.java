package com.example;
import java.util.Scanner;
/**
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phrase or word:");
        String input = scanner.nextLine();

        String result = _isPalindrome(input);
        System.out.println(result);
    }
    private static String _isPalindrome(String str) {
        String isNotPalindrome = String.format("%s is not a palindrome", str);
        String isPalindrome = String.format("%s is a palindrome", str);
        String removeBlankSpaces = str.replaceAll("\\s", "").toLowerCase();

        if (removeBlankSpaces.length() <= 1) {
            return isPalindrome;
        }

        int left = 0;
        int right = removeBlankSpaces.length() - 1;
        while (left < right) {
            if (removeBlankSpaces.charAt(left) != removeBlankSpaces.charAt(right)) {
                return isNotPalindrome;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }
}
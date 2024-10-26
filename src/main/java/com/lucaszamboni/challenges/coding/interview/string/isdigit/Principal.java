package com.lucaszamboni.challenges.coding.interview.string.isdigit;

public class Principal {
    public static void main(String[] args) {
        String text = "12345";

        System.out.println("Does the word " +text+ " contain only digits? " + isDigitV3(text));
    }

    public static boolean isDigit(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    public static boolean isDigitV2(String text) {
        return text.matches("\\d+");
    }

    public static boolean isDigitV3(String text) {
        try {
            Integer.parseInt(text);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}

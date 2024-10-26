package com.lucaszamboni.challenges.coding.interview.string.isletter;

public class Principal {

    public static void main(String[] args) {
        String text = "adad-asd";

        System.out.println("Does the word " +text+ " contain only letters? " + isLetter(text));
    }

    public static boolean isLetter(String text) {
        return text.chars().allMatch(Character::isLetter);
    }

    public static boolean isLetterV2(String text) {
        return text.matches("\\p{L}+");
    }
}

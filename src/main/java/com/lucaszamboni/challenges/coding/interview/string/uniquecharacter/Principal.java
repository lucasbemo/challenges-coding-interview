package com.lucaszamboni.challenges.coding.interview.string.uniquecharacter;

import java.util.HashSet;

public class Principal {
    public static void main(String[] args) {
        System.out.printf("java2blog has only unique chars? %s%n", hasUniqueCharacterV2("java2blog"));
        System.out.printf("java2blog has only unique chars? %s%n", hasUniqueCharacterV2("apple"));
        System.out.printf("java2blog has only unique chars? %s%n", hasUniqueCharacterV2("index"));
        System.out.println(String.format("java2blog has only unique chars? %s", hasUniqueCharacterV2("world")));
    }

    public static boolean hasUniqueCharacter(String word) {
        HashSet uniqueContent = new HashSet();

        for (int index=0; index < word.length(); index++) {
            if (!uniqueContent.add(word.charAt(index)))
                return false;
        }
        return true;
    }

    public static boolean hasUniqueCharacterV2(String word) {
        HashSet uniqueContent = new HashSet();

        for (char character: word.toCharArray()) {
            if (!uniqueContent.add(character))
                return false;
        }
        return true;
    }
}

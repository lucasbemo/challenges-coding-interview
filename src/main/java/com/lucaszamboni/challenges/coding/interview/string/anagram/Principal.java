package com.lucaszamboni.challenges.coding.interview.string.anagram;

import java.util.HashMap;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        String textA = "lucas";
        String textB = "acslu";

        Boolean isAnagram = Principal.areAnagram(textA, textB);

        System.out.printf("Are %s and %s anagrams? %s.%n", textA, textB, isAnagram);
    }

    public static boolean areAnagram(String textA, String textB) {
        if (textA ==null
                || textB == null
                || textA.length() != textB.length())
            return false;

        var sbTextB = new StringBuilder(textB);

        for(int i=0; i<textA.length(); i++) {
            var index = sbTextB.indexOf(String.valueOf(textA.charAt(i)));
            if (index != -1) {
                sbTextB.deleteCharAt(index);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramV2(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : str1.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
            if (countMap.get(c) == 0) countMap.remove(c);
        }

        return countMap.isEmpty();
    }
}

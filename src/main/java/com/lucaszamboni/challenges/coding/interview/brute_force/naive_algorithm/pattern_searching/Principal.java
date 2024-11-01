package com.lucaszamboni.challenges.coding.interview.brute_force.naive_algorithm.pattern_searching;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        String text = "BLABL LBLA BDBLA";
        String pattern = "BLA";

        ArrayList<Integer> matching = naiveAlgorithmPatternSearchingV2(text, pattern);

        System.out.printf("How many pattern %s there is in text %s? %d\n", pattern, text, matching.size());

        for (int item: matching) {
            System.out.printf("There is at %d\n", item);
        }
    }

    private static ArrayList<Integer> naiveAlgorithmPatternSearching(String text, String pattern) {
        int textLetterLength = text.toCharArray().length;
        int patternLetterLength = pattern.toCharArray().length;
        ArrayList<Integer> bingos = new ArrayList<>();

        for(int textIdx=0; textIdx < textLetterLength; textIdx++) {
            char textCharacter = text.toCharArray()[textIdx];

            if (pattern.charAt(0) != textCharacter)
                continue;

            if (textIdx + patternLetterLength - 1 > textLetterLength)
                break;

            int patternIdx = 0;

            for (int patternIndexCharacter=0; patternIndexCharacter < patternLetterLength; patternIndexCharacter++) {
                char patCharacter = pattern.toCharArray()[patternIndexCharacter];

                if (text.toCharArray()[textIdx+patternIndexCharacter] != patCharacter)
                    break;

                if (patternIndexCharacter == patternLetterLength-1) {
                    bingos.add((textIdx)+1);
                }
            }
        }

        return bingos;
    }

    private static ArrayList<Integer> naiveAlgorithmPatternSearchingV2(String text, String pattern) {
        int textLetterLength = text.length();
        int patternLetterLength = pattern.length();
        ArrayList<Integer> matching = new ArrayList<>();

        for (int textIdx=0; textIdx <= textLetterLength - patternLetterLength; textIdx++) {
            int patternIdx;

            for (patternIdx=0; patternIdx < patternLetterLength; patternIdx++) {
                if (text.charAt(textIdx+patternIdx) != pattern.charAt(patternIdx))
                    break;
            }

            if (patternIdx == patternLetterLength)
                matching.add(textIdx);
        }
        return matching;
    }
}

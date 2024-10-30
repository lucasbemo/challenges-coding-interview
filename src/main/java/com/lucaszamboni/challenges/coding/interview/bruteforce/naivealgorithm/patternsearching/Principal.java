package com.lucaszamboni.challenges.coding.interview.bruteforce.naivealgorithm.patternsearching;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        String text = "BLABL LBLA BDBLA";
        String pattern = "BLA";

        ArrayList<Integer> bingos = naiveAlgorithmPatternSearchingV2(text, pattern);

        System.out.printf("How many pattern %s there is in text %s? %d\n", pattern, text, bingos.size());

        for (int item: bingos) {
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
        int textLetterLength = text.toCharArray().length;
        int patternLetterLength = pattern.toCharArray().length;
        ArrayList<Integer> bingos = new ArrayList<>();

        for (int textIdx=0; textIdx <= textLetterLength - patternLetterLength; textIdx++) {
            int patternidx;

            for (patternidx=0; patternidx < patternLetterLength; patternidx++) {
                if (text.charAt(textIdx+patternidx) != pattern.charAt(patternidx))
                    break;
            }

            if (patternidx == patternLetterLength)
                bingos.add(textIdx);
        }
        return bingos;
    }
}

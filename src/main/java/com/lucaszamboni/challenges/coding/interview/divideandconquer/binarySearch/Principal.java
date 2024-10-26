package com.lucaszamboni.challenges.coding.interview.divideandconquer.binarySearch;

public class Principal {

    public static void main(String[] args) {
        int[] collection = {2, 5, 7, 8, 9};

        int indexResult = Principal.binarySearch(collection, 9);

        System.out.printf("Index result is: %s%n", indexResult);
    }

    public static Integer binarySearch(int[] collection, int target) {
        if (collection == null || collection.length <= 0)
            return null;

        int lowIdx = 0;
        int highIdx = collection.length-1;

        while (lowIdx <= highIdx) {
            int midIdx = (lowIdx + highIdx)/2;
            int guess = collection[midIdx];

            if (guess == target)
                return midIdx;
            if (guess > target)
                highIdx = midIdx-1;
            else
                lowIdx = midIdx+1;
        }
        return null;
    }
}

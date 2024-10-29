package com.lucaszamboni.challenges.coding.interview.divideandconquer.binarySearch;

public class Principal {

    public static void main(String[] args) {
        int[] collection = {1, 2, 3, 4, 5, 6};

        int indexResult = Principal.binarySearchV2(collection, 1);

        System.out.printf("Index result is: %s%n", indexResult);
    }
    
    public static Integer binarySearchV2(int[] collection, int target) {
        if (collection == null || collection.length <= 0)
            return -1;

        int lowIdx = 0;
        int middleIdx;
        int middleValue;
        int highIdx = collection.length-1;

        while (lowIdx <= highIdx) {
            middleIdx = (lowIdx + highIdx) / 2;
            middleValue = collection[middleIdx];

            if (middleValue == target)
                return middleIdx;

            if (middleValue < target)
                lowIdx = middleIdx + 1;
            if (middleValue > target)
                highIdx = middleIdx - 1;
        }

        return -1;
    }
}

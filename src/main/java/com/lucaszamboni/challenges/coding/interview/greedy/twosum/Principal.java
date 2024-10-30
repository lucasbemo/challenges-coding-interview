package com.lucaszamboni.challenges.coding.interview.greedy.twosum;

import java.util.ArrayList;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        int[] collection = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;

        System.out.printf("Has array %s Two Sum? %b", Arrays.toString(collection), twoSumV2(collection, target));
    }

    private static boolean twoSum(int[] collection, int target) {
        if (collection == null || collection.length <= 0)
            return false;

        ArrayList<Integer> values = new ArrayList<>();

        for (int num: collection) {
            int leftValue = target - num;

            if (values.contains(leftValue)) {
                System.out.printf("%d + %d = %d \n", leftValue, num, target);
                return true;
            }

            values.add(num);
        }

        return false;
    }

    private static boolean twoSumV2(int[] collection, int target) {
        //TODO
        return false;
    }
}

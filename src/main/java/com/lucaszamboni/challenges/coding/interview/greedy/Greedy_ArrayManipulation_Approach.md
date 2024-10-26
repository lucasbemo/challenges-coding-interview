# Greedy Approach with Array Manipulation

## Finding the Maximum Sum of Subarray with Array Manipulation

**Problem:**
Given an array of integers, find the contiguous subarray (containing at least one number) that has the maximum sum.

**Greedy Approach with Array Manipulation (Kadane’s Algorithm):**
- Initialize two variables: ```max_so_far``` and ```current_max```.
  ```max_so_far``` will store the maximum sum found so far.
  ```current_max``` keeps track of the maximum subarray sum ending at the current index.
- Iterate over the array, and at each index, decide to add the current element to ```current_max``` or start a new 
subarray from the current element.
- Update ```max_so_far``` with the maximum of itself and ```current_max``` after each step.

This is a greedy approach because at each index, it makes the optimal choice by deciding whether to extend the subarray or start a new one based on the immediate element.

**Complexity:**
- ***Time Complexity:*** ```O(n)```
- ***Space Complexity:*** ```O(1)```

***Code Example:***
```java
public static int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int currentMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
        currentMax = Math.max(nums[i], currentMax + nums[i]);
        maxSoFar = Math.max(maxSoFar, currentMax);
    }

    return maxSoFar;
}
```

## Array Manipulation for Finding the Longest Increasing Subsequence
Problem:
Given an array of integers, find the length of the longest strictly increasing subsequence (not necessarily contiguous).

Greedy Approach with Array Manipulation:
Binary Search with Tail Array:
Maintain a tails array where each element at index i represents the smallest possible end element of an increasing subsequence of length i+1.
For each element in the input array, perform a binary search to find the position in the tails array where the element can extend or replace.
Update tails and its length accordingly.
This approach uses a greedy choice by maintaining the smallest possible values at each length level.
Complexity:
Time Complexity: O(n log n) due to binary search within each step.
Space Complexity: O(n) for the tails array.

Code Example:
```java
public static int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;

    for (int num : nums) {
        int left = 0, right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (tails[mid] < num) left = mid + 1;
            else right = mid;
        }
        tails[left] = num;
        if (left == size) size++;
    }

    return size;
}
```

## Array Manipulation for Interval Scheduling Maximization
Problem:
Given a list of intervals with start and end times, find the maximum number of non-overlapping intervals you can attend.

Greedy Approach with Array Manipulation:
Sort and Select End Times:
Sort intervals by their end times.
Select the interval with the earliest end time that doesn’t overlap with the previous interval.
Iterate Through Sorted Intervals:
Keep a counter of non-overlapping intervals, updating whenever a new interval can fit within the last selected end time.
This greedy choice focuses on maximizing the number of intervals by always selecting the earliest possible end time that doesn’t interfere with upcoming intervals.

Complexity:
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(1) if sorting in place, otherwise O(n).
Code Example:
```java
import java.util.Arrays;

public static int maxNonOverlappingIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    int count = 0, end = Integer.MIN_VALUE;

    for (int[] interval : intervals) {
        if (interval[0] >= end) {
            count++;
            end = interval[1];
        }
    }

    return count;
}
```


## Array Manipulation for the Task Scheduler Problem
Problem:
Given a list of tasks represented by characters and an integer n that represents the cooldown period, arrange the tasks in the optimal order so the tasks can be completed in the minimum time.

Greedy Approach with Array Manipulation:
Count Frequencies: Count the frequency of each task.
Arrange with Maximum Frequency First:
Use the most frequent tasks to organize intervals based on the cooldown.
Calculate idle slots around high-frequency tasks, which minimizes gaps between tasks.
Calculate Total Time:
Once the highest frequency is placed with gaps, calculate the remaining time by filling empty spaces with lower-frequency tasks.
This approach makes greedy choices by arranging tasks with the highest frequency first to minimize idle slots.

Complexity:
Time Complexity: O(n), where n is the total number of tasks.
Space Complexity: O(1) if task counts are handled with constant auxiliary space.
Code Example:
```java
public static int leastInterval(char[] tasks, int n) {
    int[] counts = new int[26];
    for (char task : tasks) counts[task - 'A']++;

    Arrays.sort(counts);
    int maxFreq = counts[25];
    int idleSlots = (maxFreq - 1) * n;

    for (int i = 24; i >= 0 && counts[i] > 0; i--) {
        idleSlots -= Math.min(counts[i], maxFreq - 1);
    }

    return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
}
```


## Jump Game
Problem:
Given an array of non-negative integers, where each element represents the maximum number of steps you can jump forward, determine if you can reach the last index from the first index.

Greedy Approach with Array Manipulation:
Iterate and Track Reach:
Maintain a farthest variable to track the furthest index that can be reached.
For each index i, if i is within reach (i <= farthest), update farthest as max(farthest, i + nums[i]).
If farthest reaches or exceeds the last index, return true.
Early Stopping:
If at any point farthest cannot be updated to cover the next index, return false.
Complexity:
Time Complexity: O(n)
Space Complexity: O(1)
Code Example:
```java
public static boolean canJump(int[] nums) {
    int farthest = 0;
    for (int i = 0; i < nums.length; i++) {
        if (i > farthest) return false;
        farthest = Math.max(farthest, i + nums[i]);
    }
    return true;
}
```

## Container with Most Water
Problem:
Given an array of heights where each element represents the height of a vertical line, find the maximum area of water that can be contained by any two lines.

Greedy Approach with Two-Pointer Array Manipulation:
Two-Pointer Technique:
Initialize two pointers, left at the start and right at the end of the array.
Calculate the area formed by the lines at these pointers and keep track of the maximum area.
Move the Pointer with the Smaller Height:
To maximize the area, move the pointer at the shorter line, as this increases the potential for a larger area.
Complexity:
Time Complexity: O(n)
Space Complexity: O(1)
Code Example:
```python
public static int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0, right = height.length - 1;

    while (left < right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        maxArea = Math.max(maxArea, area);

        if (height[left] < height[right]) left++;
        else right--;
    }

    return maxArea;
}
```


## Partition Labels
Problem:
Given a string S, partition it into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of each partition.

Greedy Approach with Array Manipulation:
Track Last Occurrences:
First, iterate through the string to store the last index of each character.
Partition with Two Pointers:
Use two pointers (start and end). Expand end to cover all characters within the current partition.
When i reaches end, record the partition size and move start to i + 1.
Complexity:
Time Complexity: O(n)
Space Complexity: O(1)
Code Example:
```java
public static List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); i++) {
        last[S.charAt(i) - 'a'] = i;
    }

    List<Integer> partitions = new ArrayList<>();
    int start = 0, end = 0;

    for (int i = 0; i < S.length(); i++) {
        end = Math.max(end, last[S.charAt(i) - 'a']);
        if (i == end) {
            partitions.add(end - start + 1);
            start = i + 1;
        }
    }

    return partitions;
}
```


## Candy Distribution
Problem:
Given an array representing ratings of children, assign each child a minimum of 1 candy such that:

Each child with a higher rating than their neighbor gets more candies than the neighbor.
Return the minimum number of candies required.

Greedy Approach with Array Manipulation:
Two-Pass Approach:
First Pass (Left to Right): If a child’s rating is higher than the previous child’s, give them more candies than the previous child.
Second Pass (Right to Left): Ensure that children with higher ratings than their next neighbor have more candies, adjusting as needed to satisfy both directions.
This is greedy because we make local adjustments to the candy distribution based on each child’s relative rating to their neighbors.

Complexity:
Time Complexity: O(n)
Space Complexity: O(n)
Code Example:
```java
public static int candy(int[] ratings) {
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);

    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
    }

    for (int i = ratings.length - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    }

    int totalCandies = 0;
    for (int candy : candies) totalCandies += candy;
    return totalCandies;
}

```


These examples demonstrate how array manipulation combined with a greedy strategy can help efficiently solve a 
range of problems. In each case, the algorithm makes decisions based on local information at each step to achieve 
optimal outcomes.

Each of these solutions leverages a greedy approach with array manipulation, making optimal choices at each step to 
reduce complexity and improve efficiency. Let me know if you'd like to dive deeper into any of these!
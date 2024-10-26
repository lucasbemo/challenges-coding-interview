# Greedy Hashing Approach

## Greedy Nature find first duplication

The goal of this challenge is to find the first duplicate in the order of its first appearance. This is inherently
greedy because:

- Immediate Return on Condition: As soon as the algorithm encounters a duplicate element, it returns that element
  without any further processing. The decision to return upon finding the first duplication is a greedy choice—this
  local decision ensures the earliest possible solution.
- Local Decision for Global Solution: The algorithm does not consider all duplicates to decide which one appears first.
  Instead, it processes each element once in a single pass and makes a decision based on the "first-come" principle.
  It assumes that the first duplication encountered will be the global solution, based solely on information
  accumulated up to that point.

**Detailed Example**

Imagine you have an array ```[3, 5, 2, 1, 4, 5, 2].```

Initialization: Start with an empty set (```seen```).
Iteration and Local Decisions:
- 3: Not in ```seen```, add it (```seen = {3}```).
- 5: Not in ```seen```, add it (```seen = {3, 5}```).
- 2: Not in ```seen```, add it (```seen = {3, 5, 2}```).
- 1: Not in ```seen```, add it (```seen = {3, 5, 2, 1}```).
- 4: Not in ```seen```, add it (```seen = {3, 5, 2, 1, 4}```).
- 5: Already in ```seen```, so return ```5``` immediately as the first duplicate.

Here, as soon as we see the second ```"5"```, the algorithm identifies it as a duplicate and stops, choosing ```5```
as the first duplicate without needing to process any remaining elements. This is a greedy choice since it finds the
first duplicate based only on current information and without further checks or lookahead.

**Why This Greedy Choice Works**

- ***Single Pass:*** The problem only requires the first duplicate found in sequential order, so by returning
  immediately upon the first duplication, the algorithm minimizes work.
- ***Optimal Local Decision:*** Each element is either added to the set or, if already in the set, used to solve the
  problem. This local decision guarantees the optimal answer (the first duplicate) because it processes elements in the
  same order they appear in the array.

**Why This Approach is Efficient**
The greedy decision to return immediately upon finding the first duplicate is the optimal approach for this problem:

- ***Minimal Time Complexity:*** It achieves the solution in O(n) time by stopping as soon as the condition is met.
- No Backtracking Needed: There's no need to revisit previous elements because each decision (adding to seen or
  returning a duplicate) is final.
- ***Space Efficiency:*** By using a hash set, it only stores each unique element once, achieving the solution in
  O(n) space.

**Summary**

This hashing solution is greedy because it:

Makes a local, immediate decision (returning the first duplicate as soon as it’s found).
Avoids any unnecessary processing or revisiting of elements.
Finds the globally optimal solution by processing each element exactly once in the order it appears, ensuring the
first duplicate is identified without extra computation.
Thus, the use of a hash set and immediate return embodies the greedy nature of solving the problem in the most direct
and efficient way possible.

**Code:**
```python
def find_first_duplicate(arr):
    seen = set()
    for num in arr:
        if num in seen:
            return num
        seen.add(num)
    return None  # Return None if no duplicate is found
```

## Greedy Nature of Longest Consecutive Sequence

**Problem:**
Given an unsorted array of integers, find the length of the longest consecutive sequence of integers.

**Greedy Hashing Solution:**
- ***Hash Set Initialization:***
    - First, insert all elements into a hash set. This allows us to quickly check if an element's consecutive numbers
      are also in the array.
- ***Greedy Search for Sequence Starts:***
    - Traverse each element in the array. For each element ```num```, check if it's the start of a sequence by seeing
      if ```num - 1``` is in the set.
    - If ```num - 1``` is not in the set, this means ```num``` could be the beginning of a new consecutive sequence.
    - Greedily count consecutive numbers from ```num``` until you reach the end of that sequence, updating the length
      of the longest sequence found so far.
    - This is a greedy approach because it immediately decides to start a new sequence whenever it encounters the
      beginning of one (i.e., when ```num - 1``` is absent). This avoids revisiting elements and minimizes work.

**Complexity:**
- ***Time Complexity:*** ```O(n)``` for inserting and iterating through the elements.
- ***Space Complexity:*** ```O(n)``` for storing elements in the hash set.

**Code Example:**
```python
def longest_consecutive(nums):
    num_set = set(nums)
    longest_streak = 0

    for num in num_set:
        if num - 1 not in num_set:  # Greedy choice: Start of a new sequence
            current_num = num
            current_streak = 1

            while current_num + 1 in num_set:
                current_num += 1
                current_streak += 1

            longest_streak = max(longest_streak, current_streak)

    return longest_streak
```


## Greedy Nature of Two Sum Problem

**Problem:**
Given an array of integers and a target integer, determine if there are two numbers in the array that add up to the
target.

**Greedy Hashing Solution:**
- ***Hash Map Initialization:*** Initialize an empty hash map to store numbers as you traverse the array.
- ***Immediate Check:***
    - For each number in the array, check if the target minus that number (i.e., the complement) exists in the hash map.
    - If it does, you immediately know you have a pair that adds up to the target, so you return the pair.
    - If not, add the current number to the hash map and proceed to the next element.

This is greedy because it makes a quick decision to return as soon as it finds a valid pair, without scanning further
or backtracking.

**Complexity:**
- ***Time Complexity:*** ```O(n)```, because each element is processed once.
- ***Space Complexity:*** ```O(n)``` for storing elements in the hash map.

**Code Example:**
```python
def two_sum(nums, target):
    num_map = {}
    
    for num in nums:
        complement = target - num
        if complement in num_map:
            return True  # Greedy return of the first found pair
        num_map[num] = True

    return False  # No pair found
```

## Greedy Nature of Contains Duplicate with Range-K Problem

**Problem:**
Given an array of integers and an integer ```k```, determine if there are two distinct indices ```i``` and ```j``` in
the array such that ```nums[i] == nums[j]``` and the absolute difference between ```i``` and ```j``` is at most ```k```.

**Greedy Hashing Solution:**
- ***Sliding Hash Set:***
    - Use a hash set to store elements within a sliding window of size ```k```.
    - As you traverse each element, check if it already exists in the hash set. If it does, you immediately return
      ```true``` (indicating a duplicate within the range).
    - If not, add the element to the hash set.
    - Maintain the set size by removing elements that are out of the ```k-```distance range.

This solution is greedy because it immediately returns true upon finding a duplicate within range ```k```,
without processing further elements unnecessarily.

**Complexity:**
***Time Complexity:*** ```O(n)```, as each element is processed only once.
***Space Complexity:*** ```O(k)```, as the set contains at most ```k``` elements at any time.


## Greedy Nature of Subarray with Given Sum Challenge

**Problem:**
Given an array of integers and a target sum, find if there exists a subarray with a sum equal to the target.

**Greedy Hashing Solution:**
- ***Prefix Sum with Hash Map:***
    - Track the cumulative sum of elements as you iterate through the array.
    - For each element at index ```i```, compute the cumulative sum up to that point (```current_sum```).
    - Check if (```current_sum - target_sum```) is already in the hash map. If it is, it means there’s a subarray that
      sums to ```target_sum```, so return immediately.
    - If not, add ```current_sum``` to the hash map and move to the next element.

This approach is greedy because it looks for a match with the minimum processing (by using the prefix sum and checking
against past cumulative sums) and returns immediately upon finding one.

**Complexity:**
- ***Time Complexity:*** ```O(n)``` since each element is processed once.
- ***Space Complexity:*** ```O(n)``` for storing cumulative sums in the hash map.

**Code Example:**

```python
def subarray_with_given_sum(nums, target_sum):
    sum_map = {}
    current_sum = 0

    for num in nums:
        current_sum += num

        if current_sum == target_sum:
            return True  # Immediate return if exact match found

        if (current_sum - target_sum) in sum_map:
            return True  # Greedy decision based on prefix sum

        sum_map[current_sum] = True

    return False
```

**Summary of Greedy Hashing Solutions**

Each of these examples uses a hash-based structure (set or map) to store information and make decisions in constant
time, which helps achieve an optimal solution quickly. The greedy approach in each case allows for an immediate
solution once the condition is met, avoiding unnecessary processing or revisiting of elements. This results in an
efficient, minimal-complexity solution for each problem.

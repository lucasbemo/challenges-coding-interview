# Find First Duplication

***Problem:***
You are given an array of integers, and the goal is to find the first integer that appears more than once in the order it first appears.

### Common Approach: Hashing with Greedy Logic

***Hashing:*** You use a hash set or hash map to keep track of numbers you’ve already seen as you iterate through the array.

***Greedy Approach:*** As you scan each element in the array, you check if it’s already in the hash set:
If it is, you immediately return that number as the first duplicate.
If it’s not, you add it to the hash set and continue scanning.

### Time Complexity:

This approach works efficiently because it finds the answer in a single pass through the array (O(n) time complexity) and uses a hash set, which has an O(1) average time complexity for insert and lookup operations.

```O(n)```, where ```n``` is the length of the array.

### Space Complexity:

```O(n)``` in the worst case, as you may need to store all unique elements in the hash set if there are no duplicates.


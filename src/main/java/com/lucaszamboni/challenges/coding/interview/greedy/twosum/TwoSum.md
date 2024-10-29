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
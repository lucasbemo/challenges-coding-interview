# Naive Algorithm to Pattern Searching

Given text string with length ```n``` and a pattern with length ```m```, the task is to prints all occurrences 
of pattern in text.

Note: You may assume that ```n > m```.

***Examples***
```
Input:  text = “THIS IS A TEST TEXT”, pattern = “TEST”
Output: Pattern found at index 10

Input:  text =  “AABAACAADAABAABA”, pattern = “AABA”
Output: Pattern found at index 0, Pattern found at index 9, Pattern found at index 12
```

**Naive Approach** The naive approach to the problem is simply to try every possible combination

***Brute Force Approach:***
- In the naive pattern-matching algorithm, we start at each position of the text and check if the pattern matches the 
substring of the text at that position.
- For each possible position in the text, we compare each character of the pattern with the corresponding character in 
the text, moving one position to the right each time.

***Algorithm Complexity:***
- Time Complexity: ```O((n - m + 1) * m)``` in the worst case, where ```n``` is the length of the text and ```m``` 
is the length of the pattern.
- This complexity arises because for each position in the text ```(from 0 to n - m)```, we may need to compare up to 
```m``` characters if the match fails at the last character of the pattern.

References:
- [Naive algorithm for Pattern Searching - geeksforgeeks.org](https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/)
- [How to solve the classic Traveling Salesman Problem in Java](https://blogs.oracle.com/javamagazine/post/how-to-solve-the-classic-traveling-salesman-problem-in-java)

# Naive Algorithm to Pattern Searching

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

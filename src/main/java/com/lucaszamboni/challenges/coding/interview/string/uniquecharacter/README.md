Determine if a string has all Unique Characters

Implement an algorithm to determine if a string has all unique characters.

Given a string, determine if the string has all unique characters.

**Examples :**

```
Input : abcd10jk
Output : true

Input : hutg9mnd!nk9
Output : false
```

Approach 1 – Brute Force technique: Run 2 loops with variable i and j. Compare str[i] and str[j]. If they become equal at any point, return false. 
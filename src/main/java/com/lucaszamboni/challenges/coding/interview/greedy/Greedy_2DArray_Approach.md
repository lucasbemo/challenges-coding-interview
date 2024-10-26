# Greedy Approach with 2d Array Approach

In this approach, we'll explore how to apply a greedy strategy using a 2D array to solve various problems.


## Matrix Path with Minimum Sum

**Problem:**
Given a ```m x n``` grid filled with non-negative numbers, find a path from the top-left corner to the bottom-right 
corner that minimizes the sum of the numbers along the path. You can only move either down or right at any point in time.

**Greedy Approach with 2D Array:**
- ***Dynamic Programming Table Initialization:*** 
    Create a 2D array ```dp``` where ```dp[i][j]``` represents the minimum path sum to reach cell ```(i, j)```.
- ***Filling the Table:***
  - Iterate through each cell, updating ```dp[i][j]``` as the minimum of the cell directly above it and the cell to 
  the left of it plus the current cell's value.
- ***Result Extraction:*** The value at ```dp[m-1][n-1]``` gives the minimum path sum.
  
This is a greedy approach because at each cell, you make the optimal choice by considering only the adjacent cells 
from which you can arrive.

**Complexity:**
- ***Time Complexity:*** ```O(m * n)```
- ***Space Complexity:*** ```O(m * n)```

***Code Example:***
```python
def min_path_sum(grid):
    if not grid:
        return 0

    m, n = len(grid), len(grid[0])
    dp = [[0] * n for _ in range(m)]

    dp[0][0] = grid[0][0]  # Starting point

    for i in range(m):
        for j in range(n):
            if i == 0 and j == 0:
                continue
            from_top = dp[i - 1][j] if i > 0 else float('inf')
            from_left = dp[i][j - 1] if j > 0 else float('inf')
            dp[i][j] = grid[i][j] + min(from_top, from_left)

    return dp[m - 1][n - 1]
```


## Coin Change Problem (2D Array for Multiple Coins)

***Problem:***
Given an amount and a list of coin denominations, determine the minimum number of coins needed to make that amount.

**Greedy Approach with 2D Array:**
- ***Dynamic Programming Table Initialization:*** Create a 2D array ```dp``` where ```dp[i][j]``` represents the minimum 
number of coins needed to make amount ```j``` using the first ```i``` coin denominations.
- ***Filling the Table:***
  - Iterate through each coin and for each possible amount, decide whether to include the coin or not.
  - Update the table based on whether including the coin leads to a smaller number of coins.
- ***Result Extraction:*** The value at ```dp[n][amount]``` gives the minimum coins needed, or indicates if it's 
not possible.

This uses a greedy choice by selecting the minimum coins available for each sub-problem.

**Complexity:**
- ***Time Complexity:*** ```O(n * amount)```, where ```n``` is the number of coin denominations.
- ***Space Complexity:*** ```O(n * amount)```

**Code Example:**
```python
def coin_change(coins, amount):
    n = len(coins)
    dp = [[float('inf')] * (amount + 1) for _ in range(n + 1)]
    
    for i in range(n + 1):
        dp[i][0] = 0  # 0 coins needed to make amount 0

    for i in range(1, n + 1):
        for j in range(1, amount + 1):
            dp[i][j] = dp[i - 1][j]  # Not using the coin
            if j >= coins[i - 1]:
                dp[i][j] = min(dp[i][j], dp[i][j - coins[i - 1]] + 1)

    return dp[n][amount] if dp[n][amount] != float('inf') else -1
```

## Word Search II (Finding All Words in a 2D Grid)

**Problem:**
Given a board of letters and a list of words, find all words that can be formed by letters on the board.

**Greedy Approach with 2D Array:**
- ***Trie Construction:*** First, build a trie (prefix tree) from the list of words.
- ***DFS with Backtracking:***
  - Use depth-first search (DFS) to explore each cell in the grid.
  - Mark cells as visited, and for each letter, check if it leads to a valid word in the trie.
  - If a valid word is found, add it to the result.
  - Unmark the cell (backtrack) after exploring.

This greedy approach works by immediately exploring possible words while traversing the grid.

**Complexity:**
- ***Time Complexity:*** ```O(m * n * k)```, where ```m``` is the number of rows, ```n``` is the number of columns, 
and ```k``` is the length of the longest word.
- ***Space Complexity:*** ```O(w)``` for storing the trie, where ```w``` is the total number of characters in the list 
of words.

- ***Code Example:***
```python
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

def word_search(board, words):
    trie = Trie()
    for word in words:
        trie.insert(word)

    result = set()
    rows, cols = len(board), len(board[0])
    
    def dfs(x, y, node, path):
        if node.is_end_of_word:
            result.add(path)
            node.is_end_of_word = False  # Avoid duplicate entries
        
        if x < 0 or x >= rows or y < 0 or y >= cols or board[x][y] == '#':
            return
        
        char = board[x][y]
        node = node.children.get(char)
        if not node:
            return
        
        board[x][y] = '#'  # Mark as visited
        dfs(x + 1, y, node, path + char)
        dfs(x - 1, y, node, path + char)
        dfs(x, y + 1, node, path + char)
        dfs(x, y - 1, node, path + char)
        board[x][y] = char  # Backtrack

    for i in range(rows):
        for j in range(cols):
            dfs(i, j, trie.root, "")
    
    return list(result)

```

## Game of Life

**Problem:**
Given a board (2D array) of ```0s``` (dead) and ```1s``` (live), each cell interacts with its eight neighbors 
(horizontal, vertical, diagonal) using the following four rules (taken from the Wikipedia article on Conway's 
Game of Life):

- Any live cell with fewer than two live neighbors dies (as if caused by under-population).
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies (as if by over-population).
- Any dead cell with exactly three live neighbors becomes a live cell (as if by reproduction).

**Greedy Approach with 2D Array:**
- ***Copy the Board:*** Create a copy of the board to avoid overwriting data during the update.
- ***Iterate through the Board:***
  - For each cell, count its live neighbors.
  - Apply the game rules based on the neighbor count to determine the next state of each cell.

This solution is greedy because it evaluates the immediate neighbor states to decide the next state for each cell.

**Complexity:**
- ***Time Complexity:*** ```O(m * n)```
- ***Space Complexity:*** ```O(m * n)``` for the copy of the board.

**Code Example:**
```python
def game_of_life(board):
    rows, cols = len(board), len(board[0])
    directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    
    def count_live_neighbors(x, y):
        count = 0
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < rows and 0 <= ny < cols and abs(board[nx][ny]) == 1:
                count += 1
        return count

    for i in range(rows):
        for j in range(cols):
            live_neighbors = count_live_neighbors(i, j)
            if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[i][j] = -1  # Mark for death
            elif board[i][j] == 0 and live_neighbors == 3:
                board[i][j] = 2  # Mark for revival

    for i in range(rows):
        for j in range(cols):
            if board[i][j] > 0:
                board[i][j] = 1
            else:
                board[i][j] = 0
```

**Summary of Greedy Approaches Using 2D Arrays**

These examples showcase how 2D arrays can be used effectively in greedy algorithms to make decisions based on local 
information (like neighboring cells). The approach often involves iterating through the array, applying certain 
conditions or rules, and making optimal choices based on immediate criteria. This leads to efficient solutions for 
a variety of problems in grid-based scenarios.

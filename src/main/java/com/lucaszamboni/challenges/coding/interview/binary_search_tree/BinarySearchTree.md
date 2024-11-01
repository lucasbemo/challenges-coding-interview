# Binary Search Tree

A binary search tree is a binary tree made up of nodes. Each node has a key signifying its value.

The value of the nodes on the left subtree are smaller than the value of the root node. And the value of the nodes on the right subtree are larger than the value of the root node.

The root node is the parent node of both subtrees.

***What Is a Binary Search Tree Used For?***

Binary search trees help us speed up our binary search as we are able to find items faster.

We can use the binary search tree for the addition and deletion of items in a tree.

We can also represent data in a ranked order using a binary tree. And in some cases, it can be used as a chart to represent a collection of information.

***What is Tree Traversal?***
Traversing a tree means visiting and outputting the value of each node in a particular order.

Like Inorder, Preorder, and Post order tree traversal methods.

The major importance of tree traversal is that there are multiple ways of carrying out traversal operations unlike linear data structures like arrays, bitmaps, matrices where traversal is done in a linear order.

Each of these methods of traversing a tree have a particular order they follow:
- For Inorder, you traverse from the left subtree to the root then to the right subtree.
- For Preorder, you traverse from the root to the left subtree then to the right subtree.
- For Post order, you traverse from the left subtree to the right subtree then to the root.

Here is another way of representing the information above:
- Inorder => Left, Root, Right.
- Preorder => Root, Left, Right.
- Post order => Left, Right, Root.

## Challenge

Given a BST, the task is to search a node in this BST. For searching a value in BST, consider it as a sorted array. 
Now we can easily perform search operation in BST using Binary Search Algorithm.



[Binary Search Tree Traversal – Inorder, Preorder, Post Order for BST - Free Boot Camp Org](https://www.freecodecamp.org/news/binary-search-tree-traversal-inorder-preorder-post-order-for-bst/)
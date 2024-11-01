package com.lucaszamboni.challenges.coding.interview.binary_search_tree;

public class Principal {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node right, Node left) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10,
                new Node(8, new Node(11, new Node(18,
                        new Node(19), new Node(5)), new Node(9)), new Node(65))
                , new Node(12, new Node(12, new Node(4
                        , new Node(8), new Node(6)), new Node(1)), new Node(54)));
        System.out.println(findElement(root, 54));
    }

    public static boolean findElement(Node node, int target) {
        if (node == null)
            return false;
        if (node.value == target)
            return true;

        return node.value < target
                ? findElement(node.left, target)
                : findElement(node.right, target);
    }
}

package com.lucaszamboni.challenges.coding.interview.string.palindrome;

public class Principal {
    public static void main(String[] args) {
        var isPalindrome = false;
        String text = "madam";
        String textReversed = new StringBuffer(text).reverse().toString();

        if (text.equals(textReversed))
            isPalindrome = true;

        System.out.println(String.format("Is the word %s a Palindrome?\n%s", text, isPalindrome));
    }
}

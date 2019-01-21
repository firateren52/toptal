package com.eren.testdome;

//https://www.testdome.com/questions/java/palindrome/7283?visibility=1&skillId=4&orderBy=Difficulty
public class Palindrome {

    public static boolean isPalindrome(String word) {
        if(word == null || word.length() <= 1) {
            return true;
        }

        word = word.toLowerCase();
        for(int i = 0;i < word.length() / 2; i ++) {
            if(word.charAt(i) != word.charAt(word.length() - i -1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        System.out.println(Palindrome.isPalindrome("Delede2342veled"));
        System.out.println(Palindrome.isPalindrome(""));
        System.out.println(Palindrome.isPalindrome(null));
    }
}

package com.eren.fathom;

import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {


    private boolean isAnagram(String word1, String word2) {
        Map<Character, Integer> charCount = word1.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum));
        Map<Character, Integer> charCount2 = word2.chars().boxed().collect(Collectors.toMap(
                k -> Character.valueOf((char) k.intValue()),
                v -> 1,
                Integer::sum));
        return charCount.equals(charCount2);
    }

    public static void main(String[] args) {
        System.out.println(new TestMain().isAnagram("abad", "daab"));
    }
}
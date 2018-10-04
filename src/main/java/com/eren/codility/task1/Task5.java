package com.eren.codility.task1;

import java.util.Arrays;

public class Task5 {

    public String solution(String[] words) {
        int[] visitedStatusArray = new int[words.length];
        Arrays.fill(visitedStatusArray, -1);
        for(int i = 0; i < words.length; i ++) {
            char match = words[i].charAt(2);
            for(int j = 0; j < words.length; i ++) {
                if(match == words[j].charAt(0)) {
                    visitedStatusArray[0] = j;
                }
            }
        }
        String word = "";
        for(int i = 0; i < visitedStatusArray.length; i ++) {
            word = word.concat(words[visitedStatusArray[i]]);
        }
        return word;
    }
}


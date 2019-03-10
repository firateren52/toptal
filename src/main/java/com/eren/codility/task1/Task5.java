package com.eren.codility.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task5 {

    public String solution(String[] words) {
        int[] visitedStatusArray = new int[words.length];
        Arrays.fill(visitedStatusArray, -1);
        for(int i = 0; i < words.length; i ++) {
            char match = words[i].charAt(2);
            for(int j = 0; j < words.length; j ++) {
                if(match == words[j].charAt(0)) {
                    visitedStatusArray[i] = j;
                }
            }
        }
        String word = "";
        List<Integer> visitedStatusList = Arrays.stream(visitedStatusArray).boxed().collect(Collectors.toList());
        int start = -1;
        for (int i = 0; i < visitedStatusArray.length; i++) {
            int index = visitedStatusList.indexOf(start);
            word = words[index].charAt(2) + word;
            start = index;
        }
        word = words[start].charAt(0) + word;
        return word;
    }

    public String solutionNew(String[] words) {
        int[] visitedStatusArray = new int[words.length];
        Arrays.fill(visitedStatusArray, -1);
        IntStream.range(0, words.length).forEach(i -> {
            char match = words[i].charAt(2);
            for(int j = 0; j < words.length; j ++) {
                if(match == words[j].charAt(0)) {
                    visitedStatusArray[i] = j;
                }
            }
        });


        String word = "";
        List<Integer> visitedStatusList = Arrays.stream(visitedStatusArray).boxed().collect(Collectors.toList());
        int start = -1;
        for (int i = 0; i < visitedStatusArray.length; i++) {
            int index = visitedStatusList.indexOf(start);
            word = words[index].charAt(2) + word;
            start = index;
        }
        word = words[start].charAt(0) + word;
        return word;
    }
}


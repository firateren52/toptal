package com.eren.amazon.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColonySolution {

    public List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> currentStates = Arrays.stream(states).boxed().collect(Collectors.toList());
        List<Integer> nextStates = new ArrayList<>();
        for(int j = 0; j < days; j ++) {
            for(int i = 0; i < currentStates.size(); i ++) {
                Integer nextState = ((i > 0 ? currentStates.get(i-1) : 0) + (i < currentStates.size()-1 ? currentStates.get(i+1) : 0)) % 2;
                nextStates.add(i, nextState);
            }
            currentStates = nextStates;
            nextStates = new ArrayList<>(states.length);
        }
        return currentStates;
    }
}

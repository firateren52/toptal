package com.eren.codility.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BracketsSolution {
    public int solutionWithStack(String S) {
        List<Character> leftBrackets = Arrays.asList('(', '[', '{');
        List<Character> rightBrackets = Arrays.asList(')', ']', '}');
        Stack<Integer> bracketStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            Character bracket = S.charAt(i);
            int index = leftBrackets.indexOf(bracket);
            if (index >= 0) {
                bracketStack.push(index);
            } else {
                index = rightBrackets.indexOf(bracket);
                int lastBracketIntex = bracketStack.peek();
                if (index != lastBracketIntex) {
                    return 0;
                } else {
                    bracketStack.pop();
                }
            }
        }
        if (bracketStack.empty())
            return 1;
        else
            return 0;
    }

    public int solution(String S) {
        List<Character> leftBrackets = Arrays.asList('(', '[', '{');
        List<Character> rightBrackets = Arrays.asList(')', ']', '}');
        // ArrayDeque is faster than LinkedList
        Deque<Integer> bracketStack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            Character bracket = S.charAt(i);
            Integer index = leftBrackets.indexOf(bracket);
            if (index >= 0) {
                bracketStack.addFirst(index);
            } else {
                index = rightBrackets.indexOf(bracket);
                Integer lastBracketIndex = bracketStack.peekFirst();
                if (index != lastBracketIndex) {
                    return 0;
                } else {
                    bracketStack.removeFirst();
                }
            }
        }
        if (bracketStack.isEmpty())
            return 1;
        else
            return 0;
    }
}

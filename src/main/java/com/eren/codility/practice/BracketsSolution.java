package com.eren.codility.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketsSolution {
    public int solution(String S) {
        List<String> leftBrackets = new ArrayList<String>();
        List<String> rightBrackets = new ArrayList<String>();
        leftBrackets.add(0, "(");
        leftBrackets.add(1, "[");
        leftBrackets.add(2, "{");
        rightBrackets.add(0, ")");
        rightBrackets.add(1, "]");
        rightBrackets.add(2, "}");
        String bracket1Left = "(", bracket1Right = ")" ;
        String bracket2Left = "[", bracket2Right = "]" ;
        String bracket3Left = "{", bracket3Right = "}" ;

        Stack<Integer> bracketStack = new Stack<Integer>();
        for(int i = 0; i < S.length(); i ++) {
            String bracket = String.valueOf(S.charAt(i));
            int index = leftBrackets.indexOf(bracket);
            if(index >= 0) {
                bracketStack.push(index);
            } else {
                index = rightBrackets.indexOf(bracket);
                int lastBracketIntex = bracketStack.peek();
                if(index != lastBracketIntex) {
                    return 0;
                } else {
                    bracketStack.pop();
                }
            }
        }
        if(bracketStack.empty())
            return 1;
        else
            return 0;
    }
}

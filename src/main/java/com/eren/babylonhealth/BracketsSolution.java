package com.eren.babylonhealth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketsSolution {
    static String brace(String S) {
        List<String> leftBrackets = new ArrayList<String>();
        List<String> rightBrackets = new ArrayList<String>();
        leftBrackets.add(0, "(");
        leftBrackets.add(1, "[");
        leftBrackets.add(2, "{");
        rightBrackets.add(0, ")");
        rightBrackets.add(1, "]");
        rightBrackets.add(2, "}");
        String bracket1Left = "(", bracket1Right = ")";
        String bracket2Left = "[", bracket2Right = "]";
        String bracket3Left = "{", bracket3Right = "}";
        Stack<Integer> bracketStack = new Stack<Integer>();
        for (int i = 0; i < S.length(); i++) {
            String bracket = String.valueOf(S.charAt(i));
            int index = leftBrackets.indexOf(bracket);
            if (index >= 0) {
                bracketStack.push(index);
            } else {
                index = rightBrackets.indexOf(bracket);
                if (bracketStack.empty()) {
                    return "NO";
                }
                int lastBracketIntex = bracketStack.peek();
                if (index != lastBracketIntex) {
                    return "NO";
                } else {
                    bracketStack.pop();
                }
            }
        }
        if (bracketStack.empty())
            return "YES";
        else
            return "NO";
    }

    // Complete the braces function below.
    static String[] braces(String[] values) {
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            results[i] = brace(values[i]);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(brace("}][}}(}][))]"));
    }
}

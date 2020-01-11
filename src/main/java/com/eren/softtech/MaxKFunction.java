package com.eren.softtech;

public class MaxKFunction {

    // k*(k+1) <= N, return max(k)
    public int solution(int N) {
        int start = (int) Math.round(Math.sqrt(N * 2));
        while((start * (start + 1)) > (N * 2)) {
            start --;
        }
        return start;
    }
}

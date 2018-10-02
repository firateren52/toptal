package com.eren.codility.practice;

public class FrogJmpSolution {
    public int solution(int X, int Y, int D) {
        float sum = (float) (Y - X) / (float) D;

        return Math.round(sum);
    }
}

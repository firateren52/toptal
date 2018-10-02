package com.eren.codility.practice;

import java.util.Arrays;

public class TapeEquilibriumSolution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int i = (A.length + 1) / 2;
        int leftSum = Arrays.stream(Arrays.copyOfRange(A, 0, i)).sum();
        int rightSum = Arrays.stream(Arrays.copyOfRange(A, i, A.length)).sum();
        int diff = leftSum - rightSum;

        int val = Math.abs(diff);
        int  k = diff < 0 ? 1 : -1;
        i = i + k;
        while((i >=0 && i < A.length) && Math.abs(val - (2 * A[i]))  < val) {
            val = Math.abs(val - (2 * A[i]));
            i = i + k;
        }
        return val;
    }
}

package com.eren.codility.practice;

public class MaxProfitSolution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length < 2) {
            return 0;
        }
        int min = A[0], maxProfit = 0, profit = 0;
        for(int i = 1;i < A.length; i ++) {
            profit = Math.max(0, A[i] - min);
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, A[i]);
        }
        return maxProfit;
    }
}

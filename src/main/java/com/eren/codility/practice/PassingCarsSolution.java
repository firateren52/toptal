package com.eren.codility.practice;

public class PassingCarsSolution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] sum = new int[A.length];
        sum[0] = A[0] == 0 ? 1 : 0;
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            sum[i] = A[i] == 0 ? 1 + sum[i - 1] : +sum[i - 1];
            count += sum[i] * A[i];
        }

        if (count > 1000000000) {
            return -1;
        } else {
            return count;
        }
    }
}

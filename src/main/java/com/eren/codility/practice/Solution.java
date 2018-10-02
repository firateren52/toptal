package com.eren.codility.practice;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int min = 1;
        Arrays.sort(A);
        for(int i = 0;i < A.length; i ++) {
            if(A[i] > min) {
                return min;
            }
            if(A[i] == min) {
                min++;
            }
        }
        return min;
    }
}
package com.eren.codility.task1;

import java.util.Arrays;

public class Task1 {

    public int solution(int[] A) {
        int[] visitedStatusArray = new int[A.length];
        Arrays.fill(visitedStatusArray, 0);
        int maxNeckLaceSize = 0;
        for(int i = 0;i < visitedStatusArray.length; i ++) {
            int neckLaceSize = 1;
            if(visitedStatusArray[i] == 0) {
                int j = A[i];
                while(j != i) {
                    neckLaceSize ++;
                    visitedStatusArray[j] = 1;
                    j = A[j];
                }
                visitedStatusArray[i] = 1;
                maxNeckLaceSize = Math.max(maxNeckLaceSize, neckLaceSize);
            }
        }
        return maxNeckLaceSize;
    }
}


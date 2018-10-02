package com.eren.codility.task1;

public class Task2 {

    public int solution(int[] A) {
        if(A.length < 2) {
            return A.length;
        }

        int maxTurbulence = 1;
        int turbulence = 1;
        Boolean isGreat = null;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1] && (isGreat == null || !isGreat)) {
                turbulence++;
                isGreat = true;
            } else if (A[i] < A[i + 1] && (isGreat == null || isGreat)) {
                turbulence++;
                isGreat = false;
            } else {
                maxTurbulence = Math.max(maxTurbulence, turbulence);
                turbulence = 2;
            }
        }
        maxTurbulence = Math.max(maxTurbulence, turbulence);
        return maxTurbulence;
    }
}


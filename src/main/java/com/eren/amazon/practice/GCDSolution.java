package com.eren.amazon.practice;

import java.util.Arrays;

public class GCDSolution {
    public int generalizedGCD(int num, int[] arr) {
        int gcd = 1, divisor = 2;
        boolean isDivisible = true;
        int max = Arrays.stream(arr).max().getAsInt();
        while(divisor <= max/gcd) {
            isDivisible = true;
            for(int i = 0; i < num && isDivisible; i ++) {
                int remainder =  (arr[i]/gcd) % divisor;
                isDivisible = remainder == 0 ? true: false;
            }
            gcd = isDivisible ? gcd * divisor : gcd;
            divisor = isDivisible ? 2 : divisor + 1;
        }
        return gcd;
    }

}

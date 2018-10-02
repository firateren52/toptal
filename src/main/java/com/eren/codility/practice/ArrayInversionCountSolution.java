package com.eren.codility.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayInversionCountSolution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length < 2) {
            return 0;
        }
        long count = 0;
        List<Integer> sortedArray = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(sortedArray, Collections.reverseOrder());
        int[] valueArray = new int[A.length];
        Arrays.fill(valueArray, 1);

        for(int i = A.length - 1; i>=0; i --) {
            int index = sortedArray.indexOf(Integer.valueOf(A[i]));
            count += index;
            sortedArray.remove(index);
            valueArray[index] = 0;
        }
        if(count > 1000000000) {
            return -1;
        }
        return Long.valueOf(count).intValue();
    }
}

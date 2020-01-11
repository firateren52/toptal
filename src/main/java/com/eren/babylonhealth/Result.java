package com.eren.babylonhealth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'maxLength' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     */

    public static int maxLength(List<Integer> a, int k) {
        int fromIndex = 0, toIndex = 0;

        for (int i = 0; i < a.size(); i++) {
            int sum = 0;
            for (int j = i; j < a.size(); j++) {
                sum += a.get(j);
                if (sum > k) {
                    break;
                }

                if ((j - i) > (toIndex - fromIndex)) {
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return (toIndex - fromIndex + 1);
    }

    static int maxLength2(List<Integer> a, int k) {
        Map<Integer, Map<Integer, Long>> map = new HashMap<Integer, Map<Integer, Long>>();

        int maxLength = 0;
        for(int i = 0; i < a.size() - 1; i++) {
            Map<Integer, Long> map2 = new HashMap<Integer, Long>();
            map2.put(i, (long)a.get(i));
            map.put(i, map2);
            if(a.get(i) == k) {
                maxLength = 1;
            }
        }

        for(int l = 2; l <= a.size(); l++) {
            long sum = 0;
            for(int i = 0; i <= a.size() - l; i++) {
                int j = i + l - 1;
                Map<Integer, Long> map2 = map.get(i);
                sum = map2.get(j - 1) + a.get(j);
                map2.put(j, sum);

                if(sum <= k) {
                    if(l > maxLength) {
                        maxLength = l;
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList( 3,1,2,1 );
        System.out.println(maxLength(lst, 4));
        System.out.println(maxLength2(lst, 4));
    }

}
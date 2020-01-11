package com.eren.babylonhealth;

import java.util.List;



class MaxLength {

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

}
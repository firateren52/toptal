package com.eren.commencis;

public class Solution {

    public static int longestSubsequence(String x, String y) {
        int lsb[][] = new int[y.length() + 1][x.length() + 1];

        for (int i = 0; i <= y.length(); i++) {
            for (int j = 0; j <= x.length(); j++) {
                lsb[i][j] = 0;
            }
        }

        for (int i = 1; i <= y.length(); i++) {
            for (int j = 1; j <= x.length(); j++) {
                if (x.charAt(j - 1) == y.charAt(i - 1)) {
                    lsb[i][j] = lsb[i - 1][j - 1] + 1;
                } else {
                    lsb[i][j] = lsb[i][j - 1];
                }
            }
        }

        int maxLSB = 0;
        for (int i = 1; i <= y.length(); i++) {
            maxLSB = Math.max(maxLSB, lsb[i][x.length()]);
        }

        return maxLSB;
    }

    // Driver Method
    public static void main(String[] args)
    {
        String x = "ABCD";
        String y = "BACDBDCD";
        System.out.println(longestSubsequence(x, y));
    }
}

package com.eren.zalando;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 20));
        System.out.println(solution.solution(998623201, 998623201));
        System.out.println(solution.solution(256, 256));
        System.out.println(solution.solution(65536, 65536));
        System.out.println(solution.solution(130321, 130321));
        System.out.println(solution.solution(2, 1000000000));
    }

    public int solution(int A, int B) {
        int max = 0;
        for(int i = A; i <=B;) {
            int sqrt = (int) Math.floor(Math.sqrt(i));
            if(!isPerfectSquare(i)) {
                sqrt += 1;
            }
            if(sqrt * sqrt <=B) {
                max = Math.max(max, calculatePerfectSquareCount(sqrt));
            }
            i = sqrt * sqrt + 1;
        }
        return max;
    }

    private int calculatePerfectSquareCount(int n) {
        int count = 1;
        double x = n;
        while(isPerfectSquare(x)) {
            count ++;
            x = (int) Math.floor(Math.sqrt(x));
        }
        return count;
    }

    private boolean isPerfectSquare(double n) {
        double sqrt = Math.sqrt(n);
        return (sqrt - Math.floor(sqrt)) == 0;
    }
}
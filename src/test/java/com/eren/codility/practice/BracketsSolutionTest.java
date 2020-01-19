package com.eren.codility.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class BracketsSolutionTest {
    BracketsSolution solution = new BracketsSolution();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        String S = "{[()()]}";
        Assert.assertEquals(solution.solution(S), 1);

        S = "()]";
        Assert.assertEquals(solution.solution(S), 0);

        S = "([)()]";
        Assert.assertEquals(solution.solution(S), 0);

        S = "(";
        Assert.assertEquals(solution.solution(S), 0);

        S = "(]";
        Assert.assertEquals(solution.solution(S), 0);

        S = "";
        Assert.assertEquals(solution.solution(S), 1);
    }

    @Test
    public void testTaskEmpty()
    {
        int n = 5;
        int[] input = {0, 1, 0, 1, 1};
        //Assert.assertEquals(solution.solution(input), 5);
    }

    @Test
    public void testTaskBigValues()
    {
        int n = 5;
        int[] input = new int[n];
        //Assert.assertEquals(solution.solution(input), -1);
    }

    @Test
    public void testTaskLargeInput()
    {
        int n = 100000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(n) + 1;
        //Assert.assertEquals(solution.solution(input), 1);
    }
}

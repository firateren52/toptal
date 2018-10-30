package com.eren.amazon.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class GCDSolutionTest {
    GCDSolution solution = new GCDSolution();

    @Test
    public void testTask()
    {
        int[] input = {2,4,6,8,10};
        int num = 5;
        Assert.assertEquals(solution.generalizedGCD(num, input), 2);
    }

    @Test
    public void testTask2()
    {
        int[] input = {3,4,6,8,10};
        int num = 5;
        Assert.assertEquals(solution.generalizedGCD(num, input), 1);
    }

    @Test
    public void testTask3()
    {
        int[] input = {60,80,120,160,200};
        int num = 5;
        Assert.assertEquals(solution.generalizedGCD(num, input), 20);
    }

/*    @Test
    public void testTaskBigValues()
    {
        int n = 5;
        int[] input = new int[n];
        Assert.assertEquals(task1.solution(input), -1);
    }

    @Test
    public void testTaskLargeInput()
    {
        int n = 1000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(n) + 1;
        Assert.assertEquals(task1.solution(input), -1);
    }*/
}

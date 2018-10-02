package com.eren.codility.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class ArrayInversionCountSolutionTest {
    ArrayInversionCountSolution task1 = new ArrayInversionCountSolution();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        int[] input = {0, 0, 0};
        Assert.assertEquals(task1.solution(input), 0);

        int[] input2 = {-1, 6, 3, 4, 7, 4};
        Assert.assertEquals(task1.solution(input2), 4);
    }

    @Test
    public void testTaskEmpty()
    {
        int n = 5;
        int[] input = {2147483647, 1, 2147483640, -2147483648};
        Assert.assertEquals(task1.solution(input), 5);
    }

    @Test
    public void testTaskBigValues()
    {
        int n = 5;
        int[] input = new int[n];
        Assert.assertEquals(task1.solution(input), -1);
    }

    @Test
    public void testTaskLargeInput()
    {
        int n = 100000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(2147483647) + 1;
        Assert.assertEquals(task1.solution(input), 1);
    }
}

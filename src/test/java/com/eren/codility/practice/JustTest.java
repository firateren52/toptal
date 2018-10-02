package com.eren.codility.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


public class JustTest {
    Solution task1 = new Solution();
    int x = -2147483648;

    @Test
    public void testTask()
    {
    }

    @Test
    public void testTaskEmpty()
    {
        int n = 5;
        int[] input = {1, 2, 3};
        Assert.assertEquals(task1.solution(input), 4);
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
            input[i] = rand.nextInt(n) + 1;
        Assert.assertEquals(task1.solution(input), 1);
    }
}

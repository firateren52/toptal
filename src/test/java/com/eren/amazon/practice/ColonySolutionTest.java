package com.eren.amazon.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ColonySolutionTest {
    ColonySolution solution = new ColonySolution();

    @Test
    public void testTask()
    {
        int[] input = {1, 0,0,0,0,1,0,0};
        int days = 1;
        List<Integer> output = Arrays.asList(0,1,0,0,1,0,1,0);
        Assert.assertTrue(output.equals(solution.cellCompete(input, days)));
    }

    @Test
    public void testTask2()
    {
        int[] input = {1, 1,1,0,1,1,1,1};
        int days = 2;
        List<Integer> output = Arrays.asList(0,0,0,0,0,1,1,0);
        Assert.assertTrue(output.equals(solution.cellCompete(input, days)));
    }

/*    @CharUtil
    public void testTaskBigValues()
    {
        int n = 5;
        int[] input = new int[n];
        Assert.assertEquals(task1.solution(input), -1);
    }

    @CharUtil
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

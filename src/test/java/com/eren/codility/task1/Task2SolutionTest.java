package com.eren.codility.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class Task2SolutionTest {
    Task2 task1 = new Task2();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        int[] input = {};
        Assert.assertEquals(task1.solution(input), 0);

        int[] input2 = {9,4,2,10,7,8,8,1,9};
        Assert.assertEquals(task1.solution(input2), 5);

        int[] input3 = {4,8,12,16};
        Assert.assertEquals(task1.solution(input3), 2);

        int[] input4 = {100};
        Assert.assertEquals(task1.solution(input4), 1);
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
            input[i] = rand.nextInt(1000000000) + 1;
        Assert.assertEquals(task1.solution(input), 1);
    }

    @Test
    public void testTaskLargeInput2()
    {
        int n = 100000;
        int[] input = new int[n];
        int  x = 0;
        for(int i = 0; i < n; i ++) {
            input[i] = i % 2 == 0 ? 50 : 150;
        }
        Assert.assertEquals(task1.solution(input), n);
    }

    @Test
    public void testTaskLargeInput3()
    {
        int n = 100000;
        int[] input = new int[n];
        int  x = 0;
        for(int i = 0; i < n; i ++) {
            input[i] = i % 2 == 0 ? 50 : 150;
        }
        Assert.assertEquals(task1.solution(input), n);
    }
}

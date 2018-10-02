package com.eren.codility.task1;

import com.eren.codility.practice.ArrayInversionCountSolution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class Task1SolutionTest {
    Task1 task1 = new Task1();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        int[] input = {};
        Assert.assertEquals(task1.solution(input), 0);

        int[] input2 = {5, 4, 0, 3, 1, 6, 2};
        Assert.assertEquals(task1.solution(input2), 4);

        int[] input3 = {0};
        Assert.assertEquals(task1.solution(input3), 1);
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
        int n = 10000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(10000) + 1;
        Assert.assertEquals(task1.solution(input), 1);
    }

    @Test
    public void testTaskLargeInput2()
    {
        int n = 1000000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = i + 1;
        input[n - 1] = 0;
        Assert.assertEquals(task1.solution(input), n);
    }
}

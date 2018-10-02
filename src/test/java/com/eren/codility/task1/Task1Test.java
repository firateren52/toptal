package com.eren.codility.task1;

import com.eren.codility.task1.Task1;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class Task1Test {
    Task1 task1 = new Task1();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        Integer.bitCount()
        int n = 5;
        int[] input = new int[n];
        Assert.assertEquals(task1.solution(input), -1);
    }

    @Test
    public void testTaskEmpty()
    {
        int n = 5;
        int[] input = new int[n];
        Assert.assertEquals(task1.solution(input), -1);
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
        int n = 1000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(n) + 1;
        Assert.assertEquals(task1.solution(input), -1);
    }
}

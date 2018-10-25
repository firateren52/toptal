package com.eren.codility.task1;

import org.junit.Assert;
import org.junit.Test;


public class Task4Test {
    Task4 task1 = new Task4();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        String input = "1-1,3-5,5-2,2-3,2-4";

        Assert.assertEquals(task1.solution(input), 3);
    }

   /* @Test
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
    }*/
}

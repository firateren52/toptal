package com.eren.parknav;

import com.eren.amazon.practice.ColonySolution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ParkingCameraSolutionTest {
    ParkingCameraSolution solution = new ParkingCameraSolution();

    @Test
    public void testTask()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, solution.findMinCameras(range, input));
    }

    @Test
    public void testTask2()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 2;
        Assert.assertEquals(3, solution.findMinCameras(range, input));
    }

    @Test
    public void testTask3()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 3;
        Assert.assertEquals(2, solution.findMinCameras(range, input));
    }

    @Test
    public void testTask4()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 6;
        Assert.assertEquals(1, solution.findMinCameras(range, input));
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

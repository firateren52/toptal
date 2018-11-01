package com.eren.parknav;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class ParkingCameraSolutionTest {
    ParkingCameraSolution solution = new ParkingCameraSolution();

    @Test
    public void testTaskBinarySearch()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, solution.findMinCamerasBinarySearch(range, input));
    }

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
        Assert.assertEquals(3, solution.findMinCamerasBinarySearch(range, input));
    }

    @Test
    public void testTask3()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 3;
        Assert.assertEquals(2, solution.findMinCameras(range, input));
        Assert.assertEquals(2, solution.findMinCamerasBinarySearch(range, input));
    }

    @Test
    public void testTask4()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 6;
        Assert.assertEquals(1, solution.findMinCameras(range, input));
        Assert.assertEquals(1, solution.findMinCamerasBinarySearch(range, input));
    }

    @Test
    public void testTaskLargeInput()
    {
        int n = 100000;
        int[] input = new int[n];
        int range = 20;
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(n) + 1;
        Arrays.sort(input);
        Assert.assertTrue(solution.findMinCameras(range, input) > 0);
        Assert.assertTrue(solution.findMinCamerasBinarySearch(range, input) > 0);
    }
}

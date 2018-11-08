package com.eren.parknav;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class ParkingCameraSolutionTest {
    ParkingCameraSolution solution = new ParkingCameraSolution();

    @Test
    public void testTaskSolution()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, Solution.findMinimumNumberOfCameras(range, input));
    }

    @Test
    public void testTaskLinear()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Solution.findMinimumNumberOfCameras(1, new int[] { 1, 2, 3, 4, 5} );
    }

    @Test
    public void testTaskExponential()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasExponentialSearch(range, input));
    }



    @Test
    public void testTaskBinarySearch()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasBinarySearch(range, input));
    }

    @Test
    public void testTask()
    {
        int[] input = {1,15,30,40,50};
        int range = 10;
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasLinearSearch(range, input));
    }

    @Test
    public void testTask2()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 2;
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasLinearSearch(range, input));
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasBinarySearch(range, input));
        Assert.assertEquals(3, Solution.findMinimumNumberOfCameras(range, input));
        Assert.assertEquals(3, solution.findMinimumNumberOfCamerasExponentialSearch(range, input));
    }

    @Test
    public void testTask3()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 3;
        Assert.assertEquals(2, solution.findMinimumNumberOfCamerasLinearSearch(range, input));
        Assert.assertEquals(2, solution.findMinimumNumberOfCamerasBinarySearch(range, input));
        Assert.assertEquals(2, Solution.findMinimumNumberOfCameras(range, input));
        Assert.assertEquals(2, solution.findMinimumNumberOfCamerasExponentialSearch(range, input));
    }

    @Test
    public void testTask4()
    {
        int[] input = {1, 2, 4, 5, 6, 8, 10, 11, 12};
        int range = 6;
        Assert.assertEquals(1, solution.findMinimumNumberOfCamerasLinearSearch(range, input));
        Assert.assertEquals(1, solution.findMinimumNumberOfCamerasBinarySearch(range, input));
        Assert.assertEquals(1, Solution.findMinimumNumberOfCameras(range, input));
        Assert.assertEquals(1, solution.findMinimumNumberOfCamerasExponentialSearch(range, input));
    }

    @Test
    public void testTaskLargeInput()
    {
        int n = 100000;
        int k = 2;
        int[] input = new int[n];
        int range = 2;
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(n * k) + 1;
        input = Arrays.stream(input).distinct().toArray();
        Arrays.sort(input);
        float averageRange = (float)( range * (input.length- 1)) / (float)(input[input.length - 1] - input[0]);
        System.out.println("average parking spaces per range: " + averageRange);
        Assert.assertTrue(solution.findMinimumNumberOfCamerasLinearSearch(range, input) > 0);
        Assert.assertTrue(Solution.findMinimumNumberOfCameras(range, input) > 0);
        Assert.assertTrue(solution.findMinimumNumberOfCamerasExponentialSearch(range, input) > 0);
        Assert.assertTrue(solution.findMinimumNumberOfCamerasBinarySearch(range, input) > 0);
    }
}

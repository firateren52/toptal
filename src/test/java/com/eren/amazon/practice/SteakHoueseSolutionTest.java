package com.eren.amazon.practice;

import com.eren.amazon.task.SteakHousesSolution;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SteakHoueseSolutionTest {
    SteakHousesSolution solution = new SteakHousesSolution();

    @Test
    public void testTask()
    {
        List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        List<Integer> a3 = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a2.add(3);
        a2.add(4);
        a3.add(1);
        a3.add(-1);
        allLocations.add(a);
        allLocations.add(a2);
        allLocations.add(a3);
        List<List<Integer>> newLocations = new ArrayList<List<Integer>>();
        newLocations.add(a3);
        newLocations.add(a);
        Assert.assertEquals(newLocations, solution.nearestXsteakHouses(allLocations.size(), allLocations, 2));
    }

    @Test
    public void testTask2()
    {
        int[] input = {1, 1,1,0,1,1,1,1};
        int days = 2;
        List<Integer> output = Arrays.asList(0,0,0,0,0,1,1,0);
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

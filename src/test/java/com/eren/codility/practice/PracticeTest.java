package com.eren.codility.practice;

import com.eren.codility.task1.Task1;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class PracticeTest {
    Solution task1 = new Solution();
    TapeEquilibriumSolution tapeEquilibriumSolution = new TapeEquilibriumSolution();
    int x = -2147483648;

    @Test
    public void testTask()
    {
        int n = 5;
        int[] input = {1, 3, 6, 4, 1, 2};
        Assert.assertEquals(task1.solution(input), 5);

        int[] input2 = {1, 2, 3};
        Assert.assertEquals(task1.solution(input2), 4);

        int input3[] = { -3, -2};
        Assert.assertEquals(task1.solution(input3), 1);
    }

    @Test
    public void testTapeEquilibriumSolution()
    {
        int n = 5;
        int[] input = {1000, 0, 0, 0, 0, 0, 0, 10};
        Assert.assertEquals(tapeEquilibriumSolution.solution(input), 990);

        int[] input2 = {1000, 0, 0, 0, 0, 0, 0, -10};
        Assert.assertEquals(tapeEquilibriumSolution.solution(input2), 1010);

        int[] input3 = {5, 6, 2, 4, 1};
        Assert.assertEquals(tapeEquilibriumSolution.solution(input3), 4);
        int[] input4 = {-5, -6, -2, -4, -1};
        Assert.assertEquals(tapeEquilibriumSolution.solution(input4), 4);
    }

    @Test
    public void testTapeEquilibriumSolutionLargeInput()
    {
        int n = 100000;
        int[] input = new int[n];
        Random rand = new Random();
        int  x = 0;
        for(int i = 0; i < n; i ++)
            input[i] = rand.nextInt(1000) + 1;
        Assert.assertEquals(tapeEquilibriumSolution.solution(input), 1);
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

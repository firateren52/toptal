package com.eren.softtech;

import org.junit.Assert;
import org.junit.Test;

public class MaximalBinaryLocationTest {

    @Test
    public void testNormal() {
        MaximalBinaryLocation function = new MaximalBinaryLocation();
        int[] data = {0,1,1,1,0,1,1,1,0,1};
        Assert.assertEquals(1, function.solution(data));

        int[] data2 = {0, 0};
        Assert.assertEquals(-1, function.solution(data2));

        int[] data3 = {1, 0};
        Assert.assertEquals(0, function.solution(data3));

        int[] data4 = {0};
        Assert.assertEquals(-1, function.solution(data4));

        int[] data5 = {1};
        Assert.assertEquals(0, function.solution(data5));
    }

    @Test
    public void tesFalse() {
        MaximalBinaryLocation function = new MaximalBinaryLocation();
        int[] data = {1,0,0,1};
        Assert.assertEquals(0, function.solution(data));

        int[] data2 = {1,1,0,1,1};
        Assert.assertEquals(0, function.solution(data2));

        int[] data3 = {1,1,1,0,0,0,1,1,1,0};
        Assert.assertEquals(0, function.solution(data3));

        int[] data4 = {0,1,1,1,0,0,0,1,1,1,0};
        Assert.assertEquals(1, function.solution(data4));
    }
}

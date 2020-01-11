package com.eren.softtech;

import org.junit.Assert;
import org.junit.Test;

public class MaxKFunctionTest {

    @Test
    public void testNormal() {
        MaxKFunction function = new MaxKFunction();
        Assert.assertEquals(0, function.solution(0));
        Assert.assertEquals(1, function.solution(1));
        Assert.assertEquals(1, function.solution(2));
        Assert.assertEquals(2, function.solution(3));
        Assert.assertEquals(5, function.solution(17));
        Assert.assertEquals(99, function.solution(5000));
        Assert.assertEquals(99, function.solution(5049));
        Assert.assertEquals(100, function.solution(5050));
        Assert.assertEquals(100, function.solution(5051));
        System.out.println(function.solution(1000000000));
    }
}

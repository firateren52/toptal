package com.eren.revolut;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharUtilTest {

    @Test
    public void getCharCounts_givenNullInput_returnEmptyMap() {
        CharUtil charUtil = new CharUtil();
        String input = null;
        Map<Character, Integer> charCounts = charUtil.getCharCounts_v2(input);
        Assert.assertTrue(charCounts.size() == 0);

        input = "";
        charCounts = charUtil.getCharCounts(input);
        Assert.assertTrue(charCounts.size() == 0);
    }

    @Test
    public void getCharCounts_givenHelloInput_returnTrue() {
        CharUtil charUtil = new CharUtil();
        String input = "hello";
        Map<Character, Integer> expectedresult = new HashMap<>();
        expectedresult.put(Character.valueOf('h'), 1);
        expectedresult.put(Character.valueOf('e'), 1);
        expectedresult.put(Character.valueOf('l'), 2);
        expectedresult.put(Character.valueOf('o'), 1);

        Map<Character, Integer> result = charUtil.getCharCounts_v2(input);
        Assert.assertTrue(result.equals(expectedresult));
    }

    @Test
    public void getCharCounts_givenWarWithSpacesInput_returnTrue() {
        CharUtil charUtil = new CharUtil();
        String input = "rw a r";
        Map<Character, Integer> expectedresult = new HashMap<>();
        expectedresult.put(Character.valueOf('w'), 1);
        expectedresult.put(Character.valueOf(' '), 2);
        expectedresult.put(Character.valueOf('a'), 1);
        expectedresult.put(Character.valueOf('r'), 2);
        ArrayList<Integer> a = new ArrayList<>();
        Map<Character, Integer> result = charUtil.getCharCounts_v2(input);
        Assert.assertTrue(result.equals(expectedresult));
    }
}

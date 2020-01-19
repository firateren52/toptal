package com.eren.amazon.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void popularNToys() {
        Solution solution = new Solution();
        List<String> toys = Arrays.asList("ana", "baba", "dada", "fafa");
        List<String> quotes = Arrays.asList("ana dsadsa ana baba", "baba", "dada", "dsadsa", "sss");
        ArrayList<String> topToys = solution.popularNToys(4,2,toys,5,quotes);
        System.out.println(topToys);
    }

    @Test
    public void popularNToys2() {
        Solution solution = new Solution();
        List<String> toys = Arrays.asList("ana", "baba", "dada", "fafa");
        List<String> quotes = Arrays.asList();
        ArrayList<String> topToys = solution.popularNToys(4,2,toys,0,quotes);
        System.out.println(topToys);
    }

    @Test
    public void popularNToys3() {
        Solution solution = new Solution();
        List<String> toys = Arrays.asList();
        List<String> quotes = Arrays.asList("ana dsadsa ana baba", "baba", "dada", "dsadsa", "sss");
        ArrayList<String> topToys = solution.popularNToys(0,2,toys,5,quotes);
        System.out.println(topToys);
    }
}
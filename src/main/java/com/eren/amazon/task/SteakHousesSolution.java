package com.eren.amazon.task;

import java.util.*;

public class SteakHousesSolution {

    public List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses) {
        Map<Double, Integer> distances = new TreeMap<Double, Integer>();
        int i = 0;
        for(List<Integer> location: allLocations) {
            Double distance = Math.sqrt(Math.pow(location.get(0), 2) + Math.pow(location.get(1), 2));
            distances.put(distance, i);
            i++;
        }
        List<List<Integer>> nearestLocations = new ArrayList<List<Integer>>();
        i = 0;
        for(Integer j : distances.values()) {
            if(i >= numSteakhouses) {
                break;
            }
            nearestLocations.add(allLocations.get(j));
            i++;
        }
        return nearestLocations;
    }
}

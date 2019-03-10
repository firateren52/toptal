package com.eren.skyscanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindMaxOccurence {

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputMostPopularDestination(_count, in);
    }

    static void OutputMostPopularDestination(int count, Scanner in) {
        Map<String, Integer> destinationCountMap = new HashMap<String, Integer>();
        String popularDestination = null;
        int maxCount = 0;
        while(in.hasNext()) {
            String destination = in.nextLine();
            Integer destinationCount = destinationCountMap.get(destination);
            Integer newCount = (destinationCount != null ? destinationCount : 0) + 1;
            destinationCountMap.put(destination, newCount);

            if(newCount > maxCount){
                maxCount = newCount;
                popularDestination = destination;
            }
        }
        System.out.println(popularDestination);
    }
}

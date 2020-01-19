package com.eren.amazon.task2;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {
        int length = Math.min(numToys, topToys);
        ArrayList<String> topNToys = new ArrayList<>(length);
        Map<String, Integer> toyCountMap = new HashMap<>();
        toys.forEach(toy -> toyCountMap.put(toy, 0));
        quotes.forEach(quote -> {
            String[] words = quote.split(" ");
            toys.forEach(toy -> {
                int count = Arrays.stream(words).anyMatch(word -> word.equalsIgnoreCase(toy)) ? 1 : 0;
                toyCountMap.put(toy, toyCountMap.get(toy) + count);
            });

        });

        SortedSet<KeyValuePair> sortedSet = new TreeSet<>();
        toyCountMap.entrySet().forEach(entry -> sortedSet.add(new KeyValuePair(entry.getKey(), entry.getValue())));
        Iterator<KeyValuePair> iterator = sortedSet.iterator();
        for (int i = 0; i < length; i++) topNToys.add(iterator.next().key);
        return topNToys;
    }
    // METHOD SIGNATURE ENDS

    public static class KeyValuePair implements Comparable<KeyValuePair> {
        String key;
        Integer value;

        public KeyValuePair(String key, int value) {
            super();
            this.key = key;
            this.value = value;
        }

        public int compareTo(KeyValuePair o) {
            return value == o.value ? key.compareToIgnoreCase(o.key) : o.value - value;
        }
    }
}
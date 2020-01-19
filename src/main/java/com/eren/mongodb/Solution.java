package com.eren.mongodb;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


// # A video game has recorded the player name and score for each time the game has been played.
// # Create a high-score list of the top 50 Players and their best score, where each player
// # appears only once on the high score list.

// ### Input:
// Alice 50
// Joe 20
// Ben 65
// Alice 55
// Alice 65
// Joe 30
// Charlie 21

// ### Output
// Ben 65
// Alice 65
// Joe 30
// Charlie 21
// ...(up to 50 entries)


class Solution {

    // ### Write your solution below
    public static void printHighScores(List<String> names, List<Integer> scores) {
        // Sort scores
        TreeSet<KeyValuePair> keyValuePairs = new TreeSet<>();
        for (int i = 0; i < names.size(); i++) {
            // Check if entry already exists
            // Change existing entry if value larger
            keyValuePairs.add(new KeyValuePair(names.get(i), scores.get(i)));
        }

        keyValuePairs.forEach(System.out::println);
    }

    static class KeyValuePair implements Comparable<KeyValuePair> {
        private String key;
        private Integer value;

        public KeyValuePair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(KeyValuePair keyValuePair) {
            return keyValuePair.value.compareTo(value);
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }

    public static void main(String[] args) {
        // Alice 50
// Joe 20
// Ben 65
        List names = Arrays.asList("Alice", "Joe", "Ben", "Alice");
        List scores = Arrays.asList(50, 20, 65, 55);
        printHighScores(names, scores);
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java " + Runtime.version().feature());

//     strings.stream().filter(s -> s.startsWith("3")).collect(Collectors.toList());
//     int x = 2;
//     if(1==1) {
//             x++;
//     } 
//     for (String string : strings) {
//       System.out.println(string);
//     }
    }
}

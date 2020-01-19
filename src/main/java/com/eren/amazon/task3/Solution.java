package com.eren.amazon.task3;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        int minDays = 0;
        boolean allUpdated = grid.stream().flatMap(List::stream).allMatch(e -> e == 1);
        while (!allUpdated) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid.get(i).get(j) == 1) {
                        if (j + 1 < columns && grid.get(i).get(j + 1) == 0) {
                            grid.get(i).set(j + 1, 2);
                        }
                        if (j - 1 >= 0 && grid.get(i).get(j - 1) == 0) {
                            grid.get(i).set(j - 1, 2);
                        }
                        if (i + 1 < rows && grid.get(i + 1).get(j) == 0) {
                            grid.get(i + 1).set(j, 2);
                        }
                        if (i - 1 >= 0 && grid.get(Math.max(0, i - 1)).get(j) == 0) {
                            grid.get(i - 1).set(j, 2);
                        }
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid.get(i).get(j) == 2) {
                        grid.get(i).set(j, 1);
                    }
                }
            }
            minDays++;
            allUpdated = grid.stream().flatMap(List::stream).allMatch(e -> e == 1);
        }
        return minDays;
        // METHOD SIGNATURE ENDS
    }
}
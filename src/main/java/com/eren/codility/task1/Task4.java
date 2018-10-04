package com.eren.codility.task1;

public class Task4 {

    public int solution(String S) {

        String[] tiles = S.split(",");
        int maxMatch = 1, match = 1;
        for (int i = 0; i < tiles.length - 1; i++) {
            if(tiles[i].charAt(2) == tiles[i+1].charAt(0)) {
                match ++;
            } else {
                maxMatch = Math.max(match, maxMatch);
                match = 1;
            }
        }
        maxMatch = Math.max(match, maxMatch);
        return maxMatch;
    }
}


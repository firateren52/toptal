package com.eren.codility.task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LiveTask1 {

    public int decksOfCards(String[] cards, String S) {
        char[] decks = "23456789TJQKA".toCharArray();
        Arrays.sort(decks);

        List<String> listS = Arrays.stream(cards).filter(card -> String.valueOf(card.charAt(1)).equals(S)).collect(Collectors.toList());
        String newListS = "";
        for(String s: listS) {
            newListS = newListS.concat(s);
        }
        char[] newCharS = newListS.toCharArray();
        Arrays.sort(newCharS);
        int count = Arrays.equals(decks, newCharS) ? 1 : 0;
        return count;
    }

    public int countDecksOfCards(String[] cards) {
        String str = "SCHD";
        int count = 0;
        for(int i = 0; i < str.length(); i ++) {
            int newCount = decksOfCards(cards, String.valueOf(str.charAt(i)));
            count += newCount;
        }
        return count;
    }
}

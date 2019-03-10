package com.eren.revolut;

import java.util.HashMap;
import java.util.Map;

public class CharUtil {

    /*
    * count all occurences of characters in input
    * @param input
    * @return character occurence count map
    */
    public Map<Character, Integer> getCharCounts(String input) {
        Map<Character, Integer> charCounts = new HashMap<>();
        if(input != null) {
            for (int i = 0; i < input.length(); i++) {
                Character ch = Character.valueOf(input.charAt(i));
                Integer count = charCounts.get(ch);
                Integer newCount = count == null ? 1 : count + 1;
                charCounts.put(ch, newCount);
            }
        }
        return charCounts;
    }

    /*
     * count all occurences of characters in input
     * @param input
     * @return character occurence count map
     */
    public Map<Character, Integer> getCharCounts_v2(String input) {
        Map<Character, Integer> charCounts = new HashMap<>();
        if(input != null) {
            for (char ch: input.toCharArray()) {
                Integer count = charCounts.get(ch);
                Integer newCount = count == null ? 1 : count + 1;
                charCounts.put(ch, newCount);
            }
        }
        return charCounts;
    }
}

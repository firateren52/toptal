package com.eren.thetradedesk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {

    public static void main(String[] args) {
        //String[] strings = {"greeneggs", "ham", "sam", "i", "am"};

        File file = new File("/Users/omerfarukeren/Downloads/input005.txt");
        Scanner scr = null;
        try {
            scr = new Scanner(file);
            int count = scr.nextInt();
            String[] strings = new String[count];
            int i = 0;
            while (scr.hasNext()) {
                strings[i] = scr.next();
                i++;
            }

            long time = System.nanoTime();
            String output = MergeStrings(strings);
            //System.out.println(output);
            System.out.println("time:" + (System.nanoTime() - time));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static String MergeStrings(String[] strings) {
        StringBuilder output = new StringBuilder();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Map<Character, Integer> letterCount = new LinkedHashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            letterCount.put(alphabet[i], 0);
        }

        for (String word : strings) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Character letter = chars[i];
                Integer count = letterCount.get(letter);
                if (count != null) {
                    letterCount.put(letter, count + 1);
                }
            }
        }

        letterCount.forEach((letter, count) -> {
            for (int i = 0; i < count; i++) {
                output.append(letter);
            }
        });
        return output.toString();
    }
}

package com.eren.babylonhealth;

import java.util.*;

public class Result2 {

    public static int zombieCluster(List<String> zombies) {
        // Write your code here
        Map<Integer, List<Integer>> clusters = new HashMap<>();
        for(int i = 0;i < zombies.size();i ++) {
            for(int j = i;j < zombies.size();j ++) {
                char value = zombies.get(i).charAt(j);

                int clusterI = findCluster(clusters, i);
                if(clusterI == -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    clusterI = clusters.size();
                    clusters.put(clusterI, list);
                }
                int clusterJ = findCluster(clusters, j);
                if(clusterJ == -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    clusterJ = clusters.size();
                    clusters.put(clusterJ, list);
                }

                if(value == '1' && (clusterI != clusterJ)) {
                    clusters.get(clusterI).addAll(clusters.get(clusterJ));
                    clusters.put(clusterI, clusters.get(clusterI));
                    clusters.remove(clusterJ);
                }
            }
        }
        return clusters.size();
    }

    private static int findCluster(Map<Integer, List<Integer>> clusters, int zombie) {
        for (Map.Entry<Integer, List<Integer>> entry : clusters.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            if(list.contains(zombie)) {
                return key;
            }
            // ...
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> lst = Arrays.asList( "1100","1110","0110","0001");
        System.out.println(zombieCluster(lst));
    }
}

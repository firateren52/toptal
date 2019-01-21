package com.eren.testdome;

import java.util.LinkedList;

//https://www.testdome.com/questions/java/train-composition/21568?visibility=1&skillId=4&orderBy=Difficulty
public class TrainComposition {
    LinkedList<Integer> trains = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        trains.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        trains.add(wagonId);
    }

    public int detachWagonFromLeft() {
        return trains.removeFirst();
    }

    public int detachWagonFromRight() {
        return trains.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        tree.attachWagonFromLeft(5);
        tree.attachWagonFromRight(8);
        tree.detachWagonFromLeft();
        tree.detachWagonFromRight();
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
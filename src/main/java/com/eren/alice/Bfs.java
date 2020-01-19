package com.eren.alice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Breadth First Traversal of a tree
 */
public class Bfs {
    /*
             ___A___
          __B__     C__
        _D    _E_     _F_
       G     H   I   J   K
    
    Expected output: A-B-C-D-E-F-G-H-I-J-K
    */
    public static void main(String[] args) {
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        Node D = new Node("D", G);
        Node E = new Node("E", H, I);
        Node F = new Node("F", J, K);
        Node B = new Node("B", D, E);
        Node C = new Node("C", F);
        Node A = new Node("A", B, C);
        // here you go

        bfs(A);
    }

    private static void bfs(Node node) {
        String output = "";
        Queue<Node> list = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            Node n = list.poll();
            output += n.name + "-";
            list.addAll(n.children);
        }
        System.out.println(output);
    }

    static class Node {
        String name;
        List<Node> children;

        public Node(String name, Node... children) {
            this.name = name;
            this.children = Arrays.asList(children);
        }
    }
}
package com.eren.skyscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// find common least ancestor for given two nodes
public class BinaryTreeLCA {

    static class Node {
        private String data;
        private Node left, right, parent;

        public Node(String data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public String getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setChildren(Node node) {
            if(getLeft() == null)
                setLeft(node);
            else if(getRight() == null)
                setRight(node);
            else
                throw new RuntimeException("Node children are full " + node);
        }


        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }
    }

    static class BinaryTree {
        private Node root;

        public BinaryTree(String rootData) {
            root = new Node(rootData, null);
        }

        private Node findNode(String data, Node node) {

            if (node == null) {
                return null;
            }
            if (node.getData().equals(data)) {
                return node;
            } else if (node.getLeft() != null && node.getLeft().getData().equals(data)) {
                return node.getLeft();
            } else if (node.getRight() != null && node.getRight().getData().equals(data)) {
                return node.getRight();
            }

            Node left = findNode(data, node.getLeft());
            if (left != null) {
                return left;
            }
            Node right = findNode(data, node.getRight());
            return right;
        }

        private Node findLCA(Node firstNode, Node secondNode) {
            List<Node> firstNodeAncestors = new ArrayList<Node>();
            Node firstParent = firstNode.getParent();
            while(firstParent != null) {
                firstNodeAncestors.add(firstParent);
                firstParent = firstParent.getParent();
            }

            Node secondParent = firstNode.getParent();
            while(secondParent != null && !firstNodeAncestors.contains(secondParent)) {
                secondParent = secondParent.getParent();
            }
            return secondParent;
        }
    }

    static void OutputCommonManager(int count, Scanner in) {
        in.nextLine();
        String first = in.nextLine();
        String second = in.nextLine();
        int i = 0;
        BinaryTree binaryTree = null;
        Node node = null;
        while(in.hasNext()) {
            String[] employees = in.nextLine().split(" ");
            if(binaryTree == null) {
                binaryTree = new BinaryTree(employees[0]);
                node = binaryTree.root;
            } else {
                node = binaryTree.findNode(employees[0], binaryTree.root);
            }
            node.setChildren(new Node(employees[1], node));

            i ++;
        }

        Node firstNode = binaryTree.findNode(first, binaryTree.root);
        Node secondNode = binaryTree.findNode(second, binaryTree.root);
        Node claNode = binaryTree.findLCA(firstNode, secondNode);
        System.out.println(claNode.data);
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        OutputCommonManager(count, scan);
    }

// sample data
//5
//a
//d
//a b
//a c
//b d
//b e
//c f
//c g


}

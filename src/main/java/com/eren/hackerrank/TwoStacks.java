package com.eren.hackerrank;

import java.util.*;

public class TwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<E> {
    Deque<E> fifo = new LinkedList<E>();
    Deque<E> lifo = new LinkedList<E>();

    public void enqueue(E e) {
        fifo.addLast(e);
        lifo.addFirst(e);
    }

    public void dequeue() {
        fifo.removeFirst();
        lifo.removeLast();
    }

    public E peek() {
        //return fifo.getFirst();
        return lifo.getLast();
    }
}


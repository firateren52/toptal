package com.eren.practice.stream;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        String x = "   abc   ";
        x.trim();
        x.substring(1);
        System.out.println("Result=" + x);

        Product p = new Product(1, "10" );
        Product p2 = new Product(1, "10" );
        System.out.println(p.equals(p2));
        System.out.println(p.hashCode() - p2.hashCode());

        ArrayList<Product> list = new ArrayList<>();
        list.add(p);
        list.add(p2);
        System.out.println(list.size());
        System.out.println(list.contains(new Product(1, "10")));

        HashSet<Product> set = new HashSet<>();
        set.add(p);
        set.add(p2);
        System.out.println(set.size());
        System.out.println(set.contains(new Product(1, "10")));

    }
}

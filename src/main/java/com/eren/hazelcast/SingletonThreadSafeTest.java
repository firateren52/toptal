package com.eren.hazelcast;

import java.util.stream.IntStream;

public class SingletonThreadSafeTest {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        IntStream.range(0,10000).forEach(i -> {
            Object safeObject = SharedObject.retrieve();
        });
        long duration = System.currentTimeMillis() - now;
        System.out.println("currentTimeMillis: " + duration);

    }
}

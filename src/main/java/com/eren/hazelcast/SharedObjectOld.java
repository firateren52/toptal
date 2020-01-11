package com.eren.hazelcast;

class SharedObjectOld {
    private static final Object LOCK = new Object();
    private static Object o = null;

    public static Object retrieve() {
        if (o == null) {
            synchronized (LOCK) {
                o = create();
            }
        }
        return o;
    }

    private static Object create() {
        // mock implementation, would actually return a useful object
        return new Object();
    }
}
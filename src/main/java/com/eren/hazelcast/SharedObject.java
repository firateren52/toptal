package com.eren.hazelcast;

class SharedObject {
    private static Object o = null;

    private static class SingletonHolder {
        private static final Object o = create();
    }

    public static Object retrieve() {
        return SingletonHolder.o;
    }

    private static Object create() {
        // mock implementation, would actually return a useful object
        return new Object();
    }
}
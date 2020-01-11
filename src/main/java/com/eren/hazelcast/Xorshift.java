package com.eren.hazelcast;

final class Xorshift {

    /**
     * Generate the next pseudorandom number for the provided <i>seed</i>.
     *
     * @param seed random number seed
     * @return the next pseudorandom number
     */
    long next(long seed) {
        seed = seed ^ seed << 21;
        seed = seed ^ seed >>> 35;
        return seed ^ seed << 4;
    }
}
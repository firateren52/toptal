package com.eren.thetradedesk.cache;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        SetAssociativeCacheRunner.parseInput(System.in);
    }

    /**
     * Parses Test Case input to instantiate and invoke a SetAssociativeCache
     *
     * NOTE: You can typically ignore anything in here. Feel free to collapse...
     */
    static class SetAssociativeCacheRunner {
        public static void parseInput(InputStream inputStream) throws IOException {
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);

            String line;
            int lineCount = 0;
            SetAssociativeCache<String, String> cache = null;

            while (!isNullOrEmpty(line = reader.readLine())) {
                lineCount++;
                OutParam<String> replacementAlgoName = new OutParam<>();

                if (lineCount == 1) {

                    cache = createCache(line, replacementAlgoName);

                } else {

                    // All remaining lines invoke instance methods on the SetAssociativeCache
                    Object retValue = SetAssociativeCacheFactory.InvokeCacheMethod(line, cache);

                    // Write the method's return value (if any) to stdout
                    if (retValue != null) {
                        System.out.println(retValue);
                    }
                }
            }
        }
    }

    private static SetAssociativeCache<String, String> createCache(String inputLine, OutParam<String> replacementAlgoName) {
        String[] cacheParams = Arrays.stream(inputLine.split(",")).map(s -> s.trim()).toArray(n -> new String[n]);
        int setCount = Integer.parseInt(cacheParams[0]);
        int setSize = Integer.parseInt(cacheParams[1]);
        replacementAlgoName.value = cacheParams[2];
        return SetAssociativeCacheFactory.CreateStringCache(setCount, setSize, replacementAlgoName.value);
    }


    // ############################ BEGIN Solution Classes ############################

    /**
     * NOTE: You are free to modify anything below, except for class names and generic interface.
     * Other public interface changes may require updating one or more of the helper classes above
     * for test cases to run and pass.
     * <p>
     * A Set-Associative Cache data structure with fixed capacity.
     * <p>
     * - Data is structured into setCount # of setSize-sized sets.
     * - Every possible key is associated with exactly one set via a hashing algorithm
     * - If more items are added to a set than it has capacity for (i.e. > setSize items),
     *      a replacement victim is chosen from that set using an algorithm.
     * <p>
     * NOTE: Part of the exercise is to allow for different kinds of replacement algorithms...
     */
    public static class SetAssociativeCache<TKey, TValue> {
        private final int Capacity;
        private final int SetSize;
        private final int SetCount;
        private final CacheSet<TKey, TValue>[] Sets;
        private final IReplacementAlgo<TKey> replacementAlgo;

        public SetAssociativeCache(int setCount, int setSize, IReplacementAlgo<TKey> replacementAlgo) {
            this.SetCount = setCount;
            this.SetSize = setSize;
            this.Capacity = this.SetCount * this.SetSize;
            this.replacementAlgo = replacementAlgo;

            // Initialize the sets
            this.Sets = new CacheSet[this.SetCount];
            for (int i = 0; i < this.SetCount; i++) {
                Sets[i] = new CacheSet<>(setSize);
            }
        }

        /** Gets the value associated with `key`. Throws if key not found. */
        public TValue get(TKey key) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            return set.get(key);
        }

        /**
         * Adds the `key` to the cache with the associated value, or overwrites the existing key.
         * If adding would exceed capacity, an existing key is chosen to replace using an LRU algorithm
         * (NOTE: It is part of this exercise to allow for more replacement algos)
         */
        public void set(TKey key, TValue value) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            set.set(key, value, replacementAlgo);
        }

        /** Returns the count of items in the cache */
        public int getCount() {
            int count = 0;
            for (int i = 0; i < this.Sets.length; i++) {
                count += this.Sets[i].getCount();
            }
            return count;
        }

        /** Returns `true` if the given `key` is present in the set; otherwise, `false`. */
        public boolean containsKey(TKey key) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            return set.containsKey(key);
        }

        /** Maps a key to a set */
        private int getSetIndex(TKey key) {
            /** uses hashCode of the key object and convert it to a non-negative value. This is a more efficient implementation
             * than the previous one and also ensure that it always returns same index for same keys
             */
            return (key.hashCode() & 0x7fffffff) % this.SetCount;
        }

    }

    /**
     * An internal thread-safe data structure representing one set in a N-Way Set-Associative Cache.
     * HashMap provides a more efficient data structure(O(1) for get and set operations) than
     *  the previous array-based data structure(O(n) for get and set operations)
     */
    static class CacheSet<TKey, TValue> {
        private final int Capacity;
        private final Map<TKey, TValue> Store;
        private final LinkedList<TKey> UsageTracker;
        private int Count = 0;

        public CacheSet(int capacity) {
            this.Capacity = capacity;
            this.UsageTracker = new LinkedList<>();
            this.Store = new HashMap<>(capacity);
        }

        /** Gets the value associated with `key`. Throws if key not found.*/
        public synchronized TValue get(TKey key) {
            // If the key is present, update the usage tracker
            if (this.Store.containsKey(key)) {
                this.recordUsage(key);
            } else {
                throw new RuntimeException(String.format("The key '%s' was not found", key));
            }

            return this.Store.get(key);
        }

        /**
         * Adds the `key` to the cache with the associated value, or overwrites the existing key.
         * If adding would exceed capacity, an existing key is chosen to replace using replacement algorithm
         * (NOTE: It is part of this exercise to allow for more replacement algos)
         */
        public synchronized void set(TKey key, TValue value, IReplacementAlgo<TKey> replacementAlgo) {
            if (containsKey(key)) {
                this.Store.put(key, value);

            } else {
                // If the set is at it's capacity
                if (this.Count == this.Capacity) {
                    // Find existing key, which will be replaced according to cache replacement algorithm
                    TKey keyToReplace = replacementAlgo.getKey(this.UsageTracker);

                    // Remove the existing key
                    this.removeKey(keyToReplace);
                }

                this.Store.put(key, value);
                this.Count++;

            }

            this.recordUsage(key);
        }

        /** Returns `true` if the given `key` is present in the set; otherwise, `false`. */
        public synchronized boolean containsKey(TKey key) {
            return this.Store.containsKey(key);
        }

        public int getCount() {
            return this.Count;
        }

        private void removeKey(TKey key) {
            if (containsKey(key)) {
                this.UsageTracker.remove(key);
                this.Store.remove(key);
                this.Count--;
            }
        }

        private void recordUsage(TKey key) {
            this.UsageTracker.remove(key);
            this.UsageTracker.addFirst(key);
        }
    }

    public final static String LruAlgorithm = "LRUReplacementAlgo";
    public final static String MruAlgorithm = "MRUReplacementAlgo";

    /**
     * A common interface for replacement algos, which decide which item in a CacheSet to evict
     */
    interface IReplacementAlgo<TKey> {
        TKey getKey(LinkedList<TKey> UsageTracker);
    }

    //Least-Recently-Used (LRU) algorithm will replace, which will be at the tail of the usage tracker
    static class LRUReplacementAlgo<TKey> implements IReplacementAlgo<TKey> {
        @Override
        public TKey getKey(LinkedList<TKey> UsageTracker) {
            return UsageTracker.getLast();
        }
    }

    //Most-Recently-Used (MRU) algorithm will replace, which will be at the head of the usage tracker
    static class MRUReplacementAlgo<TKey> implements IReplacementAlgo<TKey> {
        @Override
        public TKey getKey(LinkedList<TKey> UsageTracker) {
            return UsageTracker.getFirst();
        }
    }

    // ############################ BEGIN Helper Classes ############################
    // NOTE: Your code in the classes below will not be evaluated as part of the exericse.
    // They are just used by the stub code in the header to help run HackerRank test cases.
    // You may need to make small modifications to these classes, depending on your interface design,
    // for tests to run and pass, but it is not a core part of the exercise
    //
    static class OutParam<T> {
        public T value;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static class SetAssociativeCacheFactory {
        /// NOTE: replacementAlgoName is provided in case you need it here. Whether you do will depend on your interface design.
        public static SetAssociativeCache<String, String> CreateStringCache(int setCount, int setSize, String replacementAlgoName) {
            IReplacementAlgo replacementAlgo = ReplacementAlgoFactory.createReplacementAlgo(replacementAlgoName);
            return new SetAssociativeCache<>(setCount, setSize, replacementAlgo);
        }

        /// NOTE: Modify only if you change the main interface of SetAssociativeCache
        public static Object InvokeCacheMethod(String inputLine, SetAssociativeCache<String, String> cacheInstance) {
            String[] callArgs = Arrays.stream(inputLine.split(",", -1)).map(a -> a.trim()).toArray(n -> new String[n]);

            String methodName = callArgs[0].toLowerCase();
            //String[] callParams = Arrays.copyOfRange(callArgs, 1, callArgs.length - 1); // TODO: This is unused

            switch (methodName) {
                case "get":
                    return cacheInstance.get(callArgs[1]);
                case "set":
                    cacheInstance.set(callArgs[1], callArgs[2]);
                    return null;
                case "containskey":
                    return cacheInstance.containsKey(callArgs[1]);
                case "getcount":
                    return cacheInstance.getCount();

                default:
                    throw new RuntimeException(String.format("Unknown method name '{%s}'", methodName));
            }
        }
    }

    // to a IReplacementAlgo instance for the interface you design
    public static class ReplacementAlgoFactory {
        static IReplacementAlgo createReplacementAlgo(String replacementAlgoName) {
            switch (replacementAlgoName) {
                case LruAlgorithm:
                    return new LRUReplacementAlgo();
                case MruAlgorithm:
                    return new MRUReplacementAlgo();
                default:
                    throw new RuntimeException(String.format("Unknown replacement algo '%s'", replacementAlgoName));
            }
        }
    }

    // ^^ ######################### END Helper Classes ######################### ^^

}
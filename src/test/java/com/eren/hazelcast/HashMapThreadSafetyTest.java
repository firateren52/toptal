package com.eren.hazelcast;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HashMapThreadSafetyTest {

    private class LongKey {
        private long key;
        private final int DUMMY_HASH_KEY = 3432;

        public LongKey(long key) {
            this.key = key;
        }

        public long getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LongKey that = (LongKey) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(DUMMY_HASH_KEY);
        }
    }

    @Test
    @Ignore
    public void shouldBreakThreadSafetyOfHashMap() throws InterruptedException {
        final Map<Integer, String> map = new HashMap<>();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 2; i++) {

            final int number = i;

            new Thread(() -> {
                boolean contains;
                int count = 0;
                do {
                    map.put(number, "test");
                    count++;
                } while ((contains = (map.get(number) != null)));
                System.out.println("point2 number: " + number + " count: " + count);

                if (!contains) {
                    System.out.println("Missing Number: " + number);
                }

                countDownLatch.countDown();
            }).start();

        }

        assertTrue(countDownLatch.await(30, SECONDS));

    }

    @Test
    public void shouldBreakThreadSafetyOfHashMap_sameBucket() throws InterruptedException {
        final Map<LongKey, String> map = new HashMap<>();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 5; i++) {

            final LongKey number = new LongKey(i);

            new Thread(() -> {
                boolean contains, contains2;
                int count = 0;
                do {
                    map.put(number, "test");
                    count++;
                    contains2 = map.get(number) != null;
                } while ((contains = (map.remove(number) != null)));

                if (!contains) {
                    System.out.println("Missing number: " + number.getKey() + " count: " + count);
                    System.out.println("contains2: " + contains2);
                }

                countDownLatch.countDown();
            }).start();

        }

        assertTrue(countDownLatch.await(30, SECONDS));

    }

    @Test
    @Ignore
    public void shouldBreakThreadSafetyOfHashMap_sameBucketImproved() throws InterruptedException {
        final Map<LongKey, String> map = new HashMap<>();
        final int threadCount = 10;
        final int numberCount = 1000;
        final int maxNumber = threadCount * numberCount;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int start = i * numberCount + 1;
            final int end = start + numberCount;
            new Thread(() -> {
                int count = 0;
                for (int j = start; j <= end; j++) {
                    LongKey number = new LongKey(j);
                    map.put(number, "test");
                    //map.remove(number);
                    count++;
                }

                countDownLatch.countDown();
            }).start();

        }
        countDownLatch.await();
        long actualTotalSum = map.keySet().stream().mapToLong(LongKey::getKey).sum();
        long totalSum = maxNumber * (maxNumber + 1) / 2;
        assertNotEquals(actualTotalSum, totalSum);
    }

    @Test
    @Ignore
    public void testHashMapIsNotThreadSafe_sameBucket() throws InterruptedException {
        final Map<LongKey, String> map = new HashMap<>();
        final int threadCount = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        AtomicLong totalSum = new AtomicLong();

        IntStream.of(threadCount).forEach(i -> {
            final int number = i;

            new Thread(() -> {
                long seed = System.nanoTime() + this.hashCode();
                for (int j = 0; j < 10; j++) {
                    map.put(new LongKey(seed), "test" + seed);
                    totalSum.addAndGet(seed);
                    seed = Xorshift.next(seed);
                }
                countDownLatch.countDown();
            }).start();

        });

        countDownLatch.await();
        long actualTotalSum = map.keySet().stream().mapToLong(LongKey::getKey).sum();
        assertNotEquals(actualTotalSum, totalSum.get());

    }

    @Test
    @Ignore
    public void testHashMapIsNotThreadSafe() throws InterruptedException {
        final Map<Long, String> map = new HashMap<>();
        final int threadCount = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        AtomicLong totalSum = new AtomicLong();

        IntStream.of(threadCount).forEach(i -> {
            final int number = i;

            new Thread(() -> {
                long seed = System.nanoTime() + this.hashCode();
                for (int j = 0; j < 1000; j++) {
                    map.put(seed, "test" + seed);
                    totalSum.addAndGet(seed);
                    map.remove(seed);
                    map.put(seed, "test" + seed);

                    seed = Xorshift.next(seed);
                }
                countDownLatch.countDown();
            }).start();

        });

        countDownLatch.await(30, SECONDS);
        long actualTotalSum = map.keySet().stream().mapToLong(e -> e).sum();
        assertNotEquals(actualTotalSum, totalSum.get());

    }

    final static class Xorshift {

        static long next(long seed) {
            seed = seed ^ seed << 21;
            seed = seed ^ seed >>> 35;
            return seed ^ seed << 4;
        }
    }
}
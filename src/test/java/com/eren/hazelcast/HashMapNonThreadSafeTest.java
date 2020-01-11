package com.eren.hazelcast;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class HashMapNonThreadSafeTest {

    @Test
    public void testHashMap_givenSameBucketUpdateOperations_thenShouldProveNonThreadSafe() throws InterruptedException {
        final Map<DummyKey, String> map = new HashMap<>();
        final int threadCount = 10;
        final int operationCount = 10000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        final AtomicInteger failedOperationCount = new AtomicInteger();

        IntStream.range(0, threadCount).forEach(i -> {
            final DummyKey key = new DummyKey(i);
            new Thread(() -> {
                for (int j = 0; j < operationCount; j++) {
                    map.put(key, "operation" + i);
                    if (map.remove(key) == null) {
                        failedOperationCount.incrementAndGet();
                    }
                }

                countDownLatch.countDown();
            }).start();

        });

        System.out.println("Elements haven't found in the map " + failedOperationCount.get() + "/" + (threadCount * operationCount) + " times !");

        assertTrue(countDownLatch.await(30, SECONDS));
        assertTrue(failedOperationCount.get() > 0);

    }

    private class DummyKey {
        private long key;
        private final int DUMMY_HASH_KEY = 3432;

        public DummyKey(long key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DummyKey that = (DummyKey) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(DUMMY_HASH_KEY);
        }
    }
}

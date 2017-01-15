package org.otheralgor.collections;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ReadList implements Callable<Long>{

    private int start;
    private int end;
    private List<Integer> list;
    private CountDownLatch latch;

    public ReadList(List<Integer> list, CountDownLatch latch, int startPosition, int endPosition) {
        this.list = list;
        this.latch = latch;
        this.start = startPosition;
        this.end = endPosition;
    }

    @Override
    public Long call() throws Exception {
        latch.await();

        long startTime = System.nanoTime();

        for (int i = start ; i < end; i++) {
            list.get(i);
        }

        return System.nanoTime() - startTime;
    }
}

package org.otheralgor.collections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class Producer implements Runnable {

    private SynchronousQueue<Integer> queue;
    private CountDownLatch latch;

    public Producer(SynchronousQueue<Integer> queue, CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                latch.await();
                Thread.sleep(500);
                System.out.println("put 1");
                queue.put(1);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

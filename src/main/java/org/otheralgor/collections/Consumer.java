package org.otheralgor.collections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

public class Consumer implements Runnable {

    private SynchronousQueue<Integer> queue;
    private CountDownLatch latch;

    public Consumer(SynchronousQueue<Integer> queue, CountDownLatch latch){
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                latch.await();
                Thread.sleep(1000);
                System.out.println("take 1");
                System.out.println(queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

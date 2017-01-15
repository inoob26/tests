package org.otheralgor.cuncurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Operations2 {
    /*
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Account acc1 = new Account(1000);
        Account acc2 = new Account(2000);

        Random random = new Random();

        try {
            executorService.awaitTermination(10, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

        for (int i = 0; i< 10;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Transfer(acc1,acc2,random.nextInt(400),i));
        }

        executorService.shutdown();

    }*/
}

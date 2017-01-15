package org.otheralgor.cuncurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Account {
    private int balance;
    private Lock lock;
    private AtomicInteger failCounter;

    public void incFailedTransferCount(){
        failCounter.incrementAndGet();
    }


    public Account(int b){
        this.balance = b;
        lock = new ReentrantLock();
        failCounter = new AtomicInteger(0);
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }
}

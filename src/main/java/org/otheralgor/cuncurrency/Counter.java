package org.otheralgor.cuncurrency;



public class Counter {
    int c1 = 0;
    int c2 = 0;

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void inc1(){
        synchronized (lock1){
            c1++;
        }
    }

    public void inc2(){
        synchronized (lock2){
            c2++;
        }
    }

    public int getC1(){
        return c1;
    }

    public int getC2(){
        return c2;
    }
}

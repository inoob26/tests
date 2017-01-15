package org.otheralgor.cuncurrency;

import java.util.concurrent.*;

public class Transfer implements Callable<Boolean> {

    private Account account1;
    private Account account2;
    private int amount;
    private int id;
    private CountDownLatch countDownLatch;


    public Transfer(Account accountFrom,Account accountTo,int amount,int id,CountDownLatch countDownLatch){
        this.account1 = accountFrom;
        this.account2 = accountTo;
        this.amount = amount;
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Waiting to start");
        countDownLatch.await();
        try {
            if (account1.getLock().tryLock(1000, TimeUnit.NANOSECONDS)) {
                System.out.println("id: " + id + "try to withdraw: " + amount);
                if (account1.getBalance() < amount){
                    throw new InsufficientFundsException();
                }

                try {
                    if (account2.getLock().tryLock(1,TimeUnit.SECONDS)) {

                        System.out.println("id: " + id + "try to deposit: " + amount);
                        if (account2.getBalance() < amount) {
                            throw new InsufficientFundsException();
                        }
                        account1.withdraw(amount);
                        account2.deposit(amount);

                        Thread.sleep(2000);
                        System.out.println("transfer success!!!");
                    }else {
                        return false;
                    }
                }finally {
                    account2.getLock().unlock();
                }
            }else {
                account1.incFailedTransferCount();
                System.out.println("sorry");
                return false;
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            account1.getLock().unlock();
        }

        return true;
    }
}



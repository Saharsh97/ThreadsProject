package com.example.threaddemo.backup.deadlocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task1 implements Runnable {

    Lock l1;
    Lock l2;

    public Task1(Lock l1, Lock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public void run() {
        try {
            l1.lock();
            System.out.println("T1 got the lock on L1");

            Thread.sleep(5000);

            System.out.println("T1 trying to acquire lock on L2");
            boolean ableToGetLock = l2.tryLock(10, TimeUnit.SECONDS);  // T1 waits forever for this l2 lock to be available
            System.out.println("T1 got the lock? " + ableToGetLock);
        } catch (Exception e){
            System.out.println("error occurred in T1");
        }
    }
}

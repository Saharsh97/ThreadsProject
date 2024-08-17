package com.example.threaddemo.backup.deadlocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task2 implements Runnable{


    Lock l1;
    Lock l2;

    public Task2(Lock l1, Lock l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public void run() {
        try {
            l2.lock();
            System.out.println("T2 got the lock on L2");

            System.out.println("T2 trying to acquire lock on L1");
            boolean ableToGetLock = l1.tryLock(5, TimeUnit.SECONDS);  // T2 waits forever for this l2 lock to be available
            if(ableToGetLock) {
                //
            }
            else {
                System.out.println("T2 got the lock? " + ableToGetLock);
            }
        } catch (Exception e){
            System.out.println("error occurred in T2");
        }
    }
}

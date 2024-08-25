package com.example.threaddemo.ThreadSleep;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " sending query to DB...");
            Thread.sleep(9000);
            System.out.println(Thread.currentThread().getName() + " is done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

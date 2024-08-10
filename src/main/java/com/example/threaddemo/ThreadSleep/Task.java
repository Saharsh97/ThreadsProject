package com.example.threaddemo.ThreadSleep;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " sending query to DB...");
            System.out.println("waiting for DB response");
            System.out.println("a = b");
            Thread.sleep(7000);
            System.out.println(Thread.currentThread().getName() + " is done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

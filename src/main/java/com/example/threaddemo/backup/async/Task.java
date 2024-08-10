package com.example.threaddemo.backup.async;

public class Task implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " doing some task ...");
            Thread.sleep(7000);
//            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

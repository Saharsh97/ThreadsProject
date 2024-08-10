package com.example.threaddemo.backup.simple;

public class NumberPrinterTask implements Runnable {

    int number;

    public NumberPrinterTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("number " + number + " by thread " + Thread.currentThread().getName());
    }
}

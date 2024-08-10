package com.example.threaddemo.simple;

public class NumberPrinterTask implements Runnable{
    private int number;

    public NumberPrinterTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("number is " + number + " printed by " + Thread.currentThread().getName());
    }
}

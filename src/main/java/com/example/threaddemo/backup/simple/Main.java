package com.example.threaddemo.backup.simple;

public class Main {
    public static void main(String[] args) {
        System.out.println("Thread " + Thread.currentThread().getName());

        for(int i = 0; i < 100; i ++){
            NumberPrinterTask numberPrinterTask = new NumberPrinterTask(i);
            Thread t = new Thread(numberPrinterTask);
            t.start();
        }
    }
}

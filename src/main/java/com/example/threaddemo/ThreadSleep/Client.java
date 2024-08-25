package com.example.threaddemo.ThreadSleep;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("main hitting cache...");
        Thread.sleep(3000);
        System.out.println("main done!");
    }
}

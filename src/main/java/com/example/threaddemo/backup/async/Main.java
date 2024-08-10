package com.example.threaddemo.backup.async;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();     // given to the CPU scheduler. Now the Scheduler will decide when to run it.
        System.out.println("main start");
        Thread.sleep(3000);
        System.out.println("main end");
        thread.join();
        System.out.println("end");
    }
}

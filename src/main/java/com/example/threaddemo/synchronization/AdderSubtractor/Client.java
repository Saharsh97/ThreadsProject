package com.example.threaddemo.synchronization.AdderSubtractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread thread1 = new Thread(adder);
        Thread thread2 = new Thread(subtractor);

        thread1.start();
        thread2.start();

        thread1.join(); // wait for t1 to complete
        thread2.join(); // wait for t2 to complete

        System.out.println(count.val);
    }
}

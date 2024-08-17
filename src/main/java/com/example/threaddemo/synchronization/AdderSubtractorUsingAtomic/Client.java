package com.example.threaddemo.synchronization.AdderSubtractorUsingAtomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        AtomicReference<Object> array = new AtomicReference<>(null);



        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread thread1 = new Thread(adder);
        Thread thread2 = new Thread(subtractor);

        thread1.start();
        thread2.start();

        thread1.join(); // wait for t1 to complete
        thread2.join(); // wait for t2 to complete

        System.out.println(count.get());
    }
}

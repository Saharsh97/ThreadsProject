package com.example.threaddemo.synchronization.AdderSubtractorUsingAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable{

    AtomicInteger count;

    public Adder(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++){
            count.addAndGet(1);
        }
    }
}

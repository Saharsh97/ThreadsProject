package com.example.threaddemo.backup.synchronization.AdderSubtractorUsingAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable{

    AtomicInteger count;

    public Adder(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            count.addAndGet(1);
        }
    }
}

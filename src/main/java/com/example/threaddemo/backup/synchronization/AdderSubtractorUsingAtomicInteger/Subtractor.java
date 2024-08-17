package com.example.threaddemo.backup.synchronization.AdderSubtractorUsingAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtractor implements Runnable{
    AtomicInteger count;

    public Subtractor(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            count.addAndGet(-1);
        }
    }
}

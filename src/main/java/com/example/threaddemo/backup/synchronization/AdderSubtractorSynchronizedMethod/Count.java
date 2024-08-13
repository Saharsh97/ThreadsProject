package com.example.threaddemo.backup.synchronization.AdderSubtractorSynchronizedMethod;

public class Count {
    int val = 0;

    synchronized void increment(){
        val += 1;
    }

    synchronized void decrement(){
        val -= 1;
    }
}

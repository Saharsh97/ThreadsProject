package com.example.threaddemo.synchronization.AdderSubstractorUsingSynchonizedMethods;

public class Count {
    int val = 0;

    synchronized void increment() {
        val += 1;
    }

    synchronized void decrement() {
        val -= 1;
    }

    int getVal(){
        return val;
    }
}

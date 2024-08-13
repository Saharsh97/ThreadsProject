package com.example.threaddemo.synchronization.AdderSubstractorUsingSynchonizedMethods;

public class Adder implements Runnable{

    Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++){
            count.increment();
        }
    }
}

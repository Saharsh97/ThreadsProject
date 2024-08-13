package com.example.threaddemo.backup.synchronization.AdderSubtractorProblem;

public class Adder implements Runnable{

    Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            count.val += 1;
        }
    }
}

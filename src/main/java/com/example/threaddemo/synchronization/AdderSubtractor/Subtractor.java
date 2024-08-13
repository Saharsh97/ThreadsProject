package com.example.threaddemo.synchronization.AdderSubtractor;

public class Subtractor implements Runnable{
    Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++){
            count.val -= 1;
        }
    }
}

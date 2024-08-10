package com.example.threaddemo.backup.synchronization;

public class Subtractor implements Runnable{
    Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++){
            count.val -= 1;
        }
    }
}

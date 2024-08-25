package com.example.threaddemo.futures;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Engineer: Doing the calculation");
        Thread.sleep(5000);
        System.out.println("Engineer: work done");
        System.out.println("hello");
        System.out.println("there");
        System.out.println("world");
        return 100;
    }
}

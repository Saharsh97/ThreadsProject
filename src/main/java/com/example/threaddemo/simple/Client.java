package com.example.threaddemo.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {
    public static void main(String[] args) {
//        System.out.println("main start");
//        for(int i = 0; i < 100; i++){
//            NumberPrinterTask task = new NumberPrinterTask(i);
//            Thread thread = new Thread(task);
//            thread.start();
//        }

//        Executor executor = Executors.newFixedThreadPool(10);
        Executor executor = Executors.newCachedThreadPool();
        for(int i = 1; i <= 100; i++){
            NumberPrinterTask task = new NumberPrinterTask(i);
            executor.execute(task);
            if( i == 5 || i == 15 || i == 40 || i == 80 || i == 100){
                System.out.println("DEBUG");
            }
        }

        Callable<String> r;
        System.out.println("main done");
    }
}

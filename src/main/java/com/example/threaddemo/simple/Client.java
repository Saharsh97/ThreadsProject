package com.example.threaddemo.simple;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        System.out.println("main start");
//        for(int i = 0; i < 100; i++){
//            if(i == 5 || i == 10 || i == 70){
//                System.out.println("DEBUG");
//            }
//            NumberPrinterTask task = new NumberPrinterTask(i);
//            Thread thread = new Thread(task);
//            thread.start();
//        }

        Executor executor = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++){
            if( i == 5 || i == 15 || i == 40 || i == 80 || i == 99){
                System.out.println("DEBUG");
            }
            NumberPrinterTask task = new NumberPrinterTask(i);
            executor.execute(task);
        }
        System.out.println("main done");
    }
}

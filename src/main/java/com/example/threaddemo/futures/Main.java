package com.example.threaddemo.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Task task = new Task();

        System.out.println("created task");
        Future<Integer> future = executorService.submit(task);

        System.out.println("work assigned to Engineer");
        System.out.println("I'll go to cafe");
        System.out.println("I'll go for a movie");

        // check if the work is done by the engineer
        System.out.println("checking if the work is done");
        if(future.isDone()){
            System.out.println("my employee is great");
            return;
        }
        System.out.println("my employee is nithalla");
        System.out.println("I should wait for the work to be completed.");

        Integer result = future.get();  // makes the Main wait.

        System.out.println("got the data " + result);
    }
}

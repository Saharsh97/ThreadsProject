package com.example.threaddemo.backup.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arr = new ArrayList<>(List.of( 9, 12, 7, 0, 3, 10, 8, 6, 2));
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Sorter sorter = new Sorter(arr, executorService);
        Future<List<Integer>> sortedArrayFuture = executorService.submit(sorter);
        List<Integer> sortedArray = sortedArrayFuture.get();

        for(int x: sortedArray){
            System.out.print(x + " ");
        }
    }
}

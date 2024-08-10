package com.example.threaddemo.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>(
                List.of(9, 12, 8, 0, 4, 2, 3,10, 7, 10, 29, 10, 18, 16, 32, 21)
        );
        ExecutorService executor = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(list, executor);
        System.out.println("submitting tasks");
        Future<List<Integer>> sortedArrayFuture = executor.submit(sorter);
        System.out.println("lets go to cafeteria..");

        List<Integer> sortedArray = sortedArrayFuture.get(); // waiting for the result!
        System.out.println(sortedArray);
        System.out.println(((ThreadPoolExecutor)executor).getLargestPoolSize());
    }
}

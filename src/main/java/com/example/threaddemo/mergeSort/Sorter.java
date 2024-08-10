package com.example.threaddemo.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Runnable -> void run -> nothing to return
// Callable
public class Sorter implements Callable<List<Integer>> {

    List<Integer> arrayToSort;
    ExecutorService executor;

    public Sorter(List<Integer> arrayToSort, ExecutorService executor) {
        this.arrayToSort = arrayToSort;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int size = arrayToSort.size();
        int mid = size / 2;
        List<Integer> leftArrayToSort = arrayToSort.subList(0, mid);
        List<Integer> rightArrayToSort = arrayToSort.subList(mid, arrayToSort.size());

        // create the tasks
        Sorter leftSorter = new Sorter(leftArrayToSort, executor);
        Sorter rightSorter = new Sorter(rightArrayToSort, executor);

        Future<List<Integer>> leftArrayFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightArrayFuture = executor.submit(rightSorter);
        // ........
        // ........

        // eventually, I will be waiting to get some data
        // from the guy I have given the task.
        List<Integer> leftSortedArray = leftArrayFuture.get();
        List<Integer> rightSortedArray = rightArrayFuture.get();

        // simple merge sort
        List<Integer> resultArray = new ArrayList<>();
        int i = 0; int j = 0;
        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                resultArray.add(leftSortedArray.get(i));
                i++;
            } else {
                resultArray.add(rightSortedArray.get(j));
                j++;
            }
        }
        while(i < leftSortedArray.size()){
            resultArray.add(leftSortedArray.get(i));
            i++;
        }
        while(j < rightSortedArray.size()){
            resultArray.add(rightSortedArray.get(j));
            j++;
        }
        return resultArray;
    }
}

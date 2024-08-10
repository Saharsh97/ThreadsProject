package com.example.threaddemo.backup.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        int mid = arrayToSort.size()/2;
        List<Integer> leftArray = arrayToSort.subList(0, mid);
        List<Integer> rightArray = arrayToSort.subList(mid, arrayToSort.size());

        Sorter leftArraySortTask = new Sorter(leftArray, executorService);
        Sorter rightArraySortTask = new Sorter(rightArray, executorService);

        Future<List<Integer>> futureLeftSortedArray = executorService.submit(leftArraySortTask);
        Future<List<Integer>> futureRightSortedArray = executorService.submit(rightArraySortTask);

        // do your own stuff here, let the two arrays compute in their own time.
//        System.out.println("lets go to the cafeteria in the mean time");
        // now its time to merge the results.
        // I will need to actually get the results before I start merging.

        List<Integer> leftSortedArray = futureLeftSortedArray.get();
        List<Integer> rightSortedArray = futureRightSortedArray.get();

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


//    public List<Integer> mergeSort(List<Integer> arr){
//        if(arr.size() == 1){
//            return arr;
//        }
//        leftArray = ...
//        rightArray = ...
//        leftSortedArray = mergeSort(leftArray);
//        rightSortedArray = mergeSort(rightArray);
//        return merge(leftSortedArray, rightSortedArray);
//    }

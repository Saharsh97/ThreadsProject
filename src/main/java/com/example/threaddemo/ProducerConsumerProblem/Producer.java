package com.example.threaddemo.ProducerConsumerProblem;

import java.util.Queue;

public class Producer implements Runnable{
    Queue<Object> queue;
    int maxSize;

    public Producer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                if(queue.size() < maxSize){
                    System.out.println("Producer " + Thread.currentThread().getName() + " entered, current queue size " + queue.size());
                    queue.add(new Object());
                    System.out.println("Producer " + Thread.currentThread().getName() + " left, current queue size " + queue.size());
                    System.out.println();
                }
            }
        }
    }
}

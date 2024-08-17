package com.example.threaddemo.ProducerConsumerProblem;

import java.util.Queue;

public class Consumer implements Runnable{
    Queue<Object> queue;
    int maxSize;

    public Consumer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                if(queue.size() > 0){
                    System.out.println("Consumer " + Thread.currentThread().getName() + " entered, current queue size " + queue.size());
                    queue.remove();
                    System.out.println("Consumer " + Thread.currentThread().getName() + " left, current queue size " + queue.size());
                    System.out.println();
                }
            }
        }
    }
}

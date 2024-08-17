package com.example.threaddemo.ProducerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Queue<Object> queue;
    int maxSize;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Producer(Queue<Object> queue, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            try {
                if(queue.size() < maxSize) {
                    producerSemaphore.acquire();

                    System.out.println("Producer " + Thread.currentThread().getName() + " entered, current queue size " + queue.size());
                    queue.add(new Object());
                    System.out.println("Producer " + Thread.currentThread().getName() + " left, current queue size " + queue.size());
                    System.out.println();

                    consumerSemaphore.release();
                }
            } catch (Exception e) {
                System.out.println("error occurred in Producer");
            }
        }
    }
}

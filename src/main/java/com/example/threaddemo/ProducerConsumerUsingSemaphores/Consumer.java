package com.example.threaddemo.ProducerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Queue<Object> queue;
    int maxSize;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    public Consumer(Queue<Object> queue, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){
            try {
                if(queue.size() > 0) {
                    consumerSemaphore.acquire();    // decrements the consumerSemaphore count.

                    System.out.println("Consumer " + Thread.currentThread().getName() + " entered, current queue size " + queue.size());
                    queue.remove();
                    System.out.println("Consumer " + Thread.currentThread().getName() + " left, current queue size " + queue.size());
                    System.out.println();

                    producerSemaphore.release();    // increment the producerSemaphore count
                }
            } catch (Exception e) {
                System.out.println("error occurred in Producer");
            }
        }
    }
}

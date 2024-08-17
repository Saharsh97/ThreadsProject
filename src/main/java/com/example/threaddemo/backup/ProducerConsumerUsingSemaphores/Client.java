package com.example.threaddemo.backup.ProducerConsumerUsingSemaphores;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> queue = new ArrayDeque<>();
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0); // important

        Producer producer1 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);
        Producer producer2 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);
        Producer producer3 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);
        Producer producer4 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);
        Producer producer5 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);
        Producer producer6 = new Producer(queue, 6, producerSemaphore, consumerSemaphore);

        Consumer consumer1 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);
        Consumer consumer2 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);
        Consumer consumer3 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);
        Consumer consumer4 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);
        Consumer consumer5 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);
        Consumer consumer6 = new Consumer(queue, 6, producerSemaphore, consumerSemaphore);

        Thread thread1 = new Thread(producer1);
        thread1.start();
        Thread thread2 = new Thread(producer2);
        thread2.start();
        Thread thread3 = new Thread(producer3);
        thread3.start();
        Thread thread4 = new Thread(producer4);
        thread4.start();
        Thread thread5 = new Thread(producer5);
        thread5.start();
        Thread thread6 = new Thread(producer6);
        thread6.start();
        Thread thread7 = new Thread(consumer1);
        thread7.start();
        Thread thread8 = new Thread(consumer2);
        thread8.start();
        Thread thread9 = new Thread(consumer3);
        thread9.start();
        Thread thread10 = new Thread(consumer4);
        thread10.start();
        Thread thread11 = new Thread(consumer5);
        thread11.start();
        Thread thread12 = new Thread(consumer6);
        thread12.start();
    }
}

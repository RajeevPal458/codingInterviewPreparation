package org.interview.questions;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    static volatile AtomicInteger num=new AtomicInteger(0);
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                queue.put(num.getAndIncrement());  // Add item to the queue
                System.out.println("Produced: " + num.get());
                Thread.sleep(2500);  // Simulate time taken to produce an item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();  // Take item from the queue
                System.out.println("Consumed: " + item);
                Thread.sleep(1000);  // Simulate time taken to consume an item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerProblemUsinglockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);  // Queue with capacity of 5
        
        Thread producerThread = new Thread(new Producer(queue));
        Thread producerThread2 = new Thread(new Producer(queue));
        Thread producerThread3 = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        producerThread2.start();
        producerThread3.start();
        consumerThread.start();
    }
}

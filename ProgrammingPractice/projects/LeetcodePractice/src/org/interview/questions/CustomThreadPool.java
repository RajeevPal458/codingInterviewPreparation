package org.interview.questions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Worker[] workers;

    public CustomThreadPool(int numThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            workers[i] = new Worker(taskQueue);
            workers[i].start();  // Start each worker thread
        }
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);  // Add the task to the queue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutDown() {
        for (Worker worker : workers) {
            worker.shutDown();
        }
    }
}


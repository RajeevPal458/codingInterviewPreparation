package org.interview.questions;

import java.util.concurrent.BlockingQueue;

class Worker extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isRunning = true;

    public Worker(BlockingQueue<Runnable> queue) {
        this.taskQueue = queue;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                Runnable task = taskQueue.take();  // Get task from the queue
                task.run();  // Execute the task
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Re-interrupt in case of termination
        }
    }

    public void shutDown() {
        isRunning = false;
        this.interrupt();  // Exit if waiting on a task
    }
}


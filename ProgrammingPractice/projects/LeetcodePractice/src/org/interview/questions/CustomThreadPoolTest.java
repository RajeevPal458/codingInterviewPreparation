package org.interview.questions;

public class CustomThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool threadPool = new CustomThreadPool(4);  // Create a pool with 4 threads

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            Thread.sleep(400);
            threadPool.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
            });
        }

        threadPool.shutDown();
    }
}


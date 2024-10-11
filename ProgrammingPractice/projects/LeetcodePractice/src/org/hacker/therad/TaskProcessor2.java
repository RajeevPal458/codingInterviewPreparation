package org.hacker.therad;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TaskProcessor2 {

    // Concurrent map to store locks for each unique task
    private static final Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // List of tasks (strings)
        List<String> tasks = Arrays.asList("aa", "bb", "cc", "aa", "aa", "dd", "ee", "bb");

        // ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (String task : tasks) {
            executorService.submit(() -> processTask(task));
        }

        executorService.shutdown();
    }

    public static void processTask(String task) {
        // Get or create a lock for the task
        ReentrantLock lock = lockMap.computeIfAbsent(task, key -> new ReentrantLock());

        lock.lock(); // Acquire the lock for the task
        try {
            // Process the task
            System.out.println(Thread.currentThread().getName() + " is processing task: " + task);
            Thread.sleep(2000); // Simulate task processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Release the lock
            // Optionally remove the lock from the map if no longer needed
            lockMap.remove(task, lock); // Remove only if it is still mapped to the same lock
        }
    }
}


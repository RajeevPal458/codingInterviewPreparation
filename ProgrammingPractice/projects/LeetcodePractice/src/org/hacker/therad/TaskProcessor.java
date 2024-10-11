package org.hacker.therad;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * write a java multithreading program given an List of String list element denote as a task to process some of the string is duplicates so if one same task in process then other same string task has to wait Example : arr= {“aa”, ” bb”,  ”cc”, “aa”, “aa”, “dd”, “ee”, “bb”};
Process all msg parallelly but duplicate msg has to wait completed other same task
 */
public class TaskProcessor {

    // Map to hold the locks for each unique task
    private static final Map<String, Object> lockMap = new HashMap<>();

    public static void main(String[] args) {
        // List of tasks (strings)
        List<String> tasks = Arrays.asList("aa", "bb", "cc", "aa", "aa", "dd", "ee", "bb");

        // Create and start a thread for each task
        for (String task : tasks) {
            new Thread(() -> processTask(task)).start();
        }
    }

    public static void processTask(String task) {
        Object lock;

        synchronized (lockMap) {
            // Get or create a lock for the task
            lock = lockMap.computeIfAbsent(task, key -> new Object());
            //lockMap.forEach((k,v)->System.out.println(k+" "));
        }

        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is processing task: " + task);
                // Simulate task processing
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                synchronized (lockMap) {
                    // Remove the lock when done processing
                    lockMap.remove(task, lock);
                    lock.notifyAll(); // Notify other threads waiting on this lock
                }
            }
        }
    }
}
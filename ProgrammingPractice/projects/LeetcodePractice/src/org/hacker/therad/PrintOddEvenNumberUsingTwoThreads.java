package org.hacker.therad;

class MyCounterThread implements Runnable {
    private static int counter = 0;
    private final int maxSize;
    private final int remainder;
    private final Object obj;

    public MyCounterThread(int maxSize, int remainder, Object obj) {
        this.maxSize = maxSize;
        this.remainder = remainder;
        this.obj = obj;
    }

    @Override
    public void run() {
        while (counter <= maxSize) {
            synchronized (obj) {
                while (counter % 2 != remainder) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (counter <= maxSize) {  // Check again to avoid extra print when counter exceeds maxSize
                    System.out.println(counter + " - " + Thread.currentThread().getName());
                    counter++;
                }
                obj.notifyAll();
            }
        }
    }
}

public class PrintOddEvenNumberUsingTwoThreads {
    public static void main(String[] args) {
        Object obj = new Object();
        MyCounterThread evenThread = new MyCounterThread(10, 0, obj);
        MyCounterThread oddThread = new MyCounterThread(10, 1, obj);

        Thread even = new Thread(evenThread, "Even Thread");
        Thread odd = new Thread(oddThread, "Odd Thread");

        even.start();
        odd.start();
    }
}

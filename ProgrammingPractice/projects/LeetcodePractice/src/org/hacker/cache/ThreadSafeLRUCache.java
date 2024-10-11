package org.hacker.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUCache<K, V> {
    private final Map<K, V> cache;
    private final int capacity;
    private final Lock lock = new ReentrantLock();

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        lock.lock();
        try {
            return cache.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public V remove(K key) {
        lock.lock();
        try {
            return cache.remove(key);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadSafeLRUCache<Integer, String> lruCache = new ThreadSafeLRUCache<>(3);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        System.out.println(lruCache.cache); // Output: {1=one, 2=two, 3=three}

        // Access some elements
        lruCache.get(1);
        lruCache.put(4, "four"); // Removes the least recently used (2)

        System.out.println(lruCache.cache); // Output: {3=three, 1=one, 4=four}
    }
}

package org.hacker.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUCacheLinkedList<K, V> {
    private final int capacity;
    private final LinkedList<K> list;
    private final HashMap<K, V> map;
    private final Lock lock;

    public ThreadSafeLRUCacheLinkedList(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public V get(K key) {
        lock.lock();
        try {
            if (!map.containsKey(key)) {
                return null;
            }
            // Move the accessed key to the front (most recently used)
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                // Update the value and move the key to the front
                list.remove(key);
            } else if (list.size() >= capacity) {
                // Evict the least recently used key
                K lruKey = list.removeLast();
                map.remove(lruKey);
            }
            list.addFirst(key);
            map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public V remove(K key) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                list.remove(key);
                return map.remove(key);
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
    	ThreadSafeLRUCacheLinkedList<Integer, String> cache = new ThreadSafeLRUCacheLinkedList<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache.map);  // Output: {1=one, 2=two, 3=three}

        cache.get(1);
        cache.put(4, "four");  // Evicts the least recently used item (2)
        System.out.println(cache.map);  // Output: {1=one, 3=three, 4=four}
    }
}

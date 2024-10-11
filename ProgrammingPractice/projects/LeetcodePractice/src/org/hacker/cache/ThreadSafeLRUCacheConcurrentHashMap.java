package org.hacker.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUCacheConcurrentHashMap<K, V> {
    private final int capacity;
    private final ConcurrentHashMap<K, Node> cache;
    private final DoublyLinkedList list;
    private final Lock lock = new ReentrantLock();

    class Node {
        K key;
        V value;
        Node prev;
        Node next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList() {
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public void moveToHead(Node node) {
            remove(node);
            addFirst(node);
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public ThreadSafeLRUCacheConcurrentHashMap(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.list = new DoublyLinkedList();
    }

    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) return null;
        lock.lock();
        try {
            list.moveToHead(node);
        } finally {
            lock.unlock();
        }
        return node.value;
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                list.moveToHead(node);
            } else {
                if (cache.size() >= capacity) {
                    Node last = list.removeLast();
                    if (last != null) {
                        cache.remove(last.key);
                    }
                }
                Node newNode = new Node(key, value);
                list.addFirst(newNode);
                cache.put(key, newNode);
            }
        } finally {
            lock.unlock();
        }
    }

    public V remove(K key) {
        lock.lock();
        try {
            Node node = cache.remove(key);
            if (node != null) {
                list.remove(node);
                return node.value;
            }
            return null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
    	ThreadSafeLRUCacheConcurrentHashMap<Integer, String> cache = new ThreadSafeLRUCacheConcurrentHashMap<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        System.out.println(cache.get(1)); // Output: "one"
        cache.put(4, "four");  // Evicts the least recently used (2)
        System.out.println(cache.get(2)); // Output: null (evicted)
    }
}

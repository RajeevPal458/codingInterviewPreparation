package org.hacker.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLRUCacheOwnDoublyLinkedList<K, V> {
	private final int capacity;
    private final Map<K, Node> cache;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private Node head, tail;

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

    public ThreadSafeLRUCacheOwnDoublyLinkedList(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    // Move node to the front (head)
    private void moveToHead(Node node) {
        if (node == head) return;
        removeNode(node);
        addNodeToHead(node);
    }

    // Add node to the front (head)
    private void addNodeToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    // Remove node from its current position
    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;  // Node is head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;  // Node is tail
        }
    }

    // Remove the tail node (LRU)
    private Node removeTail() {
        Node lru = tail;
        if (tail != null) {
            removeNode(tail);
        }
        return lru;
    }

    public V get(K key) {
        readLock.lock();
        try {
            if (!cache.containsKey(key)) {
                return null;
            }
            Node node = cache.get(key);
            writeLock.lock();
            try {
                moveToHead(node);
            } finally {
                writeLock.unlock();
            }
            return node.value;
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V value) {
        writeLock.lock();
        try {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addNodeToHead(newNode);

                if (cache.size() > capacity) {
                    Node lruNode = removeTail();
                    cache.remove(lruNode.key);
                }
            }
        } finally {
            writeLock.unlock();
        }
    }

    public V remove(K key) {
        writeLock.lock();
        try {
            Node node = cache.remove(key);
            if (node != null) {
                removeNode(node);
                return node.value;
            }
            return null;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
    	ThreadSafeLRUCacheOwnDoublyLinkedList<Integer, String> cache = new ThreadSafeLRUCacheOwnDoublyLinkedList<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache.get(1));  // Output: "one"

        cache.put(4, "four");  // Evicts the least recently used (2)
        System.out.println(cache.get(2));  // Output: null (evicted)
    }
}

package org.example.Interview.JavaCollectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implement a Least Recently Used (LRU) Cache: Support get and put in O(1) using
 * LinkedHashMap or a custom Doubly LinkedList + HashMap.
 * SDET: Caching auth/session tokens or API responses in automation to avoid redundant network hits.
 */
public class Q05_LruCache {
    public static void main(String[] args) {
        LruCacheLinkedHashMap cache1 = new LruCacheLinkedHashMap(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println("LinkedHashMap get(1): " + cache1.get(1)); // 1
        cache1.put(3, 3); // evicts key 2
        System.out.println("LinkedHashMap get(2): " + cache1.get(2)); // -1

        LruCacheCustom cache2 = new LruCacheCustom(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println("Custom DLL get(1): " + cache2.get(1));
        cache2.put(3, 3);
        System.out.println("Custom DLL get(2): " + cache2.get(2));
    }

    // Best concise: LinkedHashMap access-order — O(1) get/put
    public static class LruCacheLinkedHashMap {
        private final LinkedHashMap<Integer, Integer> map;

        public LruCacheLinkedHashMap(int capacity) {
            this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }

    // Classic interview: HashMap + Doubly Linked List — O(1) get/put
    public static class LruCacheCustom {
        private static class Node {
            int key, value;
            Node prev, next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(0, 0);
        private final Node tail = new Node(0, 0);

        public LruCacheCustom(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            Node created = new Node(key, value);
            map.put(key, created);
            addToHead(created);
            if (map.size() > capacity) {
                Node removed = removeTail();
                map.remove(removed.key);
            }
        }

        private void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private Node removeTail() {
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }
}

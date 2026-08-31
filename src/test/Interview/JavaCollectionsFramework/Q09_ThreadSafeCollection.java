package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implement a Thread-Safe Collection: Compare Collections.synchronizedList() with
 * CopyOnWriteArrayList and ConcurrentHashMap. Explain when to use which.
 * SDET: Shared reports, parallel listeners, or drivers in TestNG/Cucumber parallel runs.
 *
 * When to use:
 * - synchronizedList: simple shared list, coarse lock, ok for low contention
 * - CopyOnWriteArrayList: many reads / rare writes (listener registries)
 * - ConcurrentHashMap: concurrent map access with fine-grained concurrency
 */
public class Q09_ThreadSafeCollection {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("synchronizedList: " + demoSynchronizedList());
        System.out.println("CopyOnWriteArrayList: " + demoCopyOnWriteArrayList());
        System.out.println("ConcurrentHashMap: " + demoConcurrentHashMap());
    }

    // Coarse-grained lock wrapping — whole list locked per operation
    public static List<Integer> demoSynchronizedList() throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Runnable writer = () -> {
            for (int i = 0; i < 500; i++) {
                list.add(i);
            }
        };
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(writer);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // iteration still needs manual sync:
        // synchronized (list) { for (Integer x : list) ... }
        return list;
    }

    // Snapshot on write — excellent for read-heavy listener lists
    public static List<String> demoCopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> listeners = new CopyOnWriteArrayList<>();
        listeners.add("ExtentReporter");
        listeners.add("AllureListener");
        // Safe to iterate without external sync even if another thread adds
        listeners.add("ConsoleLogger");
        return listeners;
    }

    // Fine-grained concurrent map — preferred shared key/value store
    public static Map<String, Integer> demoConcurrentHashMap() throws InterruptedException {
        ConcurrentHashMap<String, Integer> failures = new ConcurrentHashMap<>();
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                failures.merge("timeout", 1, Integer::sum);
            }
        };
        Thread t1 = new Thread(increment);
        Thread t2 = new Thread(increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return failures;
    }
}

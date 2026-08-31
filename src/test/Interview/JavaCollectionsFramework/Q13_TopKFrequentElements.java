package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * PriorityQueue for Top K Frequent Elements: Find top K most frequent error messages
 * using PriorityQueue (Min-Heap) + HashMap. Optimize to O(N log K).
 * SDET: Auto-triage reports to isolate the top flakiest test steps/errors.
 */
public class Q13_TopKFrequentElements {
    public static void main(String[] args) {
        List<String> logs = List.of(
                "timeout", "npe", "timeout", "assert", "timeout", "npe", "flake", "assert", "timeout"
        );
        System.out.println("Min-heap O(N log K) (best): " + topKUsingMinHeap(logs, 3));
        System.out.println("Max-heap: " + topKUsingMaxHeap(logs, 3));
        System.out.println("Sort all: " + topKUsingSort(logs, 3));
    }

    // Best: HashMap + min-heap of size K — O(N log K)
    public static List<String> topKUsingMinHeap(List<String> items, int k) {
        if (items == null || items.isEmpty() || k <= 0) {
            return List.of();
        }
        Map<String, Integer> freq = new HashMap<>();
        for (String item : items) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    // Max-heap of all unique keys — O(N + U log U)
    public static List<String> topKUsingMaxHeap(List<String> items, int k) {
        if (items == null || items.isEmpty() || k <= 0) {
            return List.of();
        }
        Map<String, Integer> freq = new HashMap<>();
        for (String item : items) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());
        List<String> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < k) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    // Least optimal relative to K: sort all entries — O(U log U)
    public static List<String> topKUsingSort(List<String> items, int k) {
        if (items == null || items.isEmpty() || k <= 0) {
            return List.of();
        }
        Map<String, Long> freq = items.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return freq.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

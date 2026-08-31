package org.example.Interview.JavaCollectionsFramework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find the Intersection of Multiple Sets: Return elements present in all given sets (retainAll).
 * SDET: Finding common test failure modes across Chrome/Firefox/Safari cross-browser runs.
 */
public class Q08_IntersectionOfMultipleSets {
    public static void main(String[] args) {
        List<Set<String>> sets = List.of(
                Set.of("timeout", "npe", "flake"),
                Set.of("timeout", "flake", "assert"),
                Set.of("flake", "timeout", "404")
        );
        System.out.println("retainAll (best): " + intersectionUsingRetainAll(sets));
        System.out.println("Stream reduce: " + intersectionUsingStream(sets));
        System.out.println("Manual count: " + intersectionUsingCount(sets));
    }

    // Best / clearest: copy first set then retainAll — O(n) relative to set sizes
    public static Set<String> intersectionUsingRetainAll(List<Set<String>> sets) {
        if (sets == null || sets.isEmpty()) {
            return Set.of();
        }
        Set<String> result = new HashSet<>(sets.get(0));
        for (int i = 1; i < sets.size(); i++) {
            result.retainAll(sets.get(i));
            if (result.isEmpty()) {
                break;
            }
        }
        return result;
    }

    // Stream reduce with retainAll on copies
    public static Set<String> intersectionUsingStream(List<Set<String>> sets) {
        if (sets == null || sets.isEmpty()) {
            return Set.of();
        }
        return sets.stream()
                .map(HashSet::new)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                })
                .orElseGet(HashSet::new);
    }

    // Count membership across all sets
    public static Set<String> intersectionUsingCount(List<Set<String>> sets) {
        if (sets == null || sets.isEmpty()) {
            return Set.of();
        }
        java.util.Map<String, Integer> count = new java.util.HashMap<>();
        for (Set<String> set : sets) {
            for (String value : set) {
                count.put(value, count.getOrDefault(value, 0) + 1);
            }
        }
        return count.entrySet().stream()
                .filter(e -> e.getValue() == sets.size())
                .map(java.util.Map.Entry::getKey)
                .collect(Collectors.toCollection(HashSet::new));
    }
}

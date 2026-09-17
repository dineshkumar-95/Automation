package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Remove Duplicates from ArrayList: Filter out duplicate entries from an ArrayList using a Set.
 */
public class Q04_RemoveDuplicatesFromArrayList {
    public static void main(String[] args) {
        List<String> list = List.of("Java", "Python", "Java", "C++", "Python", "Go");
        System.out.println("LinkedHashSet (best - keeps order): " + removeUsingLinkedHashSet(new ArrayList<>(list)));
        System.out.println("HashSet (no order guarantee): " + removeUsingHashSet(new ArrayList<>(list)));
        System.out.println("Stream distinct: " + removeUsingStream(new ArrayList<>(list)));
    }

    // Best when order matters: LinkedHashSet — O(n) time
    public static <T> List<T> removeUsingLinkedHashSet(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    // HashSet — O(n) time, order not preserved
    public static <T> List<T> removeUsingHashSet(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        Set<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Stream distinct — preserves encounter order
    public static <T> List<T> removeUsingStream(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}

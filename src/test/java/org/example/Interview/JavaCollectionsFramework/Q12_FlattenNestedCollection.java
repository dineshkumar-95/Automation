package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Flatten a Nested Collection: Flatten List&lt;List&lt;String&gt;&gt; into List&lt;String&gt;
 * using loops and Java 8 Streams (flatMap).
 * SDET: Aggregate elements from multiple dynamic tables/pages into one validation list.
 */
public class Q12_FlattenNestedCollection {
    public static void main(String[] args) {
        List<List<String>> nested = List.of(
                List.of("row1-col1", "row1-col2"),
                List.of("row2-col1"),
                List.of("row3-col1", "row3-col2", "row3-col3")
        );
        System.out.println("flatMap (best/modern): " + flattenUsingFlatMap(nested));
        System.out.println("Nested loops: " + flattenUsingLoops(nested));
        System.out.println("addAll: " + flattenUsingAddAll(nested));
    }

    // Best modern: Streams flatMap
    public static List<String> flattenUsingFlatMap(List<List<String>> nested) {
        if (nested == null || nested.isEmpty()) {
            return List.of();
        }
        return nested.stream()
                .filter(list -> list != null)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<String> flattenUsingLoops(List<List<String>> nested) {
        List<String> result = new ArrayList<>();
        if (nested == null) {
            return result;
        }
        for (List<String> inner : nested) {
            if (inner == null) {
                continue;
            }
            for (String value : inner) {
                result.add(value);
            }
        }
        return result;
    }

    public static List<String> flattenUsingAddAll(List<List<String>> nested) {
        List<String> result = new ArrayList<>();
        if (nested == null) {
            return result;
        }
        for (List<String> inner : nested) {
            if (inner != null) {
                result.addAll(inner);
            }
        }
        return result;
    }
}

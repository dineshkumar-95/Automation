package org.example.Interview.JavaCollectionsFramework;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Symmetric Difference of Two Sets: Elements in either set but not both —
 * (A ∪ B) \ (A ∩ B).
 * SDET: Compare pre/post-migration schemas or UI text baselines in regression.
 */
public class Q14_SymmetricDifference {
    public static void main(String[] args) {
        Set<String> a = Set.of("id", "name", "email", "status");
        Set<String> b = Set.of("id", "name", "phone", "address");
        System.out.println("Union - Intersection (best): " + symmetricDifferenceClassic(a, b));
        System.out.println("Two removeAll: " + symmetricDifferenceTwoDiffs(a, b));
        System.out.println("Stream filter: " + symmetricDifferenceStream(a, b));
    }

    // Best clear approach: (A ∪ B) - (A ∩ B)
    public static Set<String> symmetricDifferenceClassic(Set<String> a, Set<String> b) {
        if (a == null) {
            a = Set.of();
        }
        if (b == null) {
            b = Set.of();
        }
        Set<String> union = new HashSet<>(a);
        union.addAll(b);
        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        union.removeAll(intersection);
        return union;
    }

    // (A - B) ∪ (B - A)
    public static Set<String> symmetricDifferenceTwoDiffs(Set<String> a, Set<String> b) {
        if (a == null) {
            a = Set.of();
        }
        if (b == null) {
            b = Set.of();
        }
        Set<String> left = new HashSet<>(a);
        left.removeAll(b);
        Set<String> right = new HashSet<>(b);
        right.removeAll(a);
        left.addAll(right);
        return left;
    }

    public static Set<String> symmetricDifferenceStream(Set<String> a, Set<String> b) {
        if (a == null) {
            a = Set.of();
        }
        if (b == null) {
            b = Set.of();
        }
        Set<String> finalA = a;
        Set<String> finalB = b;
        return Stream.concat(a.stream(), b.stream())
                .filter(x -> finalA.contains(x) ^ finalB.contains(x))
                .collect(Collectors.toCollection(HashSet::new));
    }
}

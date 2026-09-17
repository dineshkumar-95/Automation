package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Identify Missing UI Steps (Sequence Tracking): Given executed step IDs like
 * [1, 2, 3, 5, 6], find the missing step assuming increments of 1.
 * SDET: Telemetry audit that analytics pixels fire in checkout funnel order.
 */
public class Q09_IdentifyMissingUiSteps {
    public static void main(String[] args) {
        int[] steps = {1, 2, 3, 5, 6};
        System.out.println("Sum formula (best single miss): " + findMissingSum(steps));
        System.out.println("Linear scan: " + findMissingScan(steps));
        System.out.println("All missing: " + findAllMissing(new int[]{1, 2, 4, 7}));
    }

    // Best when exactly one missing in contiguous range — O(n) / O(1)
    public static Integer findMissingSum(int[] steps) {
        if (steps == null || steps.length == 0) {
            return null;
        }
        int min = steps[0];
        int max = steps[0];
        int actual = 0;
        for (int step : steps) {
            actual += step;
            min = Math.min(min, step);
            max = Math.max(max, step);
        }
        int expected = (max * (max + 1) / 2) - ((min - 1) * min / 2);
        int missing = expected - actual;
        return missing == 0 ? null : missing;
    }

    // Compare consecutive values — O(n), assumes sorted input
    public static Integer findMissingScan(int[] steps) {
        if (steps == null || steps.length < 2) {
            return null;
        }
        for (int i = 1; i < steps.length; i++) {
            if (steps[i] != steps[i - 1] + 1) {
                return steps[i - 1] + 1;
            }
        }
        return null;
    }

    // Multiple gaps supported via Set — O(n)
    public static List<Integer> findAllMissing(int[] steps) {
        List<Integer> missing = new ArrayList<>();
        if (steps == null || steps.length == 0) {
            return missing;
        }
        int min = steps[0], max = steps[0];
        Set<Integer> present = new HashSet<>();
        for (int step : steps) {
            present.add(step);
            min = Math.min(min, step);
            max = Math.max(max, step);
        }
        for (int i = min; i <= max; i++) {
            if (!present.contains(i)) {
                missing.add(i);
            }
        }
        return missing;
    }
}

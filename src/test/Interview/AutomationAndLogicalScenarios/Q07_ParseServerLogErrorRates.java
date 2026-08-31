package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.Arrays;
import java.util.Locale;

/**
 * Parse Server Log Files for Error Rates: Calculate percentage of lines containing "ERROR".
 * SDET: Pipeline sanity gates that scan post-deploy logs to trigger rollbacks.
 */
public class Q07_ParseServerLogErrorRates {
    public static void main(String[] args) {
        String[] logs = {
                "[2026-07-30 10:15:22] INFO: User logged in",
                "[2026-07-30 10:15:25] ERROR: Connection timeout",
                "[2026-07-30 10:15:26] INFO: Retrying",
                "[2026-07-30 10:15:27] ERROR: DB unavailable",
                "[2026-07-30 10:15:28] WARN: Slow query"
        };
        System.out.println("Error rate % (best): " + String.format(Locale.US, "%.2f", errorRatePercent(logs)));
        System.out.println("Error count: " + countErrors(logs));
        System.out.println("Stream rate %: " + String.format(Locale.US, "%.2f", errorRatePercentStream(logs)));
    }

    // Best: single pass count — O(n)
    public static double errorRatePercent(String[] lines) {
        if (lines == null || lines.length == 0) {
            return 0.0;
        }
        int errors = countErrors(lines);
        return (errors * 100.0) / lines.length;
    }

    public static int countErrors(String[] lines) {
        if (lines == null) {
            return 0;
        }
        int count = 0;
        for (String line : lines) {
            if (line != null && line.contains("ERROR")) {
                count++;
            }
        }
        return count;
    }

    public static double errorRatePercentStream(String[] lines) {
        if (lines == null || lines.length == 0) {
            return 0.0;
        }
        long errors = Arrays.stream(lines)
                .filter(line -> line != null && line.contains("ERROR"))
                .count();
        return (errors * 100.0) / lines.length;
    }

    // Case-insensitive / level token check
    public static double errorRatePercentStrict(String[] lines) {
        if (lines == null || lines.length == 0) {
            return 0.0;
        }
        int errors = 0;
        for (String line : lines) {
            if (line != null && line.matches("(?i).*\\bERROR\\b.*")) {
                errors++;
            }
        }
        return (errors * 100.0) / lines.length;
    }
}

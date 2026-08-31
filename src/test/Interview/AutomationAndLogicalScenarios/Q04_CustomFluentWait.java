package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/**
 * Implement a Custom Fluent/Explicit Wait: Poll every 500ms up to a 10s timeout.
 * Ignore specific exceptions (e.g. NoSuchElementException) during polling.
 * SDET: Handle flaky UI transitions without hardcoded Thread.sleep().
 */
public class Q04_CustomFluentWait {
    public static final long DEFAULT_TIMEOUT_MS = 10_000;
    public static final long DEFAULT_POLL_MS = 500;

    public static void main(String[] args) throws Exception {
        // Simulate element becoming visible after ~1.2s
        final long readyAt = System.currentTimeMillis() + 1200;
        Boolean visible = waitUntil(() -> {
            if (System.currentTimeMillis() < readyAt) {
                throw new NoSuchElementException("element not found yet");
            }
            return true;
        }, DEFAULT_TIMEOUT_MS, DEFAULT_POLL_MS, NoSuchElementException.class);

        System.out.println("Fluent wait result: " + visible);
    }

    // Best: generic polling with ignored exceptions — O(timeout/poll) attempts
    @SafeVarargs
    public static <T> T waitUntil(Callable<T> condition, long timeoutMs, long pollMs,
                                  Class<? extends Exception>... ignored) throws Exception {
        long end = System.currentTimeMillis() + timeoutMs;
        Exception last = null;
        while (System.currentTimeMillis() < end) {
            try {
                T value = condition.call();
                if (value != null && (!(value instanceof Boolean) || Boolean.TRUE.equals(value))) {
                    return value;
                }
            } catch (Exception e) {
                if (!isIgnored(e, ignored)) {
                    throw e;
                }
                last = e;
            }
            Thread.sleep(pollMs);
        }
        throw new TimeoutException("Condition not met within " + timeoutMs + "ms"
                + (last != null ? "; last ignored: " + last : ""));
    }

    private static boolean isIgnored(Exception e, Class<? extends Exception>[] ignored) {
        if (ignored == null) {
            return false;
        }
        for (Class<? extends Exception> type : ignored) {
            if (type.isInstance(e)) {
                return true;
            }
        }
        return false;
    }

    // Stand-in for Selenium's exception in plain Java demos
    public static class NoSuchElementException extends RuntimeException {
        public NoSuchElementException(String message) {
            super(message);
        }
    }
}

package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Retry Mechanism for Flaky Network Requests: Retry a network-dependent block up to 3
 * times with 1 second wait between attempts, then fail.
 * SDET: Mitigate microservice instability or temporary CI/CD environment glitches.
 */
public class Q12_RetryMechanism {
    public static final int DEFAULT_MAX_ATTEMPTS = 3;
    public static final long DEFAULT_DELAY_MS = 1_000;

    public static void main(String[] args) throws Exception {
        AtomicInteger tries = new AtomicInteger();
        String result = retry(() -> {
            if (tries.incrementAndGet() < 3) {
                throw new RuntimeException("temporary network glitch");
            }
            return "OK-200";
        }, DEFAULT_MAX_ATTEMPTS, 100); // 100ms for demo speed
        System.out.println("Retry succeeded: " + result + " after " + tries.get() + " attempts");

        try {
            retry((Callable<Void>) () -> {
                throw new RuntimeException("always fails");
            }, 2, 50);
        } catch (Exception e) {
            System.out.println("Retry exhausted: " + e.getMessage());
        }
    }

    // Best: generic retry with delay — O(attempts)
    public static <T> T retry(Callable<T> action, int maxAttempts, long delayMs) throws Exception {
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("maxAttempts must be > 0");
        }
        Exception last = null;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                return action.call();
            } catch (Exception e) {
                last = e;
                if (attempt == maxAttempts) {
                    break;
                }
                Thread.sleep(delayMs);
            }
        }
        throw new RuntimeException("Failed after " + maxAttempts + " attempts", last);
    }

    public static void retryVoid(Runnable action, int maxAttempts, long delayMs) throws Exception {
        retry(() -> {
            action.run();
            return Boolean.TRUE;
        }, maxAttempts, delayMs);
    }
}

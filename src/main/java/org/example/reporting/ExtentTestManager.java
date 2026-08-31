package org.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

    private static final ExtentReports extent = ExtentManager.getReporter();
    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    public static void startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        threadLocal.set(test);
    }

    public static ExtentTest getTest() {
        return threadLocal.get();
    }

    public static void endTest() {
        threadLocal.remove();
    }

    public static void flushReport() {
        extent.flush();
    }
}

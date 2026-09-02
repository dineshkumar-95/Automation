package org.example.listeners;

import com.aventstack.extentreports.ExtentTest;
import org.example.driver.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.example.reporting.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener, IConfigurationListener {

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getClass().getName()+"."+result.getMethod().getMethodName();
        ExtentTestManager.startTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        test.log(Status.PASS, "Test passed");
        ExtentTestManager.endTest();
        ExtentTestManager.flushReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        logWithScreenshotBase64(test, Status.FAIL, result);
        ExtentTestManager.endTest();
        ExtentTestManager.flushReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        logWithScreenshotBase64(test, Status.SKIP, result);
        ExtentTestManager.endTest();
        ExtentTestManager.flushReport();
    }

    @Override
    public void onConfigurationFailure(ITestResult result) {
        String testName = result.getTestClass().getClass().getName()+"."+result.getMethod().getMethodName();
        // Create an Extent test if one doesn't already exist
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) {
            ExtentTestManager.startTest(testName);
            test = ExtentTestManager.getTest();
        }
        logWithScreenshotBase64(test, Status.FAIL, result);
        ExtentTestManager.endTest();
        ExtentTestManager.flushReport();
    }


    private void logWithScreenshotBase64(ExtentTest test, Status status, ITestResult result){
        if (result.getThrowable() != null) {
            test.log(status, result.getThrowable());
        } else if (status == Status.SKIP) {
            test.log(status, "Test skipped");
        } else {
            test.log(status, "Test failed");
        }
        
        WebDriver localDriver = DriverManager.getDriver();
        if (localDriver != null) {
            String base64 = ((TakesScreenshot) localDriver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(base64);
        }

    }
}

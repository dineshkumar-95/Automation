package listeners;

import com.aventstack.extentreports.ExtentTest;
import drivers.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extentreports.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String description = result.getMethod().getDescription();
        if (description == null) {
            description = result.getTestClass().getName();
        }
        ExtentTestManager.startTest(result.getMethod().getMethodName(), description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.log(Status.PASS, "Test passed");
        }
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            logWithScreenshot(test, Status.FAIL, result);
        }
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            logWithScreenshot(test, Status.SKIP, result);
        }
        ExtentTestManager.endTest();
    }

    private void logWithScreenshot(ExtentTest test, Status status, ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            logStatus(test, status, result);
            return;
        }

        try {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            saveScreenshotToFile(result, base64Screenshot);

            if (result.getThrowable() != null) {
                test.log(status, result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            } else {
                test.log(status, status == Status.SKIP ? "Test skipped" : "Test failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        } catch (Exception e) {
            logStatus(test, status, result);
            test.warning("Could not attach screenshot: " + e.getMessage());
        }
    }

    private void logStatus(ExtentTest test, Status status, ITestResult result) {
        if (result.getThrowable() != null) {
            test.log(status, result.getThrowable());
        } else if (status == Status.SKIP) {
            test.log(status, "Test skipped");
        } else {
            test.log(status, "Test failed");
        }
    }

    private void saveScreenshotToFile(ITestResult result, String base64Screenshot) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss");
        String fileName = result.getName() + "_" + dateFormat.format(new Date()) + ".png";
        File destination = new File(System.getProperty("user.dir") + "/test-output/screenshots/" + fileName);
        destination.getParentFile().mkdirs();
        byte[] bytes = java.util.Base64.getDecoder().decode(base64Screenshot);
        Files.write(destination.toPath(), bytes);
    }
}

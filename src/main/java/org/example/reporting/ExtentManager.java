package org.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;


    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/ExtentReport/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
//            sparkReporter.config().setDocumentTitle("Automation Report");
//            sparkReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
//            extent.setSystemInfo("OS", System.getProperty("os.name"));
//            extent.setSystemInfo("Java", System.getProperty("java.version"));
        }
        return extent;
    }
}

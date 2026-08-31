package org.example.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;
import java.util.HashMap;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static void init(String browserName, String platformName, String browserVersion) throws Exception {
        if (threadLocal.get() != null) {
            return;
        }
        if ((platformName != null && !platformName.trim().isEmpty()) || (browserVersion != null && !browserVersion.trim().isEmpty())){
            threadLocal.set(initLambdaTestDriver(browserName, platformName, browserVersion));
        } else {
            threadLocal.set(initLocalDriver(browserName));
        }
    }

    private static WebDriver initLambdaTestDriver(String browserName, String platformName, String browserVersion) throws Exception {
        String username = System.getenv("LT_USERNAME");
        if (username == null || username.trim().isEmpty()) {
            username = System.getProperty("LT_USERNAME");
        }

        String accessKey = System.getenv("LT_ACCESS_KEY");
        if (accessKey == null || accessKey.trim().isEmpty()) {
            accessKey = System.getProperty("LT_ACCESS_KEY");
        }

        if (username == null || accessKey == null || username.trim().isEmpty() || accessKey.trim().isEmpty()) {
            throw new IllegalStateException("LambdaTest credentials missing! Please set LT_USERNAME and LT_ACCESS_KEY environment variables or system properties.");
        }

        MutableCapabilities capabilities;
        if (browserName.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            capabilities = new FirefoxOptions();
        } else if (browserName.equalsIgnoreCase("edge")) {
            capabilities = new EdgeOptions();
        } else if (browserName.equalsIgnoreCase("safari")) {
            capabilities = new SafariOptions();
        } else {
            FirefoxOptions defaultOptions = new FirefoxOptions();
            defaultOptions.setCapability("browserName", browserName);
            capabilities = defaultOptions;
        }

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        if (platformName != null && !platformName.trim().isEmpty()) {
            ltOptions.put("platformName", platformName);
        }
        if (browserVersion != null && !browserVersion.trim().isEmpty()) {
            ltOptions.put("browserVersion", browserVersion);
        }
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("build", "TestNG LambdaTest Build");
        ltOptions.put("project", "Untitled1 Project");
        ltOptions.put("w3c", true);

        capabilities.setCapability("LT:Options", ltOptions);

        String gridUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
        return new RemoteWebDriver(new URL(gridUrl), capabilities);
    }

    private static WebDriver initLocalDriver(String browserName) throws Exception {

        if (browserName.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            if (System.getenv("CI") != null) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            return new FirefoxDriver(options);

        } else if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (System.getenv("CI") != null) {
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
            }

            return new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("edge")) {

            return new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("safari")) {

            return new SafariDriver();

        } else {

            throw new Exception(browserName + ":- Is not found");
        }
    }

    public static void quit() {
        WebDriver currentDriver = threadLocal.get();
        if (currentDriver != null) {
            currentDriver.quit();
            threadLocal.remove();
        }
    }
}

package org.example;

import org.example.api.ApiClient;
import org.example.api.services.CustomerApi;
import org.example.api.services.SubscriptionApi;
import org.example.config.ConfigManager;
import org.example.constants.Constants;
import org.example.driver.DriverManager;
import org.example.ui.pages.*;
import org.example.ui.pages.Customers.CustomerCreatePage;
import org.example.ui.pages.Customers.CustomerDetailsPage;
import org.example.ui.pages.Customers.CustomersIndexPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CustomerCreatePage customerCreatePage;
    protected CustomersIndexPage customersIndexPage;
    protected CustomerDetailsPage customerDetailsPage;
    protected CustomerApi customerApi;
    protected SubscriptionApi subscriptionApi;

    /** True only when a browser was initialised for this test class. */
    private boolean isUITest = false;

    public void setupTestClass() throws Exception{};

    @BeforeClass
    @Parameters({"browserName", "platformName", "browserVersion", "Test_Type", "siteName"})
    public void beforeClass(
            @Optional("firefox") String browserName,
            @Optional String platformName,
            @Optional String browserVersion,
            @Optional("UI") String testType,
            @Optional String siteName
    ) throws Exception {
        if (siteName != null && !siteName.isEmpty()) {
            ConfigManager.setSite(siteName);
        }
        
        if (testType.equalsIgnoreCase("api")) {
            setAPIClients(ConfigManager.getApiBaseUri(), ConfigManager.getApiKey());
            setupTestClass();
        }
        else {
            isUITest = true;
            DriverManager.init(browserName, platformName, browserVersion);
            setDrivers();
            setAPIClients(ConfigManager.getApiBaseUri(), ConfigManager.getApiKey());
            login();
            setupTestClass();
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (isUITest) {
            DriverManager.quit();
        }
    }

    private void setDrivers() {
        WebDriver driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        customerCreatePage = new CustomerCreatePage(driver);
        customerDetailsPage = new CustomerDetailsPage(driver);
        customersIndexPage = new CustomersIndexPage(driver);
    }

    private void setAPIClients(String apiBaseUrl, String apiKey) {
        ApiClient apiClient = new ApiClient(apiBaseUrl, apiKey);
        customerApi = new CustomerApi(apiClient);
        subscriptionApi = new SubscriptionApi(apiClient);
    }

    protected void login() {
        loginPage.loadURL(ConfigManager.getSiteUrl() + Constants.DASHBOARDS_PATH);
        loginPage.login(ConfigManager.getUsername(), ConfigManager.getPassword());
        homePage.waitForHomePageLoad();
    }
}

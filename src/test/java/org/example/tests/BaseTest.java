package org.example.tests;

import org.example.api.ApiClient;
import org.example.api.services.CustomerApi;
import org.example.api.services.SubscriptionApi;
import org.example.driver.DriverManager;
import org.example.constants.Constants;
import org.example.ui.pages.*;
import org.openqa.selenium.WebDriver;
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

    public abstract void setupTestClass() throws Exception;

    @BeforeClass
    @Parameters({"browserName", "platformName", "browserVersion", "apiBaseUrl", "apiKey", "Test_Type"})
    public void beforeClass(
            @Optional("firefox") String browserName,
            @Optional String platformName,
            @Optional String browserVersion,
            @Optional String apiBaseUrl,
            @Optional String apiKey,
            @Optional("UI") String testType
    ) throws Exception {
        if (testType.equalsIgnoreCase("api")) {
            setAPIClients(apiBaseUrl, apiKey);
            setupTestClass();
        }
        else {
            DriverManager.init(browserName, platformName, browserVersion);
            setDrivers();
            setAPIClients(apiBaseUrl, apiKey);
            login();
            setupTestClass();
        }
    }

    @AfterClass
    public void teardown() {
        DriverManager.quit();
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
        loginPage.loadURL(Constants.LOGIN_URL);
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        homePage.waitForHomePageLoad();
    }
}

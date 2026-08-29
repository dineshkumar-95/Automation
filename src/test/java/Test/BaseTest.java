package Test;

import api.ApiHelper;
import drivers.DriverManager;
import org.example.constants.Constants;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public CustomerCreatePage customerCreatePage;
    public CustomersIndexPage customersIndexPage;
    public CustomerDetailsPage customerDetailsPage;
    public ApiHelper apiHelper;

    public abstract void setupTestClass() throws Exception;

    @BeforeClass
    @Parameters({"browserName", "platformName", "browserVersion", "apiBaseUrl", "apiKey"})
    public void beforeClass(
            @Optional("firefox") String browserName,
            @Optional String platformName,
            @Optional String browserVersion,
            @Optional String apiBaseUrl,
            @Optional String apiKey
    ) throws Exception {
        DriverManager.init(browserName, platformName, browserVersion);
        setDrivers();
        apiHelper = new ApiHelper(apiBaseUrl, apiKey);
        login();
        setupTestClass();

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

    protected void login() {
        loginPage.loadURL(Constants.LOGIN_URL);
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        homePage.waitForHomePageLoad();
    }
}

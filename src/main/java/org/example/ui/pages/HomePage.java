package org.example.ui.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.ui.BasePage;
import org.example.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    Logger LOGGER = LogManager.getLogger(this.getClass());
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tab-customers")
    private WebElement customers_LeftNav;

    @FindBy(xpath = "//div[@class='cv-dboard']")
    private WebElement dashboard;

    public HomePage waitForHomePageLoad() {
        LOGGER.info("Waiting for page load to complete - Home Page");
        waitForElementToDisplay(dashboard);
        return this;
    }
    public HomePage verifyHomePageLoad() {
        Assert.assertTrue(dashboard.isDisplayed());
        return this;
    }
    public CustomersIndexPage navigateToCustomersIndexPage() {
        loadURL(Constants.CUSTOMERS_INDEX_PAGE_URL);
        return new CustomersIndexPage(driver);
    }
}

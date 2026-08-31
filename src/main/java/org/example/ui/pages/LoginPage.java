package org.example.ui.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.ui.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Logger LOGGER = LogManager.getLogger(this.getClass());

    @FindBy(id = "email")
    private WebElement txtUserName;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "sign-in-submit")
    private WebElement submitBtn;

    public void loadURL(String URL) {
        driver.get(URL);
    }

    public LoginPage waitForLoginPageLoad() {
        LOGGER.info("Waiting for page load to complete - Home Page");
        waitForElementToDisplay(txtUserName);
        return this;
    }


    public HomePage login(String UserName, String Password) {
        waitForLoginPageLoad();
        setText(txtUserName, UserName);
        setText(txtPassword, Password);
        submitBtn.click();
        return new HomePage(driver);
    }
}

package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersIndexPage extends BasePage {
    public CustomersIndexPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text() = 'Create Customer']")
    private WebElement createCustomerButton;
    By by_eCreateCustomerButton = By.xpath("//span[text() = 'Create Customer']");

    public CustomersIndexPage waitUntilCustomersPageLoad(){
        waitForElementToDisplay(createCustomerButton);
        return this;
    }

    public CustomerCreatePage clickCreateCustomerButton(){
        waitUntilCustomersPageLoad();
        createCustomerButton.click();
        return new CustomerCreatePage(driver);
    }


}

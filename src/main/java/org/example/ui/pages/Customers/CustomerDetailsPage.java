package org.example.ui.pages.Customers;

import org.example.ui.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerDetailsPage extends BasePage {
    public CustomerDetailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text() = 'Create Customer']")
    private WebElement Create_Customer_Button;

    public CustomerDetailsPage waitUntilCustomersPageLoad(){
        waitForElementToDisplay(Create_Customer_Button);
        return this;
    }

    public CustomerDetailsPage clickCreate_Customer_Button(){
        click(Create_Customer_Button);
        return this;
    }

    @FindBy(xpath = "//div[contains(@class,'s-flex s-flex-col s-gap-4')]/div[2]")
    private WebElement total_amount_due_card;

    @FindBy(xpath = ".//span[@class='s-text-xl s-font-semibold']")
    private WebElement total_amount_due_card_amount;

    public CustomerDetailsPage verifyAmount(){
        WebElement ele1 = total_amount_due_card;
        WebElement ele2 = total_amount_due_card_amount;
//        Assert.assertEquals(1,2);
        return this;
    }


}

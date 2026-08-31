package org.example.ui.pages;

import org.example.ui.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndexPage extends BasePage {
    protected IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-testid='cb-nav-item-customers']")
    private WebElement customers;

    @FindBy(css = "a[data-testid='cb-nav-item-subscriptions']")
    private WebElement subscriptions;

    @FindBy(css = "a[data-testid='cb-nav-item-invoices_&_credit_notes']")
    private WebElement invoices_credit_notes;

    @FindBy(css = "a[data-testid='cb-nav-item-invoices']")
    private WebElement invoices;

    @FindBy(css = "a[data-testid='cb-nav-item-credit_notes']")
    private WebElement credit_notes;



    protected void clickCustomers(){
        click(customers);
    }
    protected void clickSubscriptions(){
        click(subscriptions);
    }
    protected void clickInvoices(){
        click(invoices_credit_notes);
        wait.until(ExpectedConditions.elementToBeClickable(invoices)).click();
    }
    protected void clickCreditNotes(){
        click(invoices_credit_notes);
        wait.until(ExpectedConditions.elementToBeClickable(credit_notes)).click();
    }
}

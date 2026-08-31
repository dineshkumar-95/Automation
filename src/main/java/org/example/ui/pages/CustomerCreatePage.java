package org.example.ui.pages;

import org.example.ui.BasePage;
import org.example.models.ui.Customers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerCreatePage extends BasePage {
    public CustomerCreatePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id")
    private WebElement customerId;
    @FindBy(id = "email")
    private WebElement emailId;
    @FindBy(css = "#firstName")
    private WebElement firstName;
    @FindBy(css = "#lastName")
    private WebElement lastName;
    @FindBy(css = "#company")
    private WebElement company;
    @FindBy(css = "#phone")
    private WebElement phone;
//    @FindBy(css = "[id=\"billingAddress.country\"]")
//    private WebElement billingAddressCountry;

    @FindBy(css = "[id=\"billing_address\"] [id=\"billingAddress.country\"]")
    private WebElement billingAddressCountry;

    @FindBy(css = "[id=\"billingAddress.country\"] + .c-select__wrap [placeholder=\"Search\"]")
    private WebElement billingAddressCountrySearch;

    @FindBy(css = "[id=\"billingAddress.country\"] + .c-select__wrap .c-select__content .c-select__item")
    private WebElement billingAddressCountrySelect;

    @FindBy(css = "[id=\"billingAddress.firstName\"]")
    private WebElement billingAddressFirstName;
    @FindBy(css = "[id=\"billingAddress.lastName\"]")
    private WebElement billingAddressLastName;
    @FindBy(css = "[id=\"billingAddress.email\"]")
    private WebElement billingAddressEmail;
    @FindBy(css = "[id=\"billingAddress.company\"]")
    private WebElement billingAddressCompany;
    @FindBy(css = "[id=\"billingAddress.phone\"]")
    private WebElement billingAddressPhone;
    @FindBy(css = "[id=\"billingAddress.line1\"]")
    private WebElement billingAddressLine1;
    @FindBy(css = "[id=\"billingAddress.line2\"]")
    private WebElement billingAddressLine2;
    @FindBy(css = "[id=\"billingAddress.line3\"]")
    private WebElement billingAddressLine3;
    @FindBy(css = "[id=\"billingAddress.city\"]")
    private WebElement billingAddressCity;
    @FindBy(css = "[id=\"billingAddress.zip\"]")
    private WebElement billingAddressZip;
    @FindBy(css = "[id=\"billingAddress.stateCode\"]")
    private WebElement billingAddressState;

    @FindBy(css = ".cs-header__aside .c-button--primary")
    private WebElement createButton;

//    finde

    public CustomerCreatePage waitUntilCustomerCreatePageLoad(){
        waitForElementToDisplay(customerId);
//        driver.findElement(By.)
        return this;
    }

    public CustomerCreatePage createCustomer(Customers Customers) {

        if (Customers.getCustomerId() != null) {
            enterText(customerId,Customers.getCustomerId());
        }

        if (Customers.getEmail() != null) {
            enterText(emailId,Customers.getEmail());
        }

        if (Customers.getFirstName() != null) {
            enterText(firstName,Customers.getFirstName());
        }

        if (Customers.getLastName() != null) {
            enterText(lastName,Customers.getLastName());
        }

        if (Customers.getCompany() != null) {
            enterText(company,Customers.getCompany());
        }

        if (Customers.getPhone() != null) {
            enterText(phone,Customers.getPhone());
        }

        if (Customers.getBillingCountry() != null) {
            click(billingAddressCountry);
            enterText(billingAddressCountrySearch,Customers.getBillingCountry());
            click(billingAddressCountrySelect);
        }

        if (Customers.getBillingFirstName() != null) {
            enterText(billingAddressFirstName,Customers.getBillingFirstName());
        }

        if (Customers.getBillingLastName() != null) {
            enterText(billingAddressLastName,Customers.getBillingLastName());
        }

        if (Customers.getBillingEmail() != null) {
            enterText(billingAddressEmail,Customers.getBillingEmail());
        }

        if (Customers.getBillingPhone() != null) {
            enterText(billingAddressPhone,Customers.getBillingPhone());
        }

        if (Customers.getBillingLine1() != null) {
            enterText(billingAddressLine1,Customers.getBillingLine1());
        }

        if (Customers.getBillingLine2() != null) {
            enterText(billingAddressLine2,Customers.getBillingLine2());
        }

        if (Customers.getBillingLine3() != null) {
            enterText(billingAddressLine3,Customers.getBillingLine3());
        }

        if (Customers.getBillingState() != null) {
//            enterText(billingAddressState,Customers.getBillingState());
        }
        if (Customers.getBillingCity() != null) {
            enterText(billingAddressCity,Customers.getBillingCity());
        }
        if (Customers.getBillingZip() != null) {
            enterText(billingAddressZip,Customers.getBillingZip());
        }
        click(createButton);
        return this;
    }


}

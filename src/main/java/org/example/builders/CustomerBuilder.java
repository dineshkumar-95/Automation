package org.example.builders;
import org.example.models.*;

public class CustomerBuilder {

    private String customerId;
    private String email;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;

    // Billing
    private String billingCountry;
    private String billingFirstName;
    private String billingLastName;
    private String billingEmail;
    private String billingCompany;
    private String billingPhone;
    private String billingLine1;
    private String billingLine2;
    private String billingLine3;
    private String billingCity;
    private String billingZip;
    private String billingState;

    public CustomerBuilder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder setCompany(String company) {
        this.company = company;
        return this;
    }

    public CustomerBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
        return this;
    }

    public CustomerBuilder setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
        return this;
    }

    public CustomerBuilder setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
        return this;
    }

    public CustomerBuilder setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
        return this;
    }

    public CustomerBuilder setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
        return this;
    }

    public CustomerBuilder setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
        return this;
    }

    public CustomerBuilder setBillingLine1(String billingLine1) {
        this.billingLine1 = billingLine1;
        return this;
    }

    public CustomerBuilder setBillingLine2(String billingLine2) {
        this.billingLine2 = billingLine2;
        return this;
    }

    public CustomerBuilder setBillingLine3(String billingLine3) {
        this.billingLine3 = billingLine3;
        return this;
    }

    public CustomerBuilder setBillingCity(String billingCity) {
        this.billingCity = billingCity;
        return this;
    }
    public CustomerBuilder setBillingZip(String billingZip) {
        this.billingCity = billingZip;
        return this;
    }
    public CustomerBuilder setBillingState(String billingState) {
        this.billingState = billingState;
        return this;
    }

    public Customers build() {

        Customers customers = new Customers();

        customers.setCustomerId(customerId);
        customers.setEmail(email);
        customers.setFirstName(firstName);
        customers.setLastName(lastName);
        customers.setCompany(company);
        customers.setPhone(phone);
        customers.setBillingCountry(billingCountry);
        customers.setBillingCountry(billingFirstName);
        customers.setBillingCountry(billingLastName);
        customers.setBillingCountry(billingEmail);
        customers.setBillingCountry(billingCompany);
        customers.setBillingCountry(billingPhone);
        customers.setBillingCountry(billingLine1);
        customers.setBillingCountry(billingLine2);
        customers.setBillingCountry(billingLine3);
        customers.setBillingCountry(billingState);
        customers.setBillingCountry(billingZip);
        customers.setBillingCountry(billingCity);
        return customers;
    }

}

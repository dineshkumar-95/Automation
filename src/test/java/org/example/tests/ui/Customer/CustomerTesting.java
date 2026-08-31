package org.example.tests.ui.Customer;

import org.example.builders.CustomerBuilder;
import org.example.models.Customers;
import org.testng.annotations.Test;
import org.example.tests.BaseTest;

public class CustomerTesting extends BaseTest {
    @Override
    public void setupTestClass() throws Exception {

    }

    @Test
    public void createCustomer1() throws Exception {
        Customers customer = new CustomerBuilder()
                .setFirstName("fn")
                .setEmail("email@mail.in")
                .setCompany("Chargebee")
                .setBillingCountry("United States")
                .build();
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        customersIndexPage.clickCreateCustomerButton();
        customerCreatePage.waitUntilCustomerCreatePageLoad();
        customerCreatePage.createCustomer(customer);
        customerDetailsPage.verifyAmount();
        customerDetailsPage.waitUntilCustomersPageLoad();
        Thread.sleep(1000);
//        throw new Exception();
    }
//    @Test
//    public void createCustomer3() throws Exception {
//        Customers customer = new CustomerBuilder()
//                .setFirstName("fn")
//                .setEmail("email@mail.in")
//                .setCompany("Chargebee")
//                .setBillingCountry("United States")
//                .build();
//        homePage.navigateToCustomersIndexPage();
////        customersIndexPage.waitUntilCustomersPageLoad();
////        customersIndexPage.clickCreateCustomerButton();
////        customerCreatePage.waitUntilCustomerCreatePageLoad();
////        customerCreatePage.createCustomer(customer);
//        Thread.sleep(5000);
////        throw new Exception();
//    }
}

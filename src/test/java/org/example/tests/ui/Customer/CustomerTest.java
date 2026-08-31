package org.example.tests.ui.Customer;

import org.example.models.ui.Customers;
import org.example.tests.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    @Override
    public void setupTestClass() throws Exception {

    }


//    @DataProvider(name = "customerObjects")
//    public Object[][] customerObjects_DP() {
//        return new Object[][] {
//                { new CustomerBuilder().setFirstName("Dinesh").setEmail("dinesh@test.com").build() },
//                { new CustomerBuilder().setFirstName("Alice").setEmail("alice@test.com").build() }
//        };
//    }
//
//    @DataProvider(name = "customerObjects_test2")
//    public Object[][] customerObjects_test() {
//        return new Object[][] {
//                { "Dinesh", "dinesh@test.com" },
//                { "Alice",  "alice@test.com" }
//        };
//    }


//    @Test(dataProvider = "customerObjects_test")
//    public void createCustomer(String fn, String email) throws InterruptedException {
//        Customers customer = new CustomerBuilder()
//                .setFirstName(fn)
//                .setEmail(email)
//                .setCompany("Chargebee")
//                .setBillingCountry("United States")
//                .build();
//        homePage.navigateToCustomersIndexPage();
//        customersIndexPage.waitUntilCustomersPageLoad();
//        customersIndexPage.clickCreateCustomerButton();
//        customerCreatePage.waitUntilCustomerCreatePageLoad();
//        customerCreatePage.createCustomer(customer);
//        Thread.sleep(10000);
//    }
//
//    @Test(dataProvider = "customerObjects")
//    public void createCustomer2(Customers customer) throws InterruptedException {
//        homePage.navigateToCustomersIndexPage();
//        customersIndexPage.waitUntilCustomersPageLoad();
//        customersIndexPage.clickCreateCustomerButton();
//        customerCreatePage.waitUntilCustomerCreatePageLoad();
//        customerCreatePage.createCustomer(customer);
//        Thread.sleep(10000);
//    }

//    @Test
//    public void createCustomer2() throws Exception {
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
//        Thread.sleep(2000);
//        throw new Exception();
//    }
    @Test
    public void createCustomer1() throws Exception {
        Customers customer = new Customers()
                .setFirstName("fn")
                .setEmail("email@mail.in")
                .setCompany("Chargebee")
                .setBillingCountry("United States");
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        customersIndexPage.clickCreateCustomerButton();
        customerCreatePage.waitUntilCustomerCreatePageLoad();
        customerCreatePage.createCustomer(customer);
        customerDetailsPage.waitUntilCustomersPageLoad();
//        Thread.sleep(1000);
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

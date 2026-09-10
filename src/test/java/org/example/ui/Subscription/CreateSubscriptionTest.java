package org.example.ui.Subscription;

import org.example.api.utils.ApiResponseUtils;
import io.restassured.response.Response;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.model.Customer;
import org.testng.annotations.Test;
import org.example.BaseTest;

public class CreateSubscriptionTest extends BaseTest {
    
    protected String testCustomerId;
    protected String testCustomerEmail;

    @Override
    public void setupTestClass() throws Exception {
        // Create a customer via API to use for subscription UI testing
        CreateCustomerRequest customerRequest = new CreateCustomerRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company");

        Response response = customerApi.createCustomer(customerRequest);
        Customer customer = ApiResponseUtils.parse(response).getCustomer();
        testCustomerId = customer.getId();
        testCustomerEmail = customer.getEmail();
        
        System.out.println("Created test customer via API - ID: " + testCustomerId + ", Email: " + testCustomerEmail);
    }

    @Test
    public void createSubscription() throws Exception {

        Thread.sleep(1000);
    }
}
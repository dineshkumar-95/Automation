package Test.Subscription;

import io.restassured.response.Response;
import org.example.models.api.CreateCustomerApiRequest;
import org.testng.annotations.Test;
import Test.BaseTest;

public class CreateSubscriptionTesting extends BaseTest {
    
    protected String testCustomerId;
    protected String testCustomerEmail;

    @Override
    public void setupTestClass() throws Exception {
        // Create a customer via API to use for subscription UI testing
        CreateCustomerApiRequest customerRequest = new CreateCustomerApiRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company");

        Response response = apiHelper.createCustomerViaApi(customerRequest);
        testCustomerId = apiHelper.Customer(response).getId();
        testCustomerEmail = apiHelper.Customer(response).getEmail();
        
        System.out.println("Created test customer via API - ID: " + testCustomerId + ", Email: " + testCustomerEmail);
    }

    @Test
    public void createSubscription() throws Exception {

        Thread.sleep(1000);
    }
}
package org.example.api;

import io.restassured.response.Response;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.UpdateCustomerApiRequest;
import org.example.api.models.response.common.Card;
import org.example.api.models.response.Customer;
import org.example.api.utils.ApiResponseUtils;
import org.example.BaseTest;
import org.testng.annotations.Test;

public class UpdateCustomerApiTest extends BaseTest {

    String customerId;
    @Override
    public void setupTestClass() throws Exception {

        CreateCustomerApiRequest customerRequest = new CreateCustomerApiRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company");

        Response response = customerApi.createCustomerApi(customerRequest);
        Customer customer = ApiResponseUtils.customer(response);
        customerId = customer.getId();
    }


    @Test(description = "Get customer by ID using path parameter")
    public void updateCustomerApiTest() throws Exception {
        String expectedJsonPath = "api/customers/CustomerApiTest_createCustomerApiTest.json";

        UpdateCustomerApiRequest updateCustomerRequest = new UpdateCustomerApiRequest()
                .setFirstName("TestUpdate")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Update Test Company");

        Response response = customerApi.updateCustomerApi(customerId,updateCustomerRequest);
        Customer customer = ApiResponseUtils.customer(response);

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("firstname: " + customer.getFirstName());
        System.out.println("Company: " + customer.getCompany());

        // Access card details (if present)
        Card card = ApiResponseUtils.card(response);
        if (card != null) {
            System.out.println("Card ID: " + card.getLast4());
            System.out.println("Card Gateway: " + card.getGateway());
            System.out.println("Card Status: " + card.getStatus());
        }
        
//        JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
    }

}

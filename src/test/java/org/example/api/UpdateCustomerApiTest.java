package org.example.api;

import io.restassured.response.Response;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.dto.request.UpdateCustomerRequest;
import org.example.api.model.common.Card;
import org.example.api.model.Customer;
import org.example.api.utils.ApiResponseUtils;
import org.example.BaseTest;
import org.testng.annotations.Test;

public class UpdateCustomerApiTest extends BaseTest {

    String customerId;
    @Override
    public void setupTestClass() throws Exception {

        CreateCustomerRequest customerRequest = new CreateCustomerRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company");

        Response response = customerApi.createCustomer(customerRequest);
        customerId = ApiResponseUtils.parse(response).getCustomer().getId();
    }


    @Test(description = "Get customer by ID using path parameter")
    public void updateCustomerApiTest() throws Exception {
        String expectedJsonPath = "api/customers/CustomerApiTest_createCustomerApiTest.json";

        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest()
                .setFirstName("TestUpdate")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Update Test Company");

        Response response = customerApi.updateCustomer(customerId,updateCustomerRequest);
        Customer customer = ApiResponseUtils.parse(response).getCustomer();
        Card card = ApiResponseUtils.parse(response).getCard();

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("firstname: " + customer.getFirstName());
        System.out.println("Company: " + customer.getCompany());

        // Access card details (if present)
        if (card != null) {
            System.out.println("Card ID: " + card.getLast4());
            System.out.println("Card Gateway: " + card.getGateway());
            System.out.println("Card Status: " + card.getStatus());
        }
        
//        JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
    }

}

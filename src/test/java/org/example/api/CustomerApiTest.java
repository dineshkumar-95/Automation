package org.example.api;

import org.example.api.dto.request.common.CardRequest;
import org.example.api.utils.ApiResponseUtils;
import org.example.api.utils.ApiValidationUtils;
import io.restassured.response.Response;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.model.Customer;
import org.example.api.model.common.Card;
import org.example.api.utils.JsonComparator;
import org.testng.annotations.Test;
import org.example.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerApiTest extends BaseTest {

    @Override
    public void setupTestClass() throws Exception {

    }


    @Test(description = "Get customer by ID using path parameter")
    public void createCustomerApiTest() throws Exception {
        String expectedJsonPath = "api/customers/CustomerApiTest_createCustomerApiTest.json";

        CreateCustomerRequest customerRequest = new CreateCustomerRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company")
                .setCard(new CardRequest()
                        .setFirstName("test")
                        .setLastName("test")
                        .setNumber("4111111111111111")
                        .setCvv("123")
                        .setExpiryMonth(12)
                        .setExpiryYear(2032));

        Response response = customerApi.createCustomer(customerRequest);
        
        // Use new generic envelope pattern or backwards compatibility methods
        Customer customer = ApiResponseUtils.parse(response).getCustomer();
        Card card = ApiResponseUtils.parse(response).getCard();

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Email: " + customer.getEmail());

        // Access card details (if present)
        if (card != null) {
            System.out.println("Card ID: " + card.getLast4());
            System.out.println("Card Gateway: " + card.getGateway());
            System.out.println("Card Status: " + card.getStatus());
        }
        
        JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
    }

}

package org.example.tests.api;

import org.example.api.utils.ApiResponseUtils;
import org.example.api.utils.ApiValidationUtils;
import io.restassured.response.Response;
import org.example.models.api.request.CreateCustomerApiRequest;
import org.example.models.api.response.Customer;
import org.example.models.api.response.Card;
import org.example.api.utils.JsonComparator;
import org.testng.annotations.Test;
import org.example.tests.BaseTest;

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

        CreateCustomerApiRequest customerRequest = new CreateCustomerApiRequest()
                .setFirstName("Test")
                .setLastName("User")
                .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                .setCompany("Test Company");

        Response response = customerApi.createCustomerApi(customerRequest);
        Customer customer = ApiResponseUtils.customer(response);
//        String customerId = customer.getId();

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Email: " + customer.getEmail());

        // Access card details (if present)
        Card card = ApiResponseUtils.card(response);
        if (card != null) {
            System.out.println("Card ID: " + card.getLast4());
            System.out.println("Card Gateway: " + card.getGateway());
            System.out.println("Card Status: " + card.getStatus());
        }
        
        JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
    }

}

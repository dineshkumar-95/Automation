package api.tests;

import api.BaseApiTest;
import io.restassured.response.Response;
import org.example.constants.ApiConstants;
import org.example.models.api.Customer;
import org.example.models.api.Card;
import org.example.utils.JsonComparator;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerApiTest extends BaseApiTest {

    @Override
    protected void setupTestClass() throws Exception {
//        requestSpec.header("X-Custom-Header", "value");
    }

//    @Test(description = "Get all customers")
    public void getCustomers() {
        getAuthenticatedRequest()
        .when()
                .queryParam("limit", "1")
            .get(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK);
//                .log().all();
//            .body("list", notNullValue());
    }

    // Example of using path parameter to get specific customer
    @Test(description = "Get customer by ID using path parameter")
    public void getCustomerById() throws Exception {
        String customerId = "169rlTVSlQYNF55n"; // Replace with actual customer ID
        
        // Load expected JSON from classpath resources
        String expectedJsonPath = "api/customers/ret_customers.json";
        
        Response response = getAuthenticatedRequest()
        .when()
            .get(ApiConstants.CUSTOMERS_ENDPOINT+"/"+customerId)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .extract()
            .response();

        Customer customer = Customer(response);
        
        // Access customer details

        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Email: " + customer.getEmail());
        
        // Access card details (if present)
        Card card = Card(response);
        if (card != null) {
            System.out.println("Card ID: " + card.getLast4());
            System.out.println("Card Gateway: " + card.getGateway());
            System.out.println("Card Status: " + card.getStatus());
        }
        
        JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ignoreFields);
    }

}

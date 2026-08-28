package api.tests;

import api.BaseApiTest;
import org.example.constants.ApiConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerApiTest extends BaseApiTest {

    @Override
    protected void setupTestClass() throws Exception {
        requestSpec.header("X-Custom-Header", "value");
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
    public void getCustomerById() {
        String customerId = "16BTC8VSnrukqAhx"; // Replace with actual customer ID
        getAuthenticatedRequest()
        .when()
            .get(ApiConstants.CUSTOMERS_ENDPOINT+"/"+customerId)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK);
//            .log().all();
    }

}

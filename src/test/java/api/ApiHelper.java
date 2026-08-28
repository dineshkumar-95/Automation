package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.constants.ApiConstants;
import org.example.models.api.CustomerApiRequest;
import org.example.models.api.CustomerApiResponse;

import static io.restassured.RestAssured.given;

/**
 * Reusable API helper class for making API calls independent of test framework.
 * This can be used from UI tests to populate test data via API.
 */
public class ApiHelper {

    private static String baseUri = "https://dinesh-kumar-test.chargebee.com";
    private static String apiKey = "test_api_key"; // Should be moved to environment variables

    /**
     * Initialize the API helper with custom configuration
     */
    public static void init(String baseUrl, String apiKey) {
        ApiHelper.baseUri = baseUrl;
        ApiHelper.apiKey = apiKey;
        RestAssured.baseURI = baseUrl;
    }

    /**
     * Create a customer via API and return the customer ID
     */
    public static String createCustomerViaApi(CustomerApiRequest customerRequest) {
        Response response = given()
            .baseUri(baseUri)
            .contentType("application/json")
            .accept("application/json")
            .auth().basic(apiKey, "")
            .body(customerRequest)
        .when()
            .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT);

        if (response.getStatusCode() == 200) {
            CustomerApiResponse apiResponse = response.as(CustomerApiResponse.class);
            return apiResponse.getCustomer().getId();
        } else {
            throw new RuntimeException("Failed to create customer via API. Status: " + response.getStatusCode());
        }
    }


}

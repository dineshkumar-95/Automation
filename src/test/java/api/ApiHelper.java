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
            .post(ApiConstants.CUSTOMERS_ENDPOINT);

        if (response.getStatusCode() == 200) {
            CustomerApiResponse apiResponse = response.as(CustomerApiResponse.class);
            return apiResponse.getCustomer().getId();
        } else {
            throw new RuntimeException("Failed to create customer via API. Status: " + response.getStatusCode());
        }
    }

    /**
     * Get customer details by ID
     */
    public static CustomerApiResponse.Customer getCustomerById(String customerId) {
        Response response = given()
            .baseUri(baseUri)
            .contentType("application/json")
            .accept("application/json")
            .auth().basic(apiKey, "")
            .pathParam("id", customerId)
        .when()
            .get(ApiConstants.CUSTOMER_BY_ID_ENDPOINT);

        if (response.getStatusCode() == 200) {
            CustomerApiResponse apiResponse = response.as(CustomerApiResponse.class);
            return apiResponse.getCustomer();
        } else {
            throw new RuntimeException("Failed to get customer via API. Status: " + response.getStatusCode());
        }
    }

    /**
     * Delete customer by ID
     */
    public static boolean deleteCustomer(String customerId) {
        Response response = given()
            .baseUri(baseUri)
            .contentType("application/json")
            .auth().basic(apiKey, "")
            .pathParam("id", customerId)
        .when()
            .delete(ApiConstants.CUSTOMER_BY_ID_ENDPOINT);

        return response.getStatusCode() == 200;
    }

    /**
     * Create a simple test customer via API
     */
    public static String createTestCustomer(String firstName, String lastName, String email) {
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        customerRequest.setFirstName(firstName);
        customerRequest.setLastName(lastName);
        customerRequest.setEmail(email);
        customerRequest.setCompany("Test Company");

        CustomerApiRequest.BillingAddress billingAddress = new CustomerApiRequest.BillingAddress();
        billingAddress.setFirstName(firstName);
        billingAddress.setLastName(lastName);
        billingAddress.setEmail(email);
        billingAddress.setLine1("123 Test Street");
        billingAddress.setCity("Test City");
        billingAddress.setState("TS");
        billingAddress.setZip("12345");
        billingAddress.setCountry("United States");
        customerRequest.setBillingAddress(billingAddress);

        return createCustomerViaApi(customerRequest);
    }

    /**
     * Create a simple test customer via API without billing address
     */
    public static String createSimpleTestCustomer(String firstName, String lastName, String email) {
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        customerRequest.setFirstName(firstName);
        customerRequest.setLastName(lastName);
        customerRequest.setEmail(email);
        customerRequest.setCompany("Test Company");

        return createCustomerViaApi(customerRequest);
    }

    /**
     * Create a test customer with random data
     */
    public static String createRandomTestCustomer() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "testuser_" + timestamp + "@example.com";
        return createTestCustomer("Test", "User_" + timestamp, email);
    }

    /**
     * Get API response for raw response handling
     */
    public static Response getRawResponse(String endpoint) {
        return given()
            .baseUri(baseUri)
            .contentType("application/json")
            .accept("application/json")
            .auth().basic(apiKey, "")
        .when()
            .get(endpoint);
    }
}

package api;

import io.restassured.response.Response;
import org.example.constants.ApiConstants;
import org.example.models.api.CustomerApiRequest;
import org.example.models.api.CustomerApiResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerApiTest extends BaseApiTest {

    @Override
    protected void setupTestClass() throws Exception {
        // API-specific setup if needed
    }

    @Test(description = "Get all customers")
    public void getAllCustomers() {
        given()
            .spec(requestSpec)
        .when()
            .get(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("list", notNullValue());
    }

    @Test(description = "Get customer by ID")
    public void getCustomerById() {
        String customerId = "test_customer_id"; // Replace with actual customer ID
        
        given()
            .spec(requestSpec)
            .pathParam("id", customerId)
        .when()
            .get(ApiConstants.CUSTOMER_BY_ID_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("customer.id", equalTo(customerId));
    }

    @Test(description = "Create a new customer")
    public void createCustomer() {
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        customerRequest.setFirstName("Test");
        customerRequest.setLastName("User");
        customerRequest.setEmail("testuser@example.com");
        customerRequest.setCompany("Test Company");

        CustomerApiRequest.BillingAddress billingAddress = new CustomerApiRequest.BillingAddress();
        billingAddress.setFirstName("Test");
        billingAddress.setLastName("User");
        billingAddress.setEmail("testuser@example.com");
        billingAddress.setLine1("123 Test Street");
        billingAddress.setCity("Test City");
        billingAddress.setState("TS");
        billingAddress.setZip("12345");
        billingAddress.setCountry("United States");
        customerRequest.setBillingAddress(billingAddress);

        Response response = given()
            .spec(requestSpec)
            .body(customerRequest)
        .when()
            .post(ApiConstants.CUSTOMERS_ENDPOINT);

        response.then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("customer", notNullValue())
            .body("customer.email", equalTo("testuser@example.com"));

        // Verify response using POJO
        CustomerApiResponse apiResponse = response.as(CustomerApiResponse.class);
        Assert.assertNotNull(apiResponse.getCustomer());
        Assert.assertEquals(apiResponse.getCustomer().getEmail(), "testuser@example.com");
    }

    @Test(description = "Update an existing customer")
    public void updateCustomer() {
        String customerId = "test_customer_id"; // Replace with actual customer ID
        
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        customerRequest.setFirstName("Updated");
        customerRequest.setLastName("Name");
        customerRequest.setEmail("updated@example.com");

        given()
            .spec(requestSpec)
            .pathParam("id", customerId)
            .body(customerRequest)
        .when()
            .post(ApiConstants.CUSTOMER_BY_ID_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("customer.id", equalTo(customerId))
            .body("customer.first_name", equalTo("Updated"));
    }

    @Test(description = "Delete a customer")
    public void deleteCustomer() {
        String customerId = "test_customer_id"; // Replace with actual customer ID
        
        given()
            .spec(requestSpec)
            .pathParam("id", customerId)
        .when()
            .delete(ApiConstants.CUSTOMER_BY_ID_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK);
    }

    @Test(description = "Test customer creation with invalid data")
    public void createCustomerWithInvalidData() {
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        // Missing required fields like email
        
        given()
            .spec(requestSpec)
            .body(customerRequest)
        .when()
            .post(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(anyOf(
                equalTo(ApiConstants.STATUS_BAD_REQUEST),
                equalTo(ApiConstants.STATUS_CONFLICT)
            ));
    }

    @DataProvider(name = "customerData")
    public Object[][] customerDataProvider() {
        return new Object[][] {
            {"John", "Doe", "john.doe@example.com", "Acme Corp"},
            {"Jane", "Smith", "jane.smith@example.com", "Tech Inc"},
            {"Bob", "Johnson", "bob.johnson@example.com", "Global Ltd"}
        };
    }

    @Test(dataProvider = "customerData", description = "Create customers with different data")
    public void createCustomerWithDataProvider(String firstName, String lastName, String email, String company) {
        CustomerApiRequest customerRequest = new CustomerApiRequest();
        customerRequest.setFirstName(firstName);
        customerRequest.setLastName(lastName);
        customerRequest.setEmail(email);
        customerRequest.setCompany(company);

        given()
            .spec(requestSpec)
            .body(customerRequest)
        .when()
            .post(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("customer.email", equalTo(email))
            .body("customer.company", equalTo(company));
    }

    @Test(description = "Test API response time")
    public void testApiResponseTime() {
        given()
            .spec(requestSpec)
        .when()
            .get(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .time(lessThan(5000L)); // Response time should be less than 5 seconds
    }

    @Test(description = "Test JSON schema validation")
    public void testJsonSchemaValidation() {
        given()
            .spec(requestSpec)
        .when()
            .get(ApiConstants.CUSTOMERS_ENDPOINT)
        .then()
            .spec(responseSpec)
            .statusCode(ApiConstants.STATUS_OK)
            .body("list", everyItem(hasKey("id")))
            .body("list", everyItem(hasKey("email")))
            .body("list", everyItem(hasKey("first_name")));
    }
}

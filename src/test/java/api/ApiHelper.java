package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.ApiConstants;
import org.example.models.api.Card;
import org.example.models.api.CreateCustomerApiRequest;
import org.example.models.api.Customer;
import org.example.models.api.Invoice;
import org.example.models.api.Subscription;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

/**
 * Reusable API helper class for making API calls independent of test framework.
 * Instantiated per test thread to ensure thread safety during parallel UI test execution.
 */
public class ApiHelper {

    private final String baseUri;
    private final String apiKey;
    public RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;

    /**
     * Initialize the API helper with custom base URI and API key
     */
    public ApiHelper(String baseUri, String apiKey) {
        this.baseUri = baseUri.trim();
        this.apiKey = apiKey.trim();

        // Request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(this.baseUri)
                .setContentType(ApiConstants.CONTENT_TYPE_FORM_URLENCODED)
                .addHeader("Accept", ApiConstants.CONTENT_TYPE_JSON)
                .log(LogDetail.ALL)
                .build();

        // Response specification
        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(10000L)) // 10 seconds timeout
                .log(LogDetail.ALL)
                .build();

    }

    public RequestSpecification getAuthenticatedRequest() {
        return given()
            .spec(requestSpec)
            .auth().basic(this.apiKey, "");
    }

    public Subscription Subscription(Response response) {
        return response.jsonPath().getObject("subscription", Subscription.class);
    }

    public Customer Customer(Response response) {
        return response.jsonPath().getObject("customer", Customer.class);
    }

    public Invoice Invoice(Response response) {
        return response.jsonPath().getObject("invoice", Invoice.class);
    }

    public Card Card(Response response) {
        return response.jsonPath().getObject("card", Card.class);
    }

    /**
     * Create a customer via API and return the Response
     */
    public Response createCustomerViaApi(CreateCustomerApiRequest customerRequest) {
        return getAuthenticatedRequest()
                .body(customerRequest.toFormUrlEncoded())
                .when()
                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .then()
                .spec(responseSpec)
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
}

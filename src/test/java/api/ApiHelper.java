package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.ApiConstants;
import org.example.models.api.*;

import java.util.Arrays;
import java.util.List;

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


    public List<String> ignoreFields = Arrays.asList(
            // Customer Fields
            "customer.id",
            "customer.email",
            "customer.created_at",
            "customer.updated_at",
            "customer.resource_version",
            "customer.created_from_ip",
//            "customer.card_status",
            "customer.primary_payment_source_id",
            "customer.mrr",

            // Subscription Fields
            "subscription.id",
            "subscription.customer_id",
            "subscription.current_term_start",
            "subscription.current_term_end",
            "subscription.next_billing_at",
            "subscription.created_at",
            "subscription.started_at",
            "subscription.activated_at",
            "subscription.updated_at",
            "subscription.resource_version",
            "subscription.due_since",
            "subscription.subscription_items[*].current_term_start",
            "subscription.subscription_items[*].current_term_end",
            "subscription.subscription_items[*].next_billing_at",

            // Card Fields
            "card.customer_id",
            "card.payment_source_id",
            "card.created_at",
            "card.updated_at",
            "card.ip_address",
            "card.resource_version",

            // Invoice Fields
            "invoice.id",
            "invoice.customer_id",
            "invoice.subscription_id",
            "invoice.date",
            "invoice.due_date",
            "invoice.updated_at",
            "invoice.resource_version",
            "invoice.generated_at",
            "invoice.line_items[*].id",
            "invoice.line_items[*].subscription_id",
            "invoice.line_items[*].customer_id",
            "invoice.line_items[*].date_from",
            "invoice.line_items[*].date_to",
            "invoice.line_item_tiers[*].line_item_id"
    );



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
//        return response.as(Card.class);

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

    /**
     * Create a Subscription via API and return the Response
     */
    public Response createSubscriptionViaApi(String customerId, CreateSubscriptionApiRequest createSubscriptionApiRequest) {
        return getAuthenticatedRequest()
                .body(createSubscriptionApiRequest.toFormUrlEncoded())
                .when()
//                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .post(ApiConstants.SUBSCRIPTION_FOR_ITEMS_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(responseSpec)
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
}

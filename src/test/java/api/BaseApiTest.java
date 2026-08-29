package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.ApiConstants;
import org.example.constants.Constants;
import org.example.models.api.Card;
import org.example.models.api.Customer;
import org.example.models.api.Invoice;
import org.example.models.api.Subscription;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public abstract class BaseApiTest {

    public RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;
    protected String apiBaseUrl;
    protected String apiKey;

    protected abstract void setupTestClass() throws Exception;

    @BeforeClass
    @Parameters({"apiBaseUrl", "apiKey"})
    public void beforeClass(
            @Optional("") String apiBaseUrl,
            @Optional("") String apiKey
    ) throws Exception {
        if (apiBaseUrl != null && !apiBaseUrl.trim().isEmpty()) {
            this.apiBaseUrl = apiBaseUrl.trim();
        } else {
            this.apiBaseUrl = "https://" + ApiConstants.TEST_SITE + "." + ApiConstants.DOMAIN;
        }

        if (apiKey != null && !apiKey.trim().isEmpty()) {
            this.apiKey = apiKey.trim();
        } else {
            this.apiKey = ApiConstants.API_KEY;
        }

        setupRestAssured();
        setupTestClass();
    }

    protected Subscription Subscription(Response response) {
        return response.jsonPath().getObject("subscription", Subscription.class);
    }
    protected Customer Customer(Response response) {
        return response.jsonPath().getObject("customer", Customer.class);
    }
    protected Invoice Invoice(Response response) {
        return response.jsonPath().getObject("invoice", Invoice.class);
    }
    protected Card Card(Response response) {
        return response.jsonPath().getObject("card", Card.class);
    }

    private void setupRestAssured() {
        // Request specification
        requestSpec = new RequestSpecBuilder()
            .setBaseUri(this.apiBaseUrl)
            .setContentType(ApiConstants.CONTENT_TYPE_JSON)
            .addHeader("Accept", ApiConstants.CONTENT_TYPE_JSON)
            .log(LogDetail.ALL)
            .build();

        // Response specification
        responseSpec = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(10000L)) // 10 seconds timeout

            .log(LogDetail.ALL)
            .build();
    }

    protected RequestSpecification getAuthenticatedRequest() {
        return given()
            .spec(requestSpec)
            .auth().basic(this.apiKey, "");
    }

    protected List<String> ignoreFields = Arrays.asList(
            // Customer Fields
            "customer.id",
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


}

package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.ApiConstants;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

/**
 * Reusable API helper class for making API calls independent of test framework.
 * Instantiated per test thread to ensure thread safety during parallel UI test execution.
 */
public class ApiClient {

    private final String baseUri;
    private final String apiKey;
    private final RequestSpecification requestSpec;
    private final ResponseSpecification responseSpec;

    /**
     * Initialize the API helper with custom base URI and API key
     */
    public ApiClient(String baseUri, String apiKey) {
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
                .expectResponseTime(Matchers.lessThan(10000L)) // 10 seconds timeout
                .log(LogDetail.ALL)
                .build();
    }

    public RequestSpecification getAuthenticatedRequest() {
        return RestAssured.given()
                .spec(requestSpec)
                .auth().basic(this.apiKey, "");
    }

    public ResponseSpecification getResponseSpec() {
        return responseSpec;
    }









}

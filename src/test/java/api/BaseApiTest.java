package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public abstract class BaseApiTest {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    protected abstract void setupTestClass() throws Exception;

    @BeforeClass
    @Parameters(value = {"apiBaseUrl"})
    public void beforeClass(@Optional String apiBaseUrl) throws Exception {
        setupRestAssured(apiBaseUrl);
        setupTestClass();
    }

    private void setupRestAssured(String apiBaseUrl) {
        // Set base URL from parameter or constants
        String baseUrl = (apiBaseUrl != null && !apiBaseUrl.trim().isEmpty()) 
            ? apiBaseUrl 
            : "https://" + Constants.TEST_SITE + "." + Constants.DOMAIN;

        RestAssured.baseURI = baseUrl;

        // Request specification
        requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .setContentType("application/json")
            .addHeader("Accept", "application/json")
            .log(LogDetail.ALL)
            .build();

        // Response specification
        responseSpec = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(10000L)) // 10 seconds timeout
            .log(LogDetail.ALL)
            .build();
    }

    protected RequestSpecification getAuthenticatedRequest(String apiKey) {
        return given()
            .spec(requestSpec)
            .auth().basic(apiKey, "");
    }

    protected RequestSpecification getRequest() {
        return given().spec(requestSpec);
    }
}

package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.constants.ApiConstants;
import org.example.constants.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public abstract class BaseApiTest {

    public RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;

    protected abstract void setupTestClass() throws Exception;

    @BeforeClass
    public void beforeClass() throws Exception {
        setupRestAssured();
        setupTestClass();
    }

    private void setupRestAssured() {
        // Set base URL from parameter or constants
        String baseUrl = "https://" + ApiConstants.TEST_SITE + "." + ApiConstants.DOMAIN;
        // Request specification
        requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
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
            .auth().basic(ApiConstants.API_KEY, "");
    }

}

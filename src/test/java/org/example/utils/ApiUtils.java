package org.example.utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class ApiUtils {

    /**
     * Extracts a specific field from the response body
     */
    public static String getFieldValue(Response response, String path) {
        return response.jsonPath().getString(path);
    }

    /**
     * Extracts an integer field from the response body
     */
    public static Integer getIntField(Response response, String path) {
        return response.jsonPath().getInt(path);
    }

    /**
     * Validates that the response contains expected fields
     */
    public static void validateResponseFields(Response response, Map<String, Object> expectedFields) {
        for (Map.Entry<String, Object> entry : expectedFields.entrySet()) {
            String actualValue = getFieldValue(response, entry.getKey());
            Assert.assertEquals(actualValue, entry.getValue(), 
                "Field " + entry.getKey() + " does not match expected value");
        }
    }

    /**
     * Validates the status code of the response
     */
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
            "Status code does not match. Expected: " + expectedStatusCode + 
            ", Actual: " + response.getStatusCode());
    }

    /**
     * Checks if the response is successful (2xx status code)
     */
    public static boolean isSuccessful(Response response) {
        return response.getStatusCode() >= 200 && response.getStatusCode() < 300;
    }

    /**
     * Extracts error message from response
     */
    public static String getErrorMessage(Response response) {
        return getFieldValue(response, "message");
    }

    /**
     * Extracts error code from response
     */
    public static String getErrorCode(Response response) {
        return getFieldValue(response, "error_code");
    }
}

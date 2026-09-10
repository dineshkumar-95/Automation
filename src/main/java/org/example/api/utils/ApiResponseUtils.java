package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.dto.response.ApiResponse;
import org.example.api.dto.response.ApiListResponse;

public final class ApiResponseUtils {

    /** Parse a single-entity Chargebee API response. */
    public static ApiResponse parse(Response response) {
        return response.as(ApiResponse.class);
    }

    /** Parse a list Chargebee API response (e.g., List Customers). */
    public static ApiListResponse parseList(Response response) {
        return response.as(ApiListResponse.class);
    }
}

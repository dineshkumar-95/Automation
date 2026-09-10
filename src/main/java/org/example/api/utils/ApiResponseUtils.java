package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.models.response.wrappers.ChargebeeResponse;
import org.example.api.models.response.wrappers.ChargebeeListResponse;

public final class ApiResponseUtils {
    
    public static ChargebeeResponse parse(Response response) {
        return response.as(ChargebeeResponse.class);
    }

    public static ChargebeeListResponse parseList(Response response) {
        return response.as(ChargebeeListResponse.class);
    }

}

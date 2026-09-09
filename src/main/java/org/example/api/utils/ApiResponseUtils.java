package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.models.response.ChargebeeResponse;
import org.example.api.models.response.ChargebeeListResponse;
import org.example.api.models.response.Customers;
import org.example.api.models.response.Customer;
import org.example.api.models.response.Subscription;
import org.example.api.models.response.Invoice;
import org.example.api.models.response.EmailLog;
import org.example.api.models.response.common.*;
import java.util.List;

public final class ApiResponseUtils {
    
    public static ChargebeeResponse parse(Response response) {
        return response.as(ChargebeeResponse.class);
    }

    public static ChargebeeListResponse parseList(Response response) {
        return response.as(ChargebeeListResponse.class);
    }

}

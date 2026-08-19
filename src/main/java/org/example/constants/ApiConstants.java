package org.example.constants;

public class ApiConstants {
    
    // API Endpoints
    public static final String CUSTOMERS_ENDPOINT = "/api/v2/customers";
    public static final String CUSTOMER_BY_ID_ENDPOINT = "/api/v2/customers/{id}";
    public static final String SUBSCRIPTIONS_ENDPOINT = "/api/v2/subscriptions";
    public static final String INVOICES_ENDPOINT = "/api/v2/invoices";
    public static final String PLANS_ENDPOINT = "/api/v2/plans";
    
    // HTTP Methods
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String PATCH = "PATCH";
    
    // Response Status Codes
    public static final int STATUS_OK = 200;
    public static final int STATUS_CREATED = 201;
    public static final int STATUS_BAD_REQUEST = 400;
    public static final int STATUS_UNAUTHORIZED = 401;
    public static final int STATUS_FORBIDDEN = 403;
    public static final int STATUS_NOT_FOUND = 404;
    public static final int STATUS_CONFLICT = 409;
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
    
    // Content Types
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    
    // API Keys (should be moved to environment variables)
    public static final String API_KEY = "test_api_key"; // Replace with actual API key
}

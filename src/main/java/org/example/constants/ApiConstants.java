package org.example.constants;

import org.example.config.ConfigManager;

public class ApiConstants {

    // API Endpoints
    public static final String CREATE_CUSTOMERS_ENDPOINT = "/customers";
    public static final String UPDATE_CUSTOMERS_ENDPOINT = "/customers/{customerId}";
    public static final String ADD_CONTACTS_TO_CUSTOMER_ENDPOINT = "/customers/{customerId}/add_contact";
    public static final String UPDATE_CONTACTS_FOR_CUSTOMER_ENDPOINT = "/customers/{customerId}/update_contact";
    public static final String LIST_CUSTOMERS_ENDPOINT = "/customers";
    public static final String GET_CUSTOMERS_ENDPOINT = "/customers/{customerId}";

    public static final String LIST_SUBSCRIPTIONS_ENDPOINT = "/subscriptions";
    public static final String SUBSCRIPTION_FOR_ITEMS_ENDPOINT = "/customers/{customerId}/subscription_for_items";


    public static final String INVOICES_ENDPOINT = "/api/v2/invoices";
    public static final String PLANS_ENDPOINT = "/api/v2/plans";
    
    // HTTP Methods
    public static final String GET = "GET";
    public static final String POST = "POST";
    
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
}

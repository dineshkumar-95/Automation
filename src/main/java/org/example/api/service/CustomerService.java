package org.example.api.service;

import io.restassured.response.Response;
import org.example.api.client.ApiClient;
import org.example.api.mapper.AddContactsToCustomerMapper;
import org.example.api.mapper.CreateCustomerApiMapper;
import org.example.api.mapper.UpdateContactsForCustomerMapper;
import org.example.api.mapper.UpdateCustomerApiMapper;
import org.example.api.dto.request.AddContactsToCustomerRequest;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.dto.request.UpdateContactsForCustomerRequest;
import org.example.api.dto.request.UpdateCustomerRequest;
import org.example.constants.ApiConstants;

/**
 * Service class that exposes Customer-related API operations.
 * Depends on ApiClient for HTTP transport; returns raw RestAssured Response objects
 * so callers can parse or assert as needed.
 */
public class CustomerService {

    private final ApiClient apiClient;

    public CustomerService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /** Create a customer via API and return the raw Response. */
    public Response createCustomer(CreateCustomerRequest request) {
        return apiClient.getAuthenticatedRequest()
                .body(CreateCustomerApiMapper.toFormUrlEncoded(request))
                .when()
                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }

    /** Update an existing customer by ID. */
    public Response updateCustomer(String customerId, UpdateCustomerRequest request) {
        return apiClient.getAuthenticatedRequest()
                .body(UpdateCustomerApiMapper.toFormUrlEncoded(request))
                .when()
                .post(ApiConstants.UPDATE_CUSTOMERS_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract().response();
    }

    /** Add a contact to a customer. */
    public Response addContact(String customerId, AddContactsToCustomerRequest request) {
        return apiClient.getAuthenticatedRequest()
                .body(AddContactsToCustomerMapper.toFormUrlEncoded(request))
                .when()
                .post(ApiConstants.ADD_CONTACTS_TO_CUSTOMER_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract().response();
    }

    /** Update an existing contact for a customer. */
    public Response updateContact(String customerId, UpdateContactsForCustomerRequest request) {
        return apiClient.getAuthenticatedRequest()
                .body(UpdateContactsForCustomerMapper.toFormUrlEncoded(request))
                .when()
                .post(ApiConstants.UPDATE_CONTACTS_FOR_CUSTOMER_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract().response();
    }
}

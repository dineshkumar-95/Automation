package org.example.api.services;

import org.example.api.ApiClient;
import io.restassured.response.Response;
import org.example.api.mapper.CreateCustomerApiMapper;
import org.example.api.mapper.UpdateCustomerApiMapper;
import org.example.api.models.request.UpdateCustomerApiRequest;
import org.example.constants.ApiConstants;
import org.example.api.models.request.CreateCustomerApiRequest;

public class CustomerApi {


    private final ApiClient apiClient;

    public CustomerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a customer via API and return the Response
     */
    public Response createCustomerApi(CreateCustomerApiRequest Request) {
        return apiClient.getAuthenticatedRequest()
                .body(CreateCustomerApiMapper.toFormUrlEncoded(Request))
                .when()
                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
    public Response updateCustomerApi(String customerId, UpdateCustomerApiRequest Request) {
        return apiClient.getAuthenticatedRequest()
                .body(UpdateCustomerApiMapper.toFormUrlEncoded(Request))
                .when()
                .post(ApiConstants.UPDATE_CUSTOMERS_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
}

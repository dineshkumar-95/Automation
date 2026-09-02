package org.example.api.services;

import org.example.api.ApiClient;
import io.restassured.response.Response;
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
    public Response createCustomerApi(CreateCustomerApiRequest customerRequest) {
        return apiClient.getAuthenticatedRequest()
                .body(customerRequest.toFormUrlEncoded())
                .when()
                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .then()
                .spec(apiClient.responseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
}

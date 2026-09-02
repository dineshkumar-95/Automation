package org.example.api.services;

import org.example.api.ApiClient;
import io.restassured.response.Response;
import org.example.api.mapper.CreateSubscriptionApiMapper;
import org.example.constants.ApiConstants;
import org.example.api.models.request.CreateSubscriptionApiRequest;

public class SubscriptionApi {

    private final ApiClient apiClient;

    public SubscriptionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    /**
     * Create a Subscription via API and return the Response
     */
    public Response createSubscriptionApi(String customerId, CreateSubscriptionApiRequest createSubscriptionApiRequest) {
        return apiClient.getAuthenticatedRequest()
                .body(CreateSubscriptionApiMapper.toFormUrlEncoded(createSubscriptionApiRequest))
                .when()
//                .post(ApiConstants.CREATE_CUSTOMERS_ENDPOINT)
                .post(ApiConstants.SUBSCRIPTION_FOR_ITEMS_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.responseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }

}

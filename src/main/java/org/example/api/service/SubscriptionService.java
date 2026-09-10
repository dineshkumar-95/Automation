package org.example.api.service;

import io.restassured.response.Response;
import org.example.api.client.ApiClient;
import org.example.api.mapper.CreateSubscriptionApiMapper;
import org.example.api.dto.request.CreateSubscriptionRequest;
import org.example.constants.ApiConstants;

/**
 * Service class that exposes Subscription-related API operations.
 */
public class SubscriptionService {

    private final ApiClient apiClient;

    public SubscriptionService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /** Create a subscription for a customer via API and return the raw Response. */
    public Response createSubscription(String customerId, CreateSubscriptionRequest request) {
        return apiClient.getAuthenticatedRequest()
                .body(CreateSubscriptionApiMapper.toFormUrlEncoded(request))
                .when()
                .post(ApiConstants.SUBSCRIPTION_FOR_ITEMS_ENDPOINT.replace("{customerId}", customerId))
                .then()
                .spec(apiClient.getResponseSpec())
                .statusCode(ApiConstants.STATUS_OK)
                .extract()
                .response();
    }
}

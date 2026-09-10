package org.example.api;

import org.example.api.utils.ApiResponseUtils;
import org.example.api.utils.ApiValidationUtils;
import io.restassured.response.Response;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.dto.request.CreateSubscriptionRequest;
import org.example.api.model.Subscription;
import org.example.api.dto.request.common.SubscriptionItem;
import org.example.api.utils.JsonComparator;
import org.testng.annotations.Test;
import org.example.BaseTest;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SubscriptionApiTest extends BaseTest {
        String customerId;
        @Override
        public void setupTestClass() throws Exception {
                // Additional setup for subscription tests if needed
                CreateCustomerRequest customerRequest = new CreateCustomerRequest()
                        .setFirstName("Test")
                        .setLastName("User")
                        .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                        .setCompany("Test Company");

                Response response = customerApi.createCustomer(customerRequest);
                customerId = ApiResponseUtils.parse(response).getCustomer().getId();
        }

        @Test(description = "Simple subscription creation - basic fields only")
        public void createSimpleSubscription() throws IOException {

                // Simple approach using fluent builders
                CreateSubscriptionRequest request = new CreateSubscriptionRequest();
                request.setAutoCollection("off");

                // Add subscription items
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("ffPlan1-INR-Monthly"));
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("tieAddon1-INR-Monthly").setQuantity(344));

                Response response = subscriptionApi.createSubscription(customerId, request);
                Subscription subscription = ApiResponseUtils.parse(response).getSubscription();
                System.out.println("Addon Name - " + subscription.getSubscriptionItems().get(1).getItemPriceId());

//                assertNotNull(subscription);
//                assertNotNull(subscription.getId());
                System.out.println("Created Subscription ID: " + subscription.getId());
                String expectedJsonPath = "api/subscriptions/SubscriptionApiTest_createSimpleSubscription.json";
                JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
        }

}
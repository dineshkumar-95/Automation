package org.example.tests.api;

import org.example.api.utils.ApiResponseUtils;
import org.example.api.utils.ApiValidationUtils;
import io.restassured.response.Response;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.CreateSubscriptionApiRequest;
import org.example.api.models.response.Subscription;
import org.example.api.models.request.common.SubscriptionItem;
import org.example.api.utils.JsonComparator;
import org.testng.annotations.Test;
import org.example.tests.BaseTest;

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
                CreateCustomerApiRequest customerRequest = new CreateCustomerApiRequest()
                        .setFirstName("Test")
                        .setLastName("User")
                        .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                        .setCompany("Test Company");

                Response response = customerApi.createCustomerApi(customerRequest);
                customerId = ApiResponseUtils.customer(response).getId();
        }

        @Test(description = "Simple subscription creation - basic fields only")
        public void createSimpleSubscription() throws IOException {

                // Simple approach using fluent builders
                CreateSubscriptionApiRequest request = new CreateSubscriptionApiRequest();
                request.setAutoCollection("off");

                // Add subscription items
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("ffPlan1-INR-Monthly"));
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("tieAddon1-INR-Monthly").setQuantity(344));

                Response response = subscriptionApi.createSubscriptionApi(customerId, request);
                Subscription subscription = ApiResponseUtils.subscription(response);
                System.out.println("Addon Name - " + subscription.getSubscriptionItems().get(1).getItemPriceId());

//                assertNotNull(subscription);
//                assertNotNull(subscription.getId());
                System.out.println("Created Subscription ID: " + subscription.getId());
                String expectedJsonPath = "api/subscriptions/SubscriptionApiTest_createSimpleSubscription.json";
                JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ApiValidationUtils.IGNORE_FIELDS);
        }

}
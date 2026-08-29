package api.tests;

import api.BaseApiTest;
import io.restassured.response.Response;
import org.example.constants.ApiConstants;
import org.example.models.api.CreateCustomerApiRequest;
import org.example.models.api.CreateSubscriptionApiRequest;
import org.example.models.api.Customer;
import org.example.models.api.Subscription;
import org.example.models.api.CreateSubscriptionApiRequest.SubscriptionItem;
import org.example.utils.JsonComparator;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SubscriptionApiTest extends BaseApiTest {
        String customerId;
        @Override
        protected void setupTestClass() throws Exception {
                // Additional setup for subscription tests if needed
                CreateCustomerApiRequest customerRequest = new CreateCustomerApiRequest()
                        .setFirstName("Test")
                        .setLastName("User")
                        .setEmail("subscription_test_" + System.currentTimeMillis() + "@test.com")
                        .setCompany("Test Company");

                Response response = apiHelper.createCustomerViaApi(customerRequest);
                customerId = apiHelper.Customer(response).getId();
        }

        @Test(description = "Simple subscription creation - basic fields only")
        public void createSimpleSubscription() throws IOException {

                // Simple approach using fluent builders
                CreateSubscriptionApiRequest request = new CreateSubscriptionApiRequest();
                request.setAutoCollection("off");

                // Add subscription items
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("ffPlan1-INR-Monthly"));
                request.addSubscriptionItem(new SubscriptionItem().setItemPriceId("tieAddon1-INR-Monthly").setQuantity(344));

                Response response = getAuthenticatedRequest()
                                .contentType(ApiConstants.CONTENT_TYPE_FORM_URLENCODED)
                                .body(request.toFormUrlEncoded())
                                .when()
                                .post(ApiConstants.SUBSCRIPTION_FOR_ITEMS_ENDPOINT.replace("{customerId}", customerId))
                                .then()
                                .spec(responseSpec)
                                .statusCode(anyOf(
                                                org.hamcrest.Matchers.equalTo(200),
                                                org.hamcrest.Matchers.equalTo(201)))
                                .body("subscription", notNullValue())
                                .extract()
                                .response();

                Subscription subscription = Subscription(response);

//                assertNotNull(subscription);
//                assertNotNull(subscription.getId());
                System.out.println("Created Subscription ID: " + subscription.getId());
                String expectedJsonPath = "api/customers/SubscriptionApiTest_createSimpleSubscription.json";
                JsonComparator.compareJsonWithClasspathResource(response, expectedJsonPath, ignoreFields);
        }

}
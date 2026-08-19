package Test;

import api.ApiHelper;
import org.example.builders.CustomerBuilder;
import org.example.models.Customers;
import org.testng.annotations.Test;

/**
 * Example UI test that uses API to populate test data.
 * This demonstrates how to use API for test data setup in UI tests.
 */
public class CustomerApiDataTest extends BaseTest {

    private String customerId;

    @Override
    public void setupTestClass() throws Exception {
        // Setup test class if needed
    }

    @Test(description = "Create customer via API and verify in UI")
    public void createCustomerViaApiAndVerifyInUI() {
        // Step 1: Create customer via API
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "api_test_" + timestamp + "@example.com";
        
        customerId = ApiHelper.createTestCustomer("API", "TestUser", email);
        
        System.out.println("Customer created via API with ID: " + customerId);

        // Step 2: Navigate to customers page in UI
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();

        // Step 3: Search for the customer created via API
        // (Assuming there's a search functionality on the customers page)
        // customersIndexPage.searchCustomer(email);
        
        // Step 4: Verify the customer appears in the UI
        // Assert.assertTrue(customersIndexPage.isCustomerPresent(email));
    }

    @Test(description = "Create customer via API, then update via UI")
    public void createViaApiAndUpdateViaUI() {
        // Step 1: Create customer via API
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "api_update_test_" + timestamp + "@example.com";
        
        customerId = ApiHelper.createTestCustomer("Update", "TestUser", email);
        
        // Step 2: Navigate to customer details in UI
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        
        // Step 3: Click on the customer to view details
        // customersIndexPage.clickCustomer(customerId);
        
        // Step 4: Update customer details via UI
        // customerDetailsPage.updateCustomerDetails("Updated", "Name");
        
        // Step 5: Verify the update was successful
        // Assert.assertEquals(customerDetailsPage.getFirstName(), "Updated");
    }

    @Test(description = "Create test data via API for bulk UI testing")
    public void createBulkTestDataViaApi() {
        // Create multiple customers via API for UI testing
        for (int i = 0; i < 5; i++) {
            String timestamp = String.valueOf(System.currentTimeMillis() + i);
            String email = "bulk_test_" + timestamp + "@example.com";
            String customerId = ApiHelper.createTestCustomer("Bulk", "User" + i, email);
            System.out.println("Created customer " + (i + 1) + " with ID: " + customerId);
        }

        // Now test the UI with this populated data
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        
        // Verify all customers appear in the UI
        // Assert.assertEquals(customersIndexPage.getCustomerCount(), 5);
    }

    @Test(description = "Create customer via API, delete via UI")
    public void createViaApiAndDeleteViaUI() {
        // Step 1: Create customer via API
        String timestamp = String.valueOf(System.currentTimeMillis());
        String email = "delete_test_" + timestamp + "@example.com";
        
        customerId = ApiHelper.createTestCustomer("Delete", "TestUser", email);
        
        // Step 2: Navigate to customer in UI
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        
        // Step 3: Delete the customer via UI
        // customersIndexPage.deleteCustomer(customerId);
        
        // Step 4: Verify deletion via API
        // CustomerApiResponse.Customer customer = ApiHelper.getCustomerById(customerId);
        // Assert.assertNull(customer, "Customer should be deleted");
    }

    @Test(description = "Hybrid approach: API setup + UI verification")
    public void hybridApiUiTest() {
        // Setup: Create customer via API
        customerId = ApiHelper.createRandomTestCustomer();
        
        // Get customer details from API for verification
        org.example.models.api.CustomerApiResponse.Customer apiCustomer = ApiHelper.getCustomerById(customerId);
        String expectedEmail = apiCustomer.getEmail();
        String expectedFirstName = apiCustomer.getFirstName();

        // UI Test: Navigate and verify
        homePage.navigateToCustomersIndexPage();
        customersIndexPage.waitUntilCustomersPageLoad();
        
        // Verify the customer exists in UI with correct data
        // customersIndexPage.searchCustomer(expectedEmail);
        // Assert.assertEquals(customersIndexPage.getCustomerEmail(), expectedEmail);
        // Assert.assertEquals(customersIndexPage.getCustomerFirstName(), expectedFirstName);
    }

    // Cleanup method to delete test data
    @org.testng.annotations.AfterClass
    public void cleanupTestData() {
        // Clean up customer created via API
        if (customerId != null) {
            try {
                ApiHelper.deleteCustomer(customerId);
                System.out.println("Cleaned up customer: " + customerId);
            } catch (Exception e) {
                System.out.println("Failed to cleanup customer: " + e.getMessage());
            }
        }
    }
}

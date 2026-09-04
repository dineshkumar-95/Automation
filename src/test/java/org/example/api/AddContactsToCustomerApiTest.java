package org.example.api;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.api.models.request.AddContactsToCustomer;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.UpdateContactsToCustomerRequest;
import org.example.api.models.request.common.Contact;
import org.example.api.models.response.Customer;
import org.example.api.utils.ApiResponseUtils;
import org.testng.annotations.Test;

public class AddContactsToCustomerApiTest extends BaseTest {

    private String customerId;

    @Override
    public void setupTestClass(){
        CreateCustomerApiRequest request = new CreateCustomerApiRequest()
                .setEmail("addcontacts"+System.currentTimeMillis()+"@mailinator.com")
                .setFirstName("contact");
        Response response = customerApi.createCustomerApi(request);
        customerId = ApiResponseUtils.customer(response).getId();
    }

//    @Test
    public void addContactsToCustomer(){
        AddContactsToCustomer request = new AddContactsToCustomer()
                .setContact(new Contact()
                        .setEmail("Contact_1_"+System.currentTimeMillis()+"@mailinator.com")
                        .setFirstName("Contact_1")
                );

        Response response = customerApi.addContactToCustomer(customerId,request);

    }

    @Test
    public void updateContactsToCustomer(){
        AddContactsToCustomer request = new AddContactsToCustomer()
                .setContact(new Contact()
                        .setEmail("Contact_1_"+System.currentTimeMillis()+"@mailinator.com")
                        .setFirstName("Contact_1")
                        .setId("3")
                );

        Response response = customerApi.addContactToCustomer(customerId,request);

        UpdateContactsToCustomerRequest updateRequest = new UpdateContactsToCustomerRequest()
                .setContact(new Contact()
                        .setFirstName("update_contact")
                        .setId("3"));
        Response response1 = customerApi.updateContactForCustomer(customerId,updateRequest);

    }


}

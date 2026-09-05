package org.example.api;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.api.models.request.AddContactsToCustomerRequest;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.UpdateContactsForCustomerRequest;
import org.example.api.models.request.common.Contact;
import org.example.api.models.response.Customer;
import org.example.api.utils.ApiResponseUtils;
import org.testng.Assert;
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
//        Assert.assertTrue(false);
    }

//    @Test
    public void addContactsToCustomer(){
        AddContactsToCustomerRequest request = new AddContactsToCustomerRequest()
                .setContact(new Contact()
                        .setEmail("Contact_1_"+System.currentTimeMillis()+"@mailinator.com")
                        .setFirstName("Contact_1")
                );

        Response response = customerApi.addContactToCustomer(customerId,request);

    }

    @Test
    public void updateContactsToCustomer(){
        AddContactsToCustomerRequest request = new AddContactsToCustomerRequest()
                .setContact(new Contact()
                        .setEmail("Contact_1_"+System.currentTimeMillis()+"@mailinator.com")
                        .setFirstName("Contact_1")
                );

        Response response = customerApi.addContactToCustomer(customerId,request);
        Customer customer = ApiResponseUtils.customer(response);
        String ContactId  = customer.getContacts().get(0).getId();


        UpdateContactsForCustomerRequest updateRequest = new UpdateContactsForCustomerRequest()
                .setContact(new Contact()
                        .setFirstName("update_contact")
                        .setId(ContactId)
                );
        Response response1 = customerApi.updateContactForCustomer(customerId,updateRequest);
         customer = ApiResponseUtils.customer(response1);
         ContactId  = customer.getContacts().get(0).getId();



    }


}

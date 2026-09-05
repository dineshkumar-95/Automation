package org.example.api;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.api.models.request.AddContactsToCustomerRequest;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.UpdateContactsForCustomerRequest;
import org.example.api.models.request.common.Contact;
import org.example.api.models.response.Customer;
import org.example.api.models.response.Customers;
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
        customerId = ApiResponseUtils.parse(response).getCustomer().getId();
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
        Customer customer = ApiResponseUtils.parse(response).getCustomer();
        String ContactId  = customer.getContacts().get(0).getId();


        UpdateContactsForCustomerRequest updateRequest = new UpdateContactsForCustomerRequest()
                .setContact(new Contact()
                        .setFirstName("update_contact")
                        .setId(ContactId)
                );
        Response response1 = customerApi.updateContactForCustomer(customerId,updateRequest);
         customer = ApiResponseUtils.parse(response1).getCustomer();
        Customers customers = ApiResponseUtils.parseList(response1).getCustomers();
         ContactId  = customer.getContacts().get(0).getId();



    }


}

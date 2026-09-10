package org.example.api;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.api.dto.request.AddContactsToCustomerRequest;
import org.example.api.dto.request.CreateCustomerRequest;
import org.example.api.dto.request.UpdateContactsForCustomerRequest;
import org.example.api.dto.request.common.Contact;
import org.example.api.model.customer.Customer;
//import org.example.api.model.wrappers.Customers;
import org.example.api.utils.ApiResponseUtils;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactsToCustomerApiTest extends BaseTest {

    private String customerId;

    @Override
    public void setupTestClass(){
        CreateCustomerRequest request = new CreateCustomerRequest()
                .setEmail("addcontacts"+System.currentTimeMillis()+"@mailinator.com")
                .setFirstName("contact");
        Response response = customerApi.createCustomer(request);
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

        Response response = customerApi.addContact(customerId,request);

    }

    @Test
    public void updateContactsToCustomer(){
        AddContactsToCustomerRequest request = new AddContactsToCustomerRequest()
                .setContact(new Contact()
                        .setEmail("Contact_1_"+System.currentTimeMillis()+"@mailinator.com")
                        .setFirstName("Contact_1")
                );

        Response response = customerApi.addContact(customerId,request);
        Customer customer = ApiResponseUtils.parse(response).getCustomer();
        String ContactId  = customer.getContacts().get(0).getId();


        UpdateContactsForCustomerRequest updateRequest = new UpdateContactsForCustomerRequest()
                .setContact(new Contact()
                        .setFirstName("update_contact")
                        .setId(ContactId)
                );
        Response response1 = customerApi.updateContact(customerId,updateRequest);
         customer = ApiResponseUtils.parse(response1).getCustomer();
        Customers customers = ApiResponseUtils.parseList(response1).getCustomers();
        List<Customer> cus = ApiResponseUtils.parseList(response1).getCustomersList();
         ContactId  = customer.getContacts().get(0).getId();



    }


}

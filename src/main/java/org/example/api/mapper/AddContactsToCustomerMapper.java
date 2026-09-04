package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.AddContactsToCustomer;
import org.example.api.models.request.UpdateCustomerApiRequest;
import org.example.api.utils.FormUrlEncoder;

public class AddContactsToCustomerMapper {
    private AddContactsToCustomerMapper() {
    }
    public static String toFormUrlEncoded(AddContactsToCustomer request) {

        StringBuilder formParams = new StringBuilder();
        ChargebeeFormMapper.addContact(formParams, request.getContact());

        return formParams.toString();
    }

}

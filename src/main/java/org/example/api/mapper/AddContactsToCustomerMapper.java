package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.AddContactsToCustomerRequest;

public class AddContactsToCustomerMapper {
    private AddContactsToCustomerMapper() {
    }
    public static String toFormUrlEncoded(AddContactsToCustomerRequest request) {

        StringBuilder formParams = new StringBuilder();
        ChargebeeFormMapper.addContact(formParams, request.getContact());

        return formParams.toString();
    }

}

package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.UpdateContactsForCustomerRequest;

public class UpdateContactsForCustomerMapper {

    private UpdateContactsForCustomerMapper(){}

    public static String toFormUrlEncoded(UpdateContactsForCustomerRequest request){

        StringBuilder formParams = new StringBuilder();
        ChargebeeFormMapper.addContact(formParams,request.getContact());
        return formParams.toString();

    }

}

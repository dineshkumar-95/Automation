package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.models.request.UpdateContactsToCustomerRequest;
import org.example.api.models.request.common.Contact;
import org.example.api.utils.FormUrlEncoder;

import static org.example.api.utils.FormUrlEncoder.addField;

public class UpdateContactsForCustomerMapper {

    private UpdateContactsForCustomerMapper(){}

    public static String toFormUrlEncoded(UpdateContactsToCustomerRequest request){

        StringBuilder formParams = new StringBuilder();
        ChargebeeFormMapper.addContact(formParams,request.getContact());
        return formParams.toString();

    }

}

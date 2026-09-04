package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.api.models.request.common.*;

/**
 * Model class for Chargebee Create Subscription API Request.
 * Supports top-level fields, nested request objects, and list-based
 * subscription items, discounts, and item tiers.
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddContactsToCustomerRequest {

    @JsonProperty("contact")
    private Contact contact;

//    public Contact getContact() {
//        return contact;
//    }
//
//    public AddContactsToCustomer setContact(Contact contact) {
//        this.contact = contact;
//        return this;
//    }

}

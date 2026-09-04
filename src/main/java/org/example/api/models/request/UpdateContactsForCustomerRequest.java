package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.api.models.request.common.Contact;

/**
 * Model class for Chargebee Create Subscription API Request.
 * Supports top-level fields, nested request objects, and list-based
 * subscription items, discounts, and item tiers.
 */

@Setter
@Getter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpdateContactsForCustomerRequest {

    @JsonProperty("contact")
    private Contact contact;


}

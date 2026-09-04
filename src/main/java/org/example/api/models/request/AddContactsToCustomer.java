package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.example.api.models.request.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Subscription API Request.
 * Supports top-level fields, nested request objects, and list-based
 * subscription items, discounts, and item tiers.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddContactsToCustomer {

    @JsonProperty("contact")
    private Contact contact;

}

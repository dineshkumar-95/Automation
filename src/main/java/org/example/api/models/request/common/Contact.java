package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Common class representing Bank Account parameters.
 * Used by CreateCustomerApiRequest.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    @JsonProperty("id]")
    private String Id;

    @JsonProperty("first_name]")
    private String firstName;

    @JsonProperty("last_name]")
    private String lastName;

    @JsonProperty("email]")
    private String email;

    @JsonProperty("phone]")
    private String phone;

    @JsonProperty("label]")
    private String label;

    @JsonProperty("enabled]")
    private String enabled;

    @JsonProperty("send_billing_email]")
    private String sendBillingEmail;

    @JsonProperty("send_account_email]")
    private String sendAccountEmail;

}
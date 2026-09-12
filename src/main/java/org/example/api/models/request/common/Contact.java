package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Common class representing Contact parameters.
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    public Contact() {
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("label")
    private String label;

    @JsonProperty("enabled")
    private String enabled;

    @JsonProperty("send_billing_email")
    private String sendBillingEmail;

    @JsonProperty("send_account_email")
    private String sendAccountEmail;

}
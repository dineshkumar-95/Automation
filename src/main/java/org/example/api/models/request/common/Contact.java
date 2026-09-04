package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Common class representing Bank Account parameters.
 * Used by CreateCustomerApiRequest.
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    public Contact() {
    }

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

//    public String getId() {
//        return Id;
//    }
//
//    public Contact setId(String id) {
//        Id = id;
//        return this;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public Contact setFirstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public Contact setLastName(String lastName) {
//        this.lastName = lastName;
//        return this;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Contact setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public Contact setPhone(String phone) {
//        this.phone = phone;
//        return this;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//
//    public Contact setLabel(String label) {
//        this.label = label;
//        return this;
//    }
//
//    public String getEnabled() {
//        return enabled;
//    }
//
//    public Contact setEnabled(String enabled) {
//        this.enabled = enabled;
//        return this;
//    }
//
//    public String getSendBillingEmail() {
//        return sendBillingEmail;
//    }
//
//    public Contact setSendBillingEmail(String sendBillingEmail) {
//        this.sendBillingEmail = sendBillingEmail;
//        return this;
//    }
//
//    public String getSendAccountEmail() {
//        return sendAccountEmail;
//    }
//
//    public Contact setSendAccountEmail(String sendAccountEmail) {
//        this.sendAccountEmail = sendAccountEmail;
//        return this;
//    }
}
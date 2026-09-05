package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

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
    private Boolean enabled;

    @JsonProperty("send_account_email")
    private Boolean sendAccountEmail;

    @JsonProperty("send_billing_email")
    private Boolean sendBillingEmail;

    public String getId() { return id; }
    public Contact setId(String id) { this.id = id; return this; }

    public String getFirstName() { return firstName; }
    public Contact setFirstName(String firstName) { this.firstName = firstName; return this; }

    public String getLastName() { return lastName; }
    public Contact setLastName(String lastName) { this.lastName = lastName; return this; }

    public String getEmail() { return email; }
    public Contact setEmail(String email) { this.email = email; return this; }

    public String getPhone() { return phone; }
    public Contact setPhone(String phone) { this.phone = phone; return this; }

    public String getLabel() { return label; }
    public Contact setLabel(String label) { this.label = label; return this; }

    public Boolean getEnabled() { return enabled; }
    public Contact setEnabled(Boolean enabled) { this.enabled = enabled; return this; }

    public Boolean getSendAccountEmail() { return sendAccountEmail; }
    public Contact setSendAccountEmail(Boolean sendAccountEmail) { this.sendAccountEmail = sendAccountEmail; return this; }

    public Boolean getSendBillingEmail() { return sendBillingEmail; }
    public Contact setSendBillingEmail(Boolean sendBillingEmail) { this.sendBillingEmail = sendBillingEmail; return this; }
}

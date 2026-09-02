package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Billing Address parameters.
 * Used by CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAddress {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("company")
    private String company;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("line1")
    private String line1;

    @JsonProperty("line2")
    private String line2;

    @JsonProperty("line3")
    private String line3;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("validation_status")
    private String validationStatus;

    public String getFirstName() { return firstName; }
    public BillingAddress setFirstName(String firstName) { this.firstName = firstName; return this; }

    public String getLastName() { return lastName; }
    public BillingAddress setLastName(String lastName) { this.lastName = lastName; return this; }

    public String getEmail() { return email; }
    public BillingAddress setEmail(String email) { this.email = email; return this; }

    public String getCompany() { return company; }
    public BillingAddress setCompany(String company) { this.company = company; return this; }

    public String getPhone() { return phone; }
    public BillingAddress setPhone(String phone) { this.phone = phone; return this; }

    public String getLine1() { return line1; }
    public BillingAddress setLine1(String line1) { this.line1 = line1; return this; }

    public String getLine2() { return line2; }
    public BillingAddress setLine2(String line2) { this.line2 = line2; return this; }

    public String getLine3() { return line3; }
    public BillingAddress setLine3(String line3) { this.line3 = line3; return this; }

    public String getCity() { return city; }
    public BillingAddress setCity(String city) { this.city = city; return this; }

    public String getStateCode() { return stateCode; }
    public BillingAddress setStateCode(String stateCode) { this.stateCode = stateCode; return this; }

    public String getState() { return state; }
    public BillingAddress setState(String state) { this.state = state; return this; }

    public String getZip() { return zip; }
    public BillingAddress setZip(String zip) { this.zip = zip; return this; }

    public String getCountry() { return country; }
    public BillingAddress setCountry(String country) { this.country = country; return this; }

    public String getValidationStatus() { return validationStatus; }
    public BillingAddress setValidationStatus(String validationStatus) { this.validationStatus = validationStatus; return this; }
}
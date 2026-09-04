package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Raw Credit Card parameters.
 * Used by CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("number")
    private String number;

    @JsonProperty("expiry_month")
    private Integer expiryMonth;

    @JsonProperty("expiry_year")
    private Integer expiryYear;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("preferred_scheme")
    private String preferredScheme;

    @JsonProperty("billing_addr1")
    private String billingAddr1;

    @JsonProperty("billing_addr2")
    private String billingAddr2;

    @JsonProperty("billing_city")
    private String billingCity;

    @JsonProperty("billing_state_code")
    private String billingStateCode;

    @JsonProperty("billing_state")
    private String billingState;

    @JsonProperty("billing_zip")
    private String billingZip;

    @JsonProperty("billing_country")
    private String billingCountry;

    @JsonProperty("additional_information")
    private Object additionalInformation;

    public String getGatewayAccountId() { return gatewayAccountId; }
    public Card setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getFirstName() { return firstName; }
    public Card setFirstName(String firstName) { this.firstName = firstName; return this; }

    public String getLastName() { return lastName; }
    public Card setLastName(String lastName) { this.lastName = lastName; return this; }

    public String getNumber() { return number; }
    public Card setNumber(String number) { this.number = number; return this; }

    public Integer getExpiryMonth() { return expiryMonth; }
    public Card setExpiryMonth(Integer expiryMonth) { this.expiryMonth = expiryMonth; return this; }

    public Integer getExpiryYear() { return expiryYear; }
    public Card setExpiryYear(Integer expiryYear) { this.expiryYear = expiryYear; return this; }

    public String getCvv() { return cvv; }
    public Card setCvv(String cvv) { this.cvv = cvv; return this; }

    public String getPreferredScheme() { return preferredScheme; }
    public Card setPreferredScheme(String preferredScheme) { this.preferredScheme = preferredScheme; return this; }

    public String getBillingAddr1() { return billingAddr1; }
    public Card setBillingAddr1(String billingAddr1) { this.billingAddr1 = billingAddr1; return this; }

    public String getBillingAddr2() { return billingAddr2; }
    public Card setBillingAddr2(String billingAddr2) { this.billingAddr2 = billingAddr2; return this; }

    public String getBillingCity() { return billingCity; }
    public Card setBillingCity(String billingCity) { this.billingCity = billingCity; return this; }

    public String getBillingStateCode() { return billingStateCode; }
    public Card setBillingStateCode(String billingStateCode) { this.billingStateCode = billingStateCode; return this; }

    public String getBillingState() { return billingState; }
    public Card setBillingState(String billingState) { this.billingState = billingState; return this; }

    public String getBillingZip() { return billingZip; }
    public Card setBillingZip(String billingZip) { this.billingZip = billingZip; return this; }

    public String getBillingCountry() { return billingCountry; }
    public Card setBillingCountry(String billingCountry) { this.billingCountry = billingCountry; return this; }

    public Object getAdditionalInformation() { return additionalInformation; }
    public Card setAdditionalInformation(Object additionalInformation) { this.additionalInformation = additionalInformation; return this; }
}
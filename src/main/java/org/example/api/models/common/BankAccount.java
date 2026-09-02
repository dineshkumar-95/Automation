package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Bank Account parameters.
 * Used by CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankAccount {

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("company")
    private String company;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("routing_number")
    private String routingNumber;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("account_holder_type")
    private String accountHolderType;

    @JsonProperty("echeck_type")
    private String echeckType;

    @JsonProperty("issuing_country")
    private String issuingCountry;

    @JsonProperty("swedish_identity_number")
    private String swedishIdentityNumber;

    @JsonProperty("billing_address")
    private Object billingAddress;

    public String getGatewayAccountId() { return gatewayAccountId; }
    public BankAccount setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getIban() { return iban; }
    public BankAccount setIban(String iban) { this.iban = iban; return this; }

    public String getFirstName() { return firstName; }
    public BankAccount setFirstName(String firstName) { this.firstName = firstName; return this; }

    public String getLastName() { return lastName; }
    public BankAccount setLastName(String lastName) { this.lastName = lastName; return this; }

    public String getCompany() { return company; }
    public BankAccount setCompany(String company) { this.company = company; return this; }

    public String getEmail() { return email; }
    public BankAccount setEmail(String email) { this.email = email; return this; }

    public String getPhone() { return phone; }
    public BankAccount setPhone(String phone) { this.phone = phone; return this; }

    public String getBankName() { return bankName; }
    public BankAccount setBankName(String bankName) { this.bankName = bankName; return this; }

    public String getAccountNumber() { return accountNumber; }
    public BankAccount setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; return this; }

    public String getRoutingNumber() { return routingNumber; }
    public BankAccount setRoutingNumber(String routingNumber) { this.routingNumber = routingNumber; return this; }

    public String getBankCode() { return bankCode; }
    public BankAccount setBankCode(String bankCode) { this.bankCode = bankCode; return this; }

    public String getAccountType() { return accountType; }
    public BankAccount setAccountType(String accountType) { this.accountType = accountType; return this; }

    public String getAccountHolderType() { return accountHolderType; }
    public BankAccount setAccountHolderType(String accountHolderType) { this.accountHolderType = accountHolderType; return this; }

    public String getEcheckType() { return echeckType; }
    public BankAccount setEcheckType(String echeckType) { this.echeckType = echeckType; return this; }

    public String getIssuingCountry() { return issuingCountry; }
    public BankAccount setIssuingCountry(String issuingCountry) { this.issuingCountry = issuingCountry; return this; }

    public String getSwedishIdentityNumber() { return swedishIdentityNumber; }
    public BankAccount setSwedishIdentityNumber(String swedishIdentityNumber) { this.swedishIdentityNumber = swedishIdentityNumber; return this; }

    public Object getBillingAddress() { return billingAddress; }
    public BankAccount setBillingAddress(Object billingAddress) { this.billingAddress = billingAddress; return this; }
}
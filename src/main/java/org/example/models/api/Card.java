package org.example.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("gateway")
    private String gateway;
    
    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("iin")
    private String iin;
    
    @JsonProperty("last4")
    private String last4;
    
    @JsonProperty("card_type")
    private String cardType;
    
    @JsonProperty("funding_type")
    private String fundingType;
    
    @JsonProperty("expiry_month")
    private Integer expiryMonth;
    
    @JsonProperty("expiry_year")
    private Integer expiryYear;
    
    @JsonProperty("created_at")
    private Long createdAt;
    
    @JsonProperty("updated_at")
    private Long updatedAt;
    
    @JsonProperty("ip_address")
    private String ipAddress;
    
    @JsonProperty("resource_version")
    private Long resourceVersion;
    
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("masked_number")
    private String maskedNumber;
    
    @JsonProperty("customer_id")
    private String customerId;
    
    @JsonProperty("payment_source_id")
    private String paymentSourceId;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getGatewayAccountId() {
        return gatewayAccountId;
    }

    public void setGatewayAccountId(String gatewayAccountId) {
        this.gatewayAccountId = gatewayAccountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFundingType() {
        return fundingType;
    }

    public void setFundingType(String fundingType) {
        this.fundingType = fundingType;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(Long resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMaskedNumber() {
        return maskedNumber;
    }

    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentSourceId() {
        return paymentSourceId;
    }

    public void setPaymentSourceId(String paymentSourceId) {
        this.paymentSourceId = paymentSourceId;
    }
}
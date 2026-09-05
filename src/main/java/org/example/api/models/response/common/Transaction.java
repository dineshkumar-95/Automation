package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("payment_source_id")
    private String paymentSourceId;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("reference_number")
    private String referenceNumber;

    @JsonProperty("gateway")
    private String gateway;

    @JsonProperty("type")
    private String type;

    @JsonProperty("date")
    private Long date;

    @JsonProperty("settled_at")
    private Long settledAt;

    @JsonProperty("exchange_rate")
    private Double exchangeRate;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("id_at_gateway")
    private String idAtGateway;

    @JsonProperty("status")
    private String status;

    @JsonProperty("fraud_flag")
    private String fraudFlag;

    @JsonProperty("initiator_type")
    private String initiatorType;

    @JsonProperty("three_d_secure")
    private Boolean threeDSecure;

    @JsonProperty("authorization_reason")
    private String authorizationReason;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_text")
    private String errorText;

    @JsonProperty("voided_at")
    private Long voidedAt;

    @JsonProperty("resource_version")
    private Long resourceVersion;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("fraud_reason")
    private String fraudReason;

    @JsonProperty("custom_payment_method_id")
    private String customPaymentMethodId;

    @JsonProperty("amount_unused")
    private Integer amountUnused;

    @JsonProperty("amount_capturable")
    private Integer amountCapturable;

    @JsonProperty("masked_card_number")
    private String maskedCardNumber;

    @JsonProperty("reference_transaction_id")
    private String referenceTransactionId;

    @JsonProperty("refunded_txn_id")
    private String refundedTxnId;

    @JsonProperty("reference_authorization_id")
    private String referenceAuthorizationId;

    @JsonProperty("amount_refunded")
    private Integer amountRefunded;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("object")
    private String object;

    // Getters and Setters

    public String getId() { return id; }
    public Transaction setId(String id) { this.id = id; return this; }

    public String getCustomerId() { return customerId; }
    public Transaction setCustomerId(String customerId) { this.customerId = customerId; return this; }

    public String getSubscriptionId() { return subscriptionId; }
    public Transaction setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; return this; }

    public String getGatewayAccountId() { return gatewayAccountId; }
    public Transaction setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getPaymentSourceId() { return paymentSourceId; }
    public Transaction setPaymentSourceId(String paymentSourceId) { this.paymentSourceId = paymentSourceId; return this; }

    public String getPaymentMethod() { return paymentMethod; }
    public Transaction setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; return this; }

    public String getReferenceNumber() { return referenceNumber; }
    public Transaction setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; return this; }

    public String getGateway() { return gateway; }
    public Transaction setGateway(String gateway) { this.gateway = gateway; return this; }

    public String getType() { return type; }
    public Transaction setType(String type) { this.type = type; return this; }

    public Long getDate() { return date; }
    public Transaction setDate(Long date) { this.date = date; return this; }

    public Long getSettledAt() { return settledAt; }
    public Transaction setSettledAt(Long settledAt) { this.settledAt = settledAt; return this; }

    public Double getExchangeRate() { return exchangeRate; }
    public Transaction setExchangeRate(Double exchangeRate) { this.exchangeRate = exchangeRate; return this; }

    public Integer getAmount() { return amount; }
    public Transaction setAmount(Integer amount) { this.amount = amount; return this; }

    public String getIdAtGateway() { return idAtGateway; }
    public Transaction setIdAtGateway(String idAtGateway) { this.idAtGateway = idAtGateway; return this; }

    public String getStatus() { return status; }
    public Transaction setStatus(String status) { this.status = status; return this; }

    public String getFraudFlag() { return fraudFlag; }
    public Transaction setFraudFlag(String fraudFlag) { this.fraudFlag = fraudFlag; return this; }

    public String getInitiatorType() { return initiatorType; }
    public Transaction setInitiatorType(String initiatorType) { this.initiatorType = initiatorType; return this; }

    public Boolean getThreeDSecure() { return threeDSecure; }
    public Transaction setThreeDSecure(Boolean threeDSecure) { this.threeDSecure = threeDSecure; return this; }

    public String getAuthorizationReason() { return authorizationReason; }
    public Transaction setAuthorizationReason(String authorizationReason) { this.authorizationReason = authorizationReason; return this; }

    public String getErrorCode() { return errorCode; }
    public Transaction setErrorCode(String errorCode) { this.errorCode = errorCode; return this; }

    public String getErrorText() { return errorText; }
    public Transaction setErrorText(String errorText) { this.errorText = errorText; return this; }

    public Long getVoidedAt() { return voidedAt; }
    public Transaction setVoidedAt(Long voidedAt) { this.voidedAt = voidedAt; return this; }

    public Long getResourceVersion() { return resourceVersion; }
    public Transaction setResourceVersion(Long resourceVersion) { this.resourceVersion = resourceVersion; return this; }

    public Long getUpdatedAt() { return updatedAt; }
    public Transaction setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; return this; }

    public String getFraudReason() { return fraudReason; }
    public Transaction setFraudReason(String fraudReason) { this.fraudReason = fraudReason; return this; }

    public String getCustomPaymentMethodId() { return customPaymentMethodId; }
    public Transaction setCustomPaymentMethodId(String customPaymentMethodId) { this.customPaymentMethodId = customPaymentMethodId; return this; }

    public Integer getAmountUnused() { return amountUnused; }
    public Transaction setAmountUnused(Integer amountUnused) { this.amountUnused = amountUnused; return this; }

    public Integer getAmountCapturable() { return amountCapturable; }
    public Transaction setAmountCapturable(Integer amountCapturable) { this.amountCapturable = amountCapturable; return this; }

    public String getMaskedCardNumber() { return maskedCardNumber; }
    public Transaction setMaskedCardNumber(String maskedCardNumber) { this.maskedCardNumber = maskedCardNumber; return this; }

    public String getReferenceTransactionId() { return referenceTransactionId; }
    public Transaction setReferenceTransactionId(String referenceTransactionId) { this.referenceTransactionId = referenceTransactionId; return this; }

    public String getRefundedTxnId() { return refundedTxnId; }
    public Transaction setRefundedTxnId(String refundedTxnId) { this.refundedTxnId = refundedTxnId; return this; }

    public String getReferenceAuthorizationId() { return referenceAuthorizationId; }
    public Transaction setReferenceAuthorizationId(String referenceAuthorizationId) { this.referenceAuthorizationId = referenceAuthorizationId; return this; }

    public Integer getAmountRefunded() { return amountRefunded; }
    public Transaction setAmountRefunded(Integer amountRefunded) { this.amountRefunded = amountRefunded; return this; }

    public String getCurrencyCode() { return currencyCode; }
    public Transaction setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; return this; }

    public Boolean getDeleted() { return deleted; }
    public Transaction setDeleted(Boolean deleted) { this.deleted = deleted; return this; }

    public String getObject() { return object; }
    public Transaction setObject(String object) { this.object = object; return this; }
}

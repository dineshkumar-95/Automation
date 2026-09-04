package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Payment Intent parameters.
 * Used by both CreateSubscriptionApiRequest and CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentIntent {

    @JsonProperty("id")
    private String id;

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("gw_token")
    private String gwToken;

    @JsonProperty("payment_method_type")
    private String paymentMethodType;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("additional_information")
    private Object additionalInformation;

    public String getId() {
        return id;
    }

    public PaymentIntent setId(String id) {
        this.id = id;
        return this;
    }

    public String getGatewayAccountId() {
        return gatewayAccountId;
    }

    public PaymentIntent setGatewayAccountId(String gatewayAccountId) {
        this.gatewayAccountId = gatewayAccountId;
        return this;
    }

    public String getGwToken() {
        return gwToken;
    }

    public PaymentIntent setGwToken(String gwToken) {
        this.gwToken = gwToken;
        return this;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public PaymentIntent setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
        return this;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public PaymentIntent setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    public Object getAdditionalInformation() {
        return additionalInformation;
    }

    public PaymentIntent setAdditionalInformation(Object additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }
}
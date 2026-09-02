package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Payment Method parameters.
 * Used by CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethod {

    @JsonProperty("type")
    private String type;

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("tmp_token")
    private String tmpToken;

    @JsonProperty("issuing_country")
    private String issuingCountry;

    @JsonProperty("additional_information")
    private Object additionalInformation;

    public String getType() { return type; }
    public PaymentMethod setType(String type) { this.type = type; return this; }

    public String getGatewayAccountId() { return gatewayAccountId; }
    public PaymentMethod setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getReferenceId() { return referenceId; }
    public PaymentMethod setReferenceId(String referenceId) { this.referenceId = referenceId; return this; }

    public String getTmpToken() { return tmpToken; }
    public PaymentMethod setTmpToken(String tmpToken) { this.tmpToken = tmpToken; return this; }

    public String getIssuingCountry() { return issuingCountry; }
    public PaymentMethod setIssuingCountry(String issuingCountry) { this.issuingCountry = issuingCountry; return this; }

    public Object getAdditionalInformation() { return additionalInformation; }
    public PaymentMethod setAdditionalInformation(Object additionalInformation) { this.additionalInformation = additionalInformation; return this; }
}
package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethod {

    @JsonProperty("object")
    private String object;

    @JsonProperty("type")
    private String type;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("gateway")
    private String gateway;

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("status")
    private String status;

    public String getObject() { return object; }
    public PaymentMethod setObject(String object) { this.object = object; return this; }

    public String getType() { return type; }
    public PaymentMethod setType(String type) { this.type = type; return this; }

    public String getReferenceId() { return referenceId; }
    public PaymentMethod setReferenceId(String referenceId) { this.referenceId = referenceId; return this; }

    public String getGateway() { return gateway; }
    public PaymentMethod setGateway(String gateway) { this.gateway = gateway; return this; }

    public String getGatewayAccountId() { return gatewayAccountId; }
    public PaymentMethod setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getStatus() { return status; }
    public PaymentMethod setStatus(String status) { this.status = status; return this; }
}

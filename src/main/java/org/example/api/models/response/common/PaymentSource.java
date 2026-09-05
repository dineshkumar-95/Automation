package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.Card;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSource {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("gateway")
    private String gateway;

    @JsonProperty("gateway_account_id")
    private String gatewayAccountId;

    @JsonProperty("ip_address")
    private String ipAddress;

    @JsonProperty("issuing_country")
    private String issuingCountry;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("resource_version")
    private Long resourceVersion;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("object")
    private String object;

    // Nested object
    @JsonProperty("card")
    private Card card;

    // Getters and Setters

    public String getId() { return id; }
    public PaymentSource setId(String id) { this.id = id; return this; }

    public String getCustomerId() { return customerId; }
    public PaymentSource setCustomerId(String customerId) { this.customerId = customerId; return this; }

    public String getType() { return type; }
    public PaymentSource setType(String type) { this.type = type; return this; }

    public String getReferenceId() { return referenceId; }
    public PaymentSource setReferenceId(String referenceId) { this.referenceId = referenceId; return this; }

    public String getStatus() { return status; }
    public PaymentSource setStatus(String status) { this.status = status; return this; }

    public String getGateway() { return gateway; }
    public PaymentSource setGateway(String gateway) { this.gateway = gateway; return this; }

    public String getGatewayAccountId() { return gatewayAccountId; }
    public PaymentSource setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

    public String getIpAddress() { return ipAddress; }
    public PaymentSource setIpAddress(String ipAddress) { this.ipAddress = ipAddress; return this; }

    public String getIssuingCountry() { return issuingCountry; }
    public PaymentSource setIssuingCountry(String issuingCountry) { this.issuingCountry = issuingCountry; return this; }

    public Long getCreatedAt() { return createdAt; }
    public PaymentSource setCreatedAt(Long createdAt) { this.createdAt = createdAt; return this; }

    public Long getUpdatedAt() { return updatedAt; }
    public PaymentSource setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; return this; }

    public Long getResourceVersion() { return resourceVersion; }
    public PaymentSource setResourceVersion(Long resourceVersion) { this.resourceVersion = resourceVersion; return this; }

    public Boolean getDeleted() { return deleted; }
    public PaymentSource setDeleted(Boolean deleted) { this.deleted = deleted; return this; }

    public String getObject() { return object; }
    public PaymentSource setObject(String object) { this.object = object; return this; }

    public Card getCard() { return card; }
    public PaymentSource setCard(Card card) { this.card = card; return this; }
}

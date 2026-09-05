package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationship {

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("payment_owner_id")
    private String paymentOwnerId;

    @JsonProperty("invoice_owner_id")
    private String invoiceOwnerId;

    public String getParentId() { return parentId; }
    public Relationship setParentId(String parentId) { this.parentId = parentId; return this; }

    public String getPaymentOwnerId() { return paymentOwnerId; }
    public Relationship setPaymentOwnerId(String paymentOwnerId) { this.paymentOwnerId = paymentOwnerId; return this; }

    public String getInvoiceOwnerId() { return invoiceOwnerId; }
    public Relationship setInvoiceOwnerId(String invoiceOwnerId) { this.invoiceOwnerId = invoiceOwnerId; return this; }
}

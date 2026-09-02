package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Subscription Item parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriptionItem {

    @JsonProperty("item_price_id")
    private String itemPriceId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("quantity_in_decimal")
    private String quantityInDecimal;

    @JsonProperty("unit_price")
    private Long unitPrice;

    @JsonProperty("unit_price_in_decimal")
    private String unitPriceInDecimal;

    @JsonProperty("billing_cycles")
    private Integer billingCycles;

    @JsonProperty("trial_end")
    private Long trialEnd;

    @JsonProperty("service_period_days")
    private Integer servicePeriodDays;

    @JsonProperty("charge_on_event")
    private String chargeOnEvent;

    @JsonProperty("charge_once")
    private Boolean chargeOnce;

    @JsonProperty("description")
    private String description;

    @JsonProperty("charge_on_option")
    private String chargeOnOption;

    @JsonProperty("usage_accumulation_reset_frequency")
    private String usageAccumulationResetFrequency;

    public SubscriptionItem() {
    }

    public String getItemPriceId() {
        return itemPriceId;
    }

    public SubscriptionItem setItemPriceId(String itemPriceId) {
        this.itemPriceId = itemPriceId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public SubscriptionItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getQuantityInDecimal() {
        return quantityInDecimal;
    }

    public SubscriptionItem setQuantityInDecimal(String quantityInDecimal) {
        this.quantityInDecimal = quantityInDecimal;
        return this;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public SubscriptionItem setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public String getUnitPriceInDecimal() {
        return unitPriceInDecimal;
    }

    public SubscriptionItem setUnitPriceInDecimal(String unitPriceInDecimal) {
        this.unitPriceInDecimal = unitPriceInDecimal;
        return this;
    }

    public Integer getBillingCycles() {
        return billingCycles;
    }

    public SubscriptionItem setBillingCycles(Integer billingCycles) {
        this.billingCycles = billingCycles;
        return this;
    }

    public Long getTrialEnd() {
        return trialEnd;
    }

    public SubscriptionItem setTrialEnd(Long trialEnd) {
        this.trialEnd = trialEnd;
        return this;
    }

    public Integer getServicePeriodDays() {
        return servicePeriodDays;
    }

    public SubscriptionItem setServicePeriodDays(Integer servicePeriodDays) {
        this.servicePeriodDays = servicePeriodDays;
        return this;
    }

    public String getChargeOnEvent() {
        return chargeOnEvent;
    }

    public SubscriptionItem setChargeOnEvent(String chargeOnEvent) {
        this.chargeOnEvent = chargeOnEvent;
        return this;
    }

    public Boolean getChargeOnce() {
        return chargeOnce;
    }

    public SubscriptionItem setChargeOnce(Boolean chargeOnce) {
        this.chargeOnce = chargeOnce;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubscriptionItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getChargeOnOption() {
        return chargeOnOption;
    }

    public SubscriptionItem setChargeOnOption(String chargeOnOption) {
        this.chargeOnOption = chargeOnOption;
        return this;
    }

    public String getUsageAccumulationResetFrequency() {
        return usageAccumulationResetFrequency;
    }

    public SubscriptionItem setUsageAccumulationResetFrequency(String usageAccumulationResetFrequency) {
        this.usageAccumulationResetFrequency = usageAccumulationResetFrequency;
        return this;
    }
}
package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Discount parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Discount {

    @JsonProperty("apply_on")
    private String applyOn;

    @JsonProperty("duration_type")
    private String durationType;

    @JsonProperty("percentage")
    private Double percentage;

    @JsonProperty("amount")
    private Long amount;

    @JsonProperty("period")
    private Integer period;

    @JsonProperty("period_unit")
    private String periodUnit;

    @JsonProperty("included_in_mrr")
    private Boolean includedInMrr;

    @JsonProperty("item_price_id")
    private String itemPriceId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("discount_id")
    private String discountId;

    public Discount() {
    }

    public String getApplyOn() {
        return applyOn;
    }

    public Discount setApplyOn(String applyOn) {
        this.applyOn = applyOn;
        return this;
    }

    public String getDurationType() {
        return durationType;
    }

    public Discount setDurationType(String durationType) {
        this.durationType = durationType;
        return this;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Discount setPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public Discount setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public Integer getPeriod() {
        return period;
    }

    public Discount setPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public String getPeriodUnit() {
        return periodUnit;
    }

    public Discount setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
        return this;
    }

    public Boolean getIncludedInMrr() {
        return includedInMrr;
    }

    public Discount setIncludedInMrr(Boolean includedInMrr) {
        this.includedInMrr = includedInMrr;
        return this;
    }

    public String getItemPriceId() {
        return itemPriceId;
    }

    public Discount setItemPriceId(String itemPriceId) {
        this.itemPriceId = itemPriceId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Discount setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDiscountId() {
        return discountId != null ? discountId : itemPriceId;
    }

    public Discount setDiscountId(String discountId) {
        this.discountId = discountId;
        return this;
    }
}
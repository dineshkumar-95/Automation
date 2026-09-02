package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Billing Override parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingOverride {

    @JsonProperty("max_excess_payment_usage")
    private Long maxExcessPaymentUsage;

    @JsonProperty("max_refundable_credits_usage")
    private Long maxRefundableCreditsUsage;

    public Long getMaxExcessPaymentUsage() {
        return maxExcessPaymentUsage;
    }

    public BillingOverride setMaxExcessPaymentUsage(Long maxExcessPaymentUsage) {
        this.maxExcessPaymentUsage = maxExcessPaymentUsage;
        return this;
    }

    public Long getMaxRefundableCreditsUsage() {
        return maxRefundableCreditsUsage;
    }

    public BillingOverride setMaxRefundableCreditsUsage(Long maxRefundableCreditsUsage) {
        this.maxRefundableCreditsUsage = maxRefundableCreditsUsage;
        return this;
    }
}
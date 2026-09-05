package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Balance {

    @JsonProperty("promotional_credits")
    private Integer promotionalCredits;

    @JsonProperty("excess_payments")
    private Integer excessPayments;

    @JsonProperty("refundable_credits")
    private Integer refundableCredits;

    @JsonProperty("unbilled_charges")
    private Integer unbilledCharges;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("balance_currency_code")
    private String balanceCurrencyCode;

    public Integer getPromotionalCredits() { return promotionalCredits; }
    public Balance setPromotionalCredits(Integer promotionalCredits) { this.promotionalCredits = promotionalCredits; return this; }

    public Integer getExcessPayments() { return excessPayments; }
    public Balance setExcessPayments(Integer excessPayments) { this.excessPayments = excessPayments; return this; }

    public Integer getRefundableCredits() { return refundableCredits; }
    public Balance setRefundableCredits(Integer refundableCredits) { this.refundableCredits = refundableCredits; return this; }

    public Integer getUnbilledCharges() { return unbilledCharges; }
    public Balance setUnbilledCharges(Integer unbilledCharges) { this.unbilledCharges = unbilledCharges; return this; }

    public String getCurrencyCode() { return currencyCode; }
    public Balance setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; return this; }

    public String getBalanceCurrencyCode() { return balanceCurrencyCode; }
    public Balance setBalanceCurrencyCode(String balanceCurrencyCode) { this.balanceCurrencyCode = balanceCurrencyCode; return this; }
}

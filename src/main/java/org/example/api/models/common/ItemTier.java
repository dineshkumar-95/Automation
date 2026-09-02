package org.example.api.models.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Item Tier parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemTier {

    @JsonProperty("item_price_id")
    private String itemPriceId;

    @JsonProperty("starting_unit")
    private Integer startingUnit;

    @JsonProperty("ending_unit")
    private Integer endingUnit;

    @JsonProperty("price")
    private Long price;

    @JsonProperty("starting_unit_in_decimal")
    private String startingUnitInDecimal;

    @JsonProperty("ending_unit_in_decimal")
    private String endingUnitInDecimal;

    @JsonProperty("price_in_decimal")
    private String priceInDecimal;

    @JsonProperty("pricing_type")
    private String pricingType;

    @JsonProperty("package_size")
    private Integer packageSize;

    public ItemTier() {
    }

    public String getItemPriceId() {
        return itemPriceId;
    }

    public ItemTier setItemPriceId(String itemPriceId) {
        this.itemPriceId = itemPriceId;
        return this;
    }

    public Integer getStartingUnit() {
        return startingUnit;
    }

    public ItemTier setStartingUnit(Integer startingUnit) {
        this.startingUnit = startingUnit;
        return this;
    }

    public Integer getEndingUnit() {
        return endingUnit;
    }

    public ItemTier setEndingUnit(Integer endingUnit) {
        this.endingUnit = endingUnit;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public ItemTier setPrice(Long price) {
        this.price = price;
        return this;
    }

    public String getStartingUnitInDecimal() {
        return startingUnitInDecimal;
    }

    public ItemTier setStartingUnitInDecimal(String startingUnitInDecimal) {
        this.startingUnitInDecimal = startingUnitInDecimal;
        return this;
    }

    public String getEndingUnitInDecimal() {
        return endingUnitInDecimal;
    }

    public ItemTier setEndingUnitInDecimal(String endingUnitInDecimal) {
        this.endingUnitInDecimal = endingUnitInDecimal;
        return this;
    }

    public String getPriceInDecimal() {
        return priceInDecimal;
    }

    public ItemTier setPriceInDecimal(String priceInDecimal) {
        this.priceInDecimal = priceInDecimal;
        return this;
    }

    public String getPricingType() {
        return pricingType;
    }

    public ItemTier setPricingType(String pricingType) {
        this.pricingType = pricingType;
        return this;
    }

    public Integer getPackageSize() {
        return packageSize;
    }

    public ItemTier setPackageSize(Integer packageSize) {
        this.packageSize = packageSize;
        return this;
    }
}
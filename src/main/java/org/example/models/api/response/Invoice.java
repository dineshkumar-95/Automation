package org.example.models.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("recurring")
    private Boolean recurring;

    @JsonProperty("status")
    private String status;

    @JsonProperty("date")
    private Long date;

    @JsonProperty("due_date")
    private Long dueDate;

    @JsonProperty("net_term_days")
    private Integer netTermDays;

    @JsonProperty("price_type")
    private String priceType;

    @JsonProperty("exchange_rate")
    private Double exchangeRate;

    @JsonProperty("total")
    private Long total;

    @JsonProperty("amount_due")
    private Long amountDue;

    @JsonProperty("amount_adjusted")
    private Long amountAdjusted;

    @JsonProperty("amount_paid")
    private Long amountPaid;

    @JsonProperty("write_off_amount")
    private Long writeOffAmount;

    @JsonProperty("credits_applied")
    private Long creditsApplied;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("resource_version")
    private Long resourceVersion;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("object")
    private String object;

    @JsonProperty("first_invoice")
    private Boolean firstInvoice;

    @JsonProperty("amount_to_collect")
    private Long amountToCollect;

    @JsonProperty("round_off_amount")
    private Long roundOffAmount;

    @JsonProperty("new_sales_amount")
    private Long newSalesAmount;

    @JsonProperty("has_advance_charges")
    private Boolean hasAdvanceCharges;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("base_currency_code")
    private String baseCurrencyCode;

    @JsonProperty("generated_at")
    private Long generatedAt;

    @JsonProperty("is_gifted")
    private Boolean isGifted;

    @JsonProperty("term_finalized")
    private Boolean termFinalized;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("tax")
    private Long tax;

    @JsonProperty("sub_total")
    private Long subTotal;

    @JsonProperty("line_items")
    private List<LineItem> lineItems;

    @JsonProperty("line_item_tiers")
    private List<LineItemTier> lineItemTiers;

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public void setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Long amountDue) {
        this.amountDue = amountDue;
    }

    public Long getAmountAdjusted() {
        return amountAdjusted;
    }

    public void setAmountAdjusted(Long amountAdjusted) {
        this.amountAdjusted = amountAdjusted;
    }

    public Long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Long getWriteOffAmount() {
        return writeOffAmount;
    }

    public void setWriteOffAmount(Long writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    public Long getCreditsApplied() {
        return creditsApplied;
    }

    public void setCreditsApplied(Long creditsApplied) {
        this.creditsApplied = creditsApplied;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(Long resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Boolean getFirstInvoice() {
        return firstInvoice;
    }

    public void setFirstInvoice(Boolean firstInvoice) {
        this.firstInvoice = firstInvoice;
    }

    public Long getAmountToCollect() {
        return amountToCollect;
    }

    public void setAmountToCollect(Long amountToCollect) {
        this.amountToCollect = amountToCollect;
    }

    public Long getRoundOffAmount() {
        return roundOffAmount;
    }

    public void setRoundOffAmount(Long roundOffAmount) {
        this.roundOffAmount = roundOffAmount;
    }

    public Long getNewSalesAmount() {
        return newSalesAmount;
    }

    public void setNewSalesAmount(Long newSalesAmount) {
        this.newSalesAmount = newSalesAmount;
    }

    public Boolean getHasAdvanceCharges() {
        return hasAdvanceCharges;
    }

    public void setHasAdvanceCharges(Boolean hasAdvanceCharges) {
        this.hasAdvanceCharges = hasAdvanceCharges;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public Long getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Long generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Boolean getIsGifted() {
        return isGifted;
    }

    public void setIsGifted(Boolean isGifted) {
        this.isGifted = isGifted;
    }

    public Boolean getTermFinalized() {
        return termFinalized;
    }

    public void setTermFinalized(Boolean termFinalized) {
        this.termFinalized = termFinalized;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItemTier> getLineItemTiers() {
        return lineItemTiers;
    }

    public void setLineItemTiers(List<LineItemTier> lineItemTiers) {
        this.lineItemTiers = lineItemTiers;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    // Inner classes for LineItem, LineItemTier, BillingAddress

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineItem {
        @JsonProperty("id")
        private String id;

        @JsonProperty("date_from")
        private Long dateFrom;

        @JsonProperty("date_to")
        private Long dateTo;

        @JsonProperty("unit_amount")
        private Long unitAmount;

        @JsonProperty("quantity")
        private Integer quantity;

        @JsonProperty("amount")
        private Long amount;

        @JsonProperty("pricing_model")
        private String pricingModel;

        @JsonProperty("is_taxed")
        private Boolean isTaxed;

        @JsonProperty("tax_amount")
        private Long taxAmount;

        @JsonProperty("object")
        private String object;

        @JsonProperty("subscription_id")
        private String subscriptionId;

        @JsonProperty("customer_id")
        private String customerId;

        @JsonProperty("description")
        private String description;

        @JsonProperty("entity_type")
        private String entityType;

        @JsonProperty("entity_id")
        private String entityId;

        @JsonProperty("metered")
        private Boolean metered;

        @JsonProperty("tax_exempt_reason")
        private String taxExemptReason;

        @JsonProperty("discount_amount")
        private Long discountAmount;

        @JsonProperty("item_level_discount_amount")
        private Long itemLevelDiscountAmount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(Long dateFrom) {
            this.dateFrom = dateFrom;
        }

        public Long getDateTo() {
            return dateTo;
        }

        public void setDateTo(Long dateTo) {
            this.dateTo = dateTo;
        }

        public Long getUnitAmount() {
            return unitAmount;
        }

        public void setUnitAmount(Long unitAmount) {
            this.unitAmount = unitAmount;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getPricingModel() {
            return pricingModel;
        }

        public void setPricingModel(String pricingModel) {
            this.pricingModel = pricingModel;
        }

        public Boolean getIsTaxed() {
            return isTaxed;
        }

        public void setIsTaxed(Boolean isTaxed) {
            this.isTaxed = isTaxed;
        }

        public Long getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(Long taxAmount) {
            this.taxAmount = taxAmount;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getSubscriptionId() {
            return subscriptionId;
        }

        public void setSubscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public Boolean getMetered() {
            return metered;
        }

        public void setMetered(Boolean metered) {
            this.metered = metered;
        }

        public String getTaxExemptReason() {
            return taxExemptReason;
        }

        public void setTaxExemptReason(String taxExemptReason) {
            this.taxExemptReason = taxExemptReason;
        }

        public Long getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(Long discountAmount) {
            this.discountAmount = discountAmount;
        }

        public Long getItemLevelDiscountAmount() {
            return itemLevelDiscountAmount;
        }

        public void setItemLevelDiscountAmount(Long itemLevelDiscountAmount) {
            this.itemLevelDiscountAmount = itemLevelDiscountAmount;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineItemTier {
        @JsonProperty("starting_unit")
        private Integer startingUnit;

        @JsonProperty("ending_unit")
        private Integer endingUnit;

        @JsonProperty("quantity_used")
        private Integer quantityUsed;

        @JsonProperty("unit_amount")
        private Long unitAmount;

        @JsonProperty("pricing_type")
        private String pricingType;

        @JsonProperty("object")
        private String object;

        @JsonProperty("line_item_id")
        private String lineItemId;

        public Integer getStartingUnit() {
            return startingUnit;
        }

        public void setStartingUnit(Integer startingUnit) {
            this.startingUnit = startingUnit;
        }

        public Integer getEndingUnit() {
            return endingUnit;
        }

        public void setEndingUnit(Integer endingUnit) {
            this.endingUnit = endingUnit;
        }

        public Integer getQuantityUsed() {
            return quantityUsed;
        }

        public void setQuantityUsed(Integer quantityUsed) {
            this.quantityUsed = quantityUsed;
        }

        public Long getUnitAmount() {
            return unitAmount;
        }

        public void setUnitAmount(Long unitAmount) {
            this.unitAmount = unitAmount;
        }

        public String getPricingType() {
            return pricingType;
        }

        public void setPricingType(String pricingType) {
            this.pricingType = pricingType;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getLineItemId() {
            return lineItemId;
        }

        public void setLineItemId(String lineItemId) {
            this.lineItemId = lineItemId;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BillingAddress {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("company")
        private String company;

        @JsonProperty("validation_status")
        private String validationStatus;

        @JsonProperty("object")
        private String object;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getValidationStatus() {
            return validationStatus;
        }

        public void setValidationStatus(String validationStatus) {
            this.validationStatus = validationStatus;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }
    }
}

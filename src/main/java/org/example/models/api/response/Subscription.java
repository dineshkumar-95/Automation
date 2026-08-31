package org.example.models.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    @JsonProperty("id")
    private String id;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("auto_collection")
    private String autoCollection;

    @JsonProperty("billing_period")
    private Integer billingPeriod;

    @JsonProperty("billing_period_unit")
    private String billingPeriodUnit;

    @JsonProperty("current_term_start")
    private Long currentTermStart;

    @JsonProperty("current_term_end")
    private Long currentTermEnd;

    @JsonProperty("next_billing_at")
    private Long nextBillingAt;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("started_at")
    private Long startedAt;

    @JsonProperty("activated_at")
    private Long activatedAt;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("has_scheduled_changes")
    private Boolean hasScheduledChanges;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("resource_version")
    private Long resourceVersion;

    @JsonProperty("deleted")
    private Boolean deleted;

    @JsonProperty("object")
    private String object;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("subscription_items")
    private List<SubscriptionItemResponse> subscriptionItems;

    @JsonProperty("item_tiers")
    private List<ItemTierResponse> itemTiers;

    @JsonProperty("due_invoices_count")
    private Integer dueInvoicesCount;

    @JsonProperty("due_since")
    private Long dueSince;

    @JsonProperty("total_dues")
    private Long totalDues;

    @JsonProperty("mrr")
    private Long mrr;

    @JsonProperty("has_scheduled_advance_invoices")
    private Boolean hasScheduledAdvanceInvoices;

    @JsonProperty("decommissioned")
    private Boolean decommissioned;

    @JsonProperty("create_pending_invoices")
    private Boolean createPendingInvoices;

    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public void setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
    }

    public Integer getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(Integer billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public String getBillingPeriodUnit() {
        return billingPeriodUnit;
    }

    public void setBillingPeriodUnit(String billingPeriodUnit) {
        this.billingPeriodUnit = billingPeriodUnit;
    }

    public Long getCurrentTermStart() {
        return currentTermStart;
    }

    public void setCurrentTermStart(Long currentTermStart) {
        this.currentTermStart = currentTermStart;
    }

    public Long getCurrentTermEnd() {
        return currentTermEnd;
    }

    public void setCurrentTermEnd(Long currentTermEnd) {
        this.currentTermEnd = currentTermEnd;
    }

    public Long getNextBillingAt() {
        return nextBillingAt;
    }

    public void setNextBillingAt(Long nextBillingAt) {
        this.nextBillingAt = nextBillingAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Long startedAt) {
        this.startedAt = startedAt;
    }

    public Long getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Long activatedAt) {
        this.activatedAt = activatedAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getHasScheduledChanges() {
        return hasScheduledChanges;
    }

    public void setHasScheduledChanges(Boolean hasScheduledChanges) {
        this.hasScheduledChanges = hasScheduledChanges;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<SubscriptionItemResponse> getSubscriptionItems() {
        return subscriptionItems;
    }

    public void setSubscriptionItems(List<SubscriptionItemResponse> subscriptionItems) {
        this.subscriptionItems = subscriptionItems;
    }

    public List<ItemTierResponse> getItemTiers() {
        return itemTiers;
    }

    public void setItemTiers(List<ItemTierResponse> itemTiers) {
        this.itemTiers = itemTiers;
    }

    public Integer getDueInvoicesCount() {
        return dueInvoicesCount;
    }

    public void setDueInvoicesCount(Integer dueInvoicesCount) {
        this.dueInvoicesCount = dueInvoicesCount;
    }

    public Long getDueSince() {
        return dueSince;
    }

    public void setDueSince(Long dueSince) {
        this.dueSince = dueSince;
    }

    public Long getTotalDues() {
        return totalDues;
    }

    public void setTotalDues(Long totalDues) {
        this.totalDues = totalDues;
    }

    public Long getMrr() {
        return mrr;
    }

    public void setMrr(Long mrr) {
        this.mrr = mrr;
    }

    public Boolean getHasScheduledAdvanceInvoices() {
        return hasScheduledAdvanceInvoices;
    }

    public void setHasScheduledAdvanceInvoices(Boolean hasScheduledAdvanceInvoices) {
        this.hasScheduledAdvanceInvoices = hasScheduledAdvanceInvoices;
    }

    public Boolean getDecommissioned() {
        return decommissioned;
    }

    public void setDecommissioned(Boolean decommissioned) {
        this.decommissioned = decommissioned;
    }

    public Boolean getCreatePendingInvoices() {
        return createPendingInvoices;
    }

    public void setCreatePendingInvoices(Boolean createPendingInvoices) {
        this.createPendingInvoices = createPendingInvoices;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public void setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
    }

    // Inner classes for response details

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubscriptionItemResponse {
        @JsonProperty("item_price_id")
        private String itemPriceId;

        @JsonProperty("item_type")
        private String itemType;

        @JsonProperty("quantity")
        private Integer quantity;

        @JsonProperty("unit_price")
        private Long unitPrice;

        @JsonProperty("amount")
        private Long amount;

        @JsonProperty("current_term_start")
        private Long currentTermStart;

        @JsonProperty("current_term_end")
        private Long currentTermEnd;

        @JsonProperty("next_billing_at")
        private Long nextBillingAt;

        @JsonProperty("billing_period")
        private Integer billingPeriod;

        @JsonProperty("billing_period_unit")
        private String billingPeriodUnit;

        @JsonProperty("free_quantity")
        private Integer freeQuantity;

        @JsonProperty("object")
        private String object;

        public String getItemPriceId() {
            return itemPriceId;
        }

        public void setItemPriceId(String itemPriceId) {
            this.itemPriceId = itemPriceId;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Long getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Long unitPrice) {
            this.unitPrice = unitPrice;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public Long getCurrentTermStart() {
            return currentTermStart;
        }

        public void setCurrentTermStart(Long currentTermStart) {
            this.currentTermStart = currentTermStart;
        }

        public Long getCurrentTermEnd() {
            return currentTermEnd;
        }

        public void setCurrentTermEnd(Long currentTermEnd) {
            this.currentTermEnd = currentTermEnd;
        }

        public Long getNextBillingAt() {
            return nextBillingAt;
        }

        public void setNextBillingAt(Long nextBillingAt) {
            this.nextBillingAt = nextBillingAt;
        }

        public Integer getBillingPeriod() {
            return billingPeriod;
        }

        public void setBillingPeriod(Integer billingPeriod) {
            this.billingPeriod = billingPeriod;
        }

        public String getBillingPeriodUnit() {
            return billingPeriodUnit;
        }

        public void setBillingPeriodUnit(String billingPeriodUnit) {
            this.billingPeriodUnit = billingPeriodUnit;
        }

        public Integer getFreeQuantity() {
            return freeQuantity;
        }

        public void setFreeQuantity(Integer freeQuantity) {
            this.freeQuantity = freeQuantity;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ItemTierResponse {
        @JsonProperty("item_price_id")
        private String itemPriceId;

        @JsonProperty("starting_unit")
        private Integer startingUnit;

        @JsonProperty("ending_unit")
        private Integer endingUnit;

        @JsonProperty("price")
        private Long price;

        @JsonProperty("pricing_type")
        private String pricingType;

        @JsonProperty("object")
        private String object;

        public String getItemPriceId() {
            return itemPriceId;
        }

        public void setItemPriceId(String itemPriceId) {
            this.itemPriceId = itemPriceId;
        }

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

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
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
    }
}

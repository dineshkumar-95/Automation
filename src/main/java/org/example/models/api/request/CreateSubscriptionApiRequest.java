package org.example.models.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Subscription API Request.
 * Supports all input parameters from Chargebee API documentation with inner
 * classes for subsections,
 * object-based list additions, and index-based parameter accessors (e.g.
 * subscription_items[item_price_id][0]).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSubscriptionApiRequest {

    // ========== TOP-LEVEL SUBSCRIPTION FIELDS ==========

    @JsonProperty("id")
    private String id;

    @JsonProperty("business_entity_id")
    private String businessEntityId;

    @JsonProperty("trial_end")
    private Long trialEnd;

    @JsonProperty("billing_cycles")
    private Integer billingCycles;

    @JsonProperty("mandatory_items_to_remove")
    private String mandatoryItemsToRemove;

    @JsonProperty("net_term_days")
    private Integer netTermDays;

    @JsonProperty("start_date")
    private Long startDate;

    @JsonProperty("auto_collection")
    private String autoCollection;

    @JsonProperty("terms_to_charge")
    private Integer termsToCharge;

    @JsonProperty("billing_alignment_mode")
    private String billingAlignmentMode;

    @JsonProperty("offline_payment_method")
    private String offlinePaymentMethod;

    @JsonProperty("po_number")
    private String poNumber;

    @JsonProperty("coupon_ids")
    private String couponIds;

    @JsonProperty("payment_source_id")
    private String paymentSourceId;

    @JsonProperty("override_relationship")
    private Boolean overrideRelationship;

    @JsonProperty("invoice_notes")
    private String invoiceNotes;

    @JsonProperty("invoice_date")
    private Long invoiceDate;

    @JsonProperty("meta_data")
    private Object metaData;

    @JsonProperty("invoice_immediately")
    private Boolean invoiceImmediately;

    @JsonProperty("replace_primary_payment_source")
    private Boolean replacePrimaryPaymentSource;

    @JsonProperty("free_period")
    private Integer freePeriod;

    @JsonProperty("free_period_unit")
    private String freePeriodUnit;

    @JsonProperty("contract_term_billing_cycle_on_renewal")
    private Integer contractTermBillingCycleOnRenewal;

    @JsonProperty("create_pending_invoices")
    private Boolean createPendingInvoices;

    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;

    @JsonProperty("first_invoice_pending")
    private Boolean firstInvoicePending;

    @JsonProperty("trial_end_action")
    private String trialEndAction;

    @JsonProperty("payment_initiator")
    private String paymentInitiator;

    // ========== SUBSECTIONS (NESTED OBJECTS & LISTS) ==========

    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    @JsonProperty("statement_descriptor")
    private StatementDescriptor statementDescriptor;

    @JsonProperty("payment_intent")
    private PaymentIntent paymentIntent;

    @JsonProperty("contract_term")
    private ContractTerm contractTerm;

    @JsonProperty("billing_override")
    private BillingOverride billingOverride;

    @JsonProperty("subscription_items")
    private List<SubscriptionItem> subscriptionItems;

    @JsonProperty("discounts")
    private List<Discount> discounts;

    @JsonProperty("item_tiers")
    private List<ItemTier> itemTiers;

    public CreateSubscriptionApiRequest() {
        this.subscriptionItems = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.itemTiers = new ArrayList<>();
    }

    // ========== OBJECT-BASED HELPER METHODS FOR LISTS ==========

    public CreateSubscriptionApiRequest addSubscriptionItem(SubscriptionItem item) {
        if (this.subscriptionItems == null) {
            this.subscriptionItems = new ArrayList<>();
        }
        this.subscriptionItems.add(item);
        return this;
    }

    public CreateSubscriptionApiRequest addSubscriptionItem(String itemPriceId, Integer quantity) {
        return addSubscriptionItem(new SubscriptionItem().setItemPriceId(itemPriceId).setQuantity(quantity));
    }

    public CreateSubscriptionApiRequest addSubscriptionItem(String itemPriceId) {
        return addSubscriptionItem(itemPriceId, 1);
    }

    public CreateSubscriptionApiRequest addDiscount(Discount discount) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.add(discount);
        return this;
    }

    public CreateSubscriptionApiRequest addDiscount(String discountId, Integer quantity) {
        return addDiscount(new Discount().setDiscountId(discountId).setQuantity(quantity));
    }

    public CreateSubscriptionApiRequest addItemTier(ItemTier itemTier) {
        if (this.itemTiers == null) {
            this.itemTiers = new ArrayList<>();
        }
        this.itemTiers.add(itemTier);
        return this;
    }

    // ========== INDEXED ACCESSORS FOR SUBSCRIPTION ITEMS (e.g.
    // subscription_items[item_price_id][index]) ==========

    private SubscriptionItem getOrCreateSubscriptionItem(int index) {
        if (this.subscriptionItems == null) {
            this.subscriptionItems = new ArrayList<>();
        }
        while (this.subscriptionItems.size() <= index) {
            this.subscriptionItems.add(new SubscriptionItem());
        }
        return this.subscriptionItems.get(index);
    }

    public CreateSubscriptionApiRequest subscriptionItemItemPriceId(int index, String itemPriceId) {
        getOrCreateSubscriptionItem(index).setItemPriceId(itemPriceId);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemQuantity(int index, Integer quantity) {
        getOrCreateSubscriptionItem(index).setQuantity(quantity);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemQuantityInDecimal(int index, String quantityInDecimal) {
        getOrCreateSubscriptionItem(index).setQuantityInDecimal(quantityInDecimal);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemUnitPrice(int index, Long unitPrice) {
        getOrCreateSubscriptionItem(index).setUnitPrice(unitPrice);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemUnitPrice(int index, Integer unitPrice) {
        getOrCreateSubscriptionItem(index).setUnitPrice(unitPrice != null ? unitPrice.longValue() : null);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemUnitPriceInDecimal(int index, String unitPriceInDecimal) {
        getOrCreateSubscriptionItem(index).setUnitPriceInDecimal(unitPriceInDecimal);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemBillingCycles(int index, Integer billingCycles) {
        getOrCreateSubscriptionItem(index).setBillingCycles(billingCycles);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemTrialEnd(int index, Long trialEnd) {
        getOrCreateSubscriptionItem(index).setTrialEnd(trialEnd);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemServicePeriodDays(int index, Integer servicePeriodDays) {
        getOrCreateSubscriptionItem(index).setServicePeriodDays(servicePeriodDays);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemChargeOnEvent(int index, String chargeOnEvent) {
        getOrCreateSubscriptionItem(index).setChargeOnEvent(chargeOnEvent);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemChargeOnce(int index, Boolean chargeOnce) {
        getOrCreateSubscriptionItem(index).setChargeOnce(chargeOnce);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemDescription(int index, String description) {
        getOrCreateSubscriptionItem(index).setDescription(description);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemChargeOnOption(int index, String chargeOnOption) {
        getOrCreateSubscriptionItem(index).setChargeOnOption(chargeOnOption);
        return this;
    }

    public CreateSubscriptionApiRequest subscriptionItemUsageAccumulationResetFrequency(int index, String freq) {
        getOrCreateSubscriptionItem(index).setUsageAccumulationResetFrequency(freq);
        return this;
    }

    // ========== INDEXED ACCESSORS FOR DISCOUNTS (e.g.
    // discounts[discount_id][index]) ==========

    private Discount getOrCreateDiscount(int index) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        while (this.discounts.size() <= index) {
            this.discounts.add(new Discount());
        }
        return this.discounts.get(index);
    }

    public CreateSubscriptionApiRequest discountApplyOn(int index, String applyOn) {
        getOrCreateDiscount(index).setApplyOn(applyOn);
        return this;
    }

    public CreateSubscriptionApiRequest discountDurationType(int index, String durationType) {
        getOrCreateDiscount(index).setDurationType(durationType);
        return this;
    }

    public CreateSubscriptionApiRequest discountPercentage(int index, Double percentage) {
        getOrCreateDiscount(index).setPercentage(percentage);
        return this;
    }

    public CreateSubscriptionApiRequest discountAmount(int index, Long amount) {
        getOrCreateDiscount(index).setAmount(amount);
        return this;
    }

    public CreateSubscriptionApiRequest discountPeriod(int index, Integer period) {
        getOrCreateDiscount(index).setPeriod(period);
        return this;
    }

    public CreateSubscriptionApiRequest discountPeriodUnit(int index, String periodUnit) {
        getOrCreateDiscount(index).setPeriodUnit(periodUnit);
        return this;
    }

    public CreateSubscriptionApiRequest discountIncludedInMrr(int index, Boolean includedInMrr) {
        getOrCreateDiscount(index).setIncludedInMrr(includedInMrr);
        return this;
    }

    public CreateSubscriptionApiRequest discountItemPriceId(int index, String itemPriceId) {
        getOrCreateDiscount(index).setItemPriceId(itemPriceId);
        return this;
    }

    public CreateSubscriptionApiRequest discountQuantity(int index, Integer quantity) {
        getOrCreateDiscount(index).setQuantity(quantity);
        return this;
    }

    public CreateSubscriptionApiRequest discountDiscountId(int index, String discountId) {
        getOrCreateDiscount(index).setDiscountId(discountId);
        return this;
    }

    // ========== INDEXED ACCESSORS FOR ITEM TIERS (e.g.
    // item_tiers[starting_unit][index]) ==========

    private ItemTier getOrCreateItemTier(int index) {
        if (this.itemTiers == null) {
            this.itemTiers = new ArrayList<>();
        }
        while (this.itemTiers.size() <= index) {
            this.itemTiers.add(new ItemTier());
        }
        return this.itemTiers.get(index);
    }

    public CreateSubscriptionApiRequest itemTierItemPriceId(int index, String itemPriceId) {
        getOrCreateItemTier(index).setItemPriceId(itemPriceId);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierStartingUnit(int index, Integer startingUnit) {
        getOrCreateItemTier(index).setStartingUnit(startingUnit);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierEndingUnit(int index, Integer endingUnit) {
        getOrCreateItemTier(index).setEndingUnit(endingUnit);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierPrice(int index, Long price) {
        getOrCreateItemTier(index).setPrice(price);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierStartingUnitInDecimal(int index, String startingUnitInDecimal) {
        getOrCreateItemTier(index).setStartingUnitInDecimal(startingUnitInDecimal);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierEndingUnitInDecimal(int index, String endingUnitInDecimal) {
        getOrCreateItemTier(index).setEndingUnitInDecimal(endingUnitInDecimal);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierPriceInDecimal(int index, String priceInDecimal) {
        getOrCreateItemTier(index).setPriceInDecimal(priceInDecimal);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierPricingType(int index, String pricingType) {
        getOrCreateItemTier(index).setPricingType(pricingType);
        return this;
    }

    public CreateSubscriptionApiRequest itemTierPackageSize(int index, Integer packageSize) {
        getOrCreateItemTier(index).setPackageSize(packageSize);
        return this;
    }

    // ========== TOP-LEVEL GETTERS AND SETTERS ==========

    public String getId() {
        return id;
    }

    public CreateSubscriptionApiRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getBusinessEntityId() {
        return businessEntityId;
    }

    public CreateSubscriptionApiRequest setBusinessEntityId(String businessEntityId) {
        this.businessEntityId = businessEntityId;
        return this;
    }

    public Long getTrialEnd() {
        return trialEnd;
    }

    public CreateSubscriptionApiRequest setTrialEnd(Long trialEnd) {
        this.trialEnd = trialEnd;
        return this;
    }

    public Integer getBillingCycles() {
        return billingCycles;
    }

    public CreateSubscriptionApiRequest setBillingCycles(Integer billingCycles) {
        this.billingCycles = billingCycles;
        return this;
    }

    public String getMandatoryItemsToRemove() {
        return mandatoryItemsToRemove;
    }

    public CreateSubscriptionApiRequest setMandatoryItemsToRemove(String mandatoryItemsToRemove) {
        this.mandatoryItemsToRemove = mandatoryItemsToRemove;
        return this;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public CreateSubscriptionApiRequest setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
        return this;
    }

    public Long getStartDate() {
        return startDate;
    }

    public CreateSubscriptionApiRequest setStartDate(Long startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public CreateSubscriptionApiRequest setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
        return this;
    }

    public Integer getTermsToCharge() {
        return termsToCharge;
    }

    public CreateSubscriptionApiRequest setTermsToCharge(Integer termsToCharge) {
        this.termsToCharge = termsToCharge;
        return this;
    }

    public String getBillingAlignmentMode() {
        return billingAlignmentMode;
    }

    public CreateSubscriptionApiRequest setBillingAlignmentMode(String billingAlignmentMode) {
        this.billingAlignmentMode = billingAlignmentMode;
        return this;
    }

    public String getOfflinePaymentMethod() {
        return offlinePaymentMethod;
    }

    public CreateSubscriptionApiRequest setOfflinePaymentMethod(String offlinePaymentMethod) {
        this.offlinePaymentMethod = offlinePaymentMethod;
        return this;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public CreateSubscriptionApiRequest setPoNumber(String poNumber) {
        this.poNumber = poNumber;
        return this;
    }

    public String getCouponIds() {
        return couponIds;
    }

    public CreateSubscriptionApiRequest setCouponIds(String couponIds) {
        this.couponIds = couponIds;
        return this;
    }

    public String getPaymentSourceId() {
        return paymentSourceId;
    }

    public CreateSubscriptionApiRequest setPaymentSourceId(String paymentSourceId) {
        this.paymentSourceId = paymentSourceId;
        return this;
    }

    public Boolean getOverrideRelationship() {
        return overrideRelationship;
    }

    public CreateSubscriptionApiRequest setOverrideRelationship(Boolean overrideRelationship) {
        this.overrideRelationship = overrideRelationship;
        return this;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public CreateSubscriptionApiRequest setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
        return this;
    }

    public Long getInvoiceDate() {
        return invoiceDate;
    }

    public CreateSubscriptionApiRequest setInvoiceDate(Long invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public Object getMetaData() {
        return metaData;
    }

    public CreateSubscriptionApiRequest setMetaData(Object metaData) {
        this.metaData = metaData;
        return this;
    }

    public Boolean getInvoiceImmediately() {
        return invoiceImmediately;
    }

    public CreateSubscriptionApiRequest setInvoiceImmediately(Boolean invoiceImmediately) {
        this.invoiceImmediately = invoiceImmediately;
        return this;
    }

    public Boolean getReplacePrimaryPaymentSource() {
        return replacePrimaryPaymentSource;
    }

    public CreateSubscriptionApiRequest setReplacePrimaryPaymentSource(Boolean replacePrimaryPaymentSource) {
        this.replacePrimaryPaymentSource = replacePrimaryPaymentSource;
        return this;
    }

    public Integer getFreePeriod() {
        return freePeriod;
    }

    public CreateSubscriptionApiRequest setFreePeriod(Integer freePeriod) {
        this.freePeriod = freePeriod;
        return this;
    }

    public String getFreePeriodUnit() {
        return freePeriodUnit;
    }

    public CreateSubscriptionApiRequest setFreePeriodUnit(String freePeriodUnit) {
        this.freePeriodUnit = freePeriodUnit;
        return this;
    }

    public Integer getContractTermBillingCycleOnRenewal() {
        return contractTermBillingCycleOnRenewal;
    }

    public CreateSubscriptionApiRequest setContractTermBillingCycleOnRenewal(
            Integer contractTermBillingCycleOnRenewal) {
        this.contractTermBillingCycleOnRenewal = contractTermBillingCycleOnRenewal;
        return this;
    }

    public Boolean getCreatePendingInvoices() {
        return createPendingInvoices;
    }

    public CreateSubscriptionApiRequest setCreatePendingInvoices(Boolean createPendingInvoices) {
        this.createPendingInvoices = createPendingInvoices;
        return this;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public CreateSubscriptionApiRequest setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
        return this;
    }

    public Boolean getFirstInvoicePending() {
        return firstInvoicePending;
    }

    public CreateSubscriptionApiRequest setFirstInvoicePending(Boolean firstInvoicePending) {
        this.firstInvoicePending = firstInvoicePending;
        return this;
    }

    public String getTrialEndAction() {
        return trialEndAction;
    }

    public CreateSubscriptionApiRequest setTrialEndAction(String trialEndAction) {
        this.trialEndAction = trialEndAction;
        return this;
    }

    public String getPaymentInitiator() {
        return paymentInitiator;
    }

    public CreateSubscriptionApiRequest setPaymentInitiator(String paymentInitiator) {
        this.paymentInitiator = paymentInitiator;
        return this;
    }

    // ========== SUBSECTION GETTERS AND SETTERS ==========

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public CreateSubscriptionApiRequest setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public StatementDescriptor getStatementDescriptor() {
        return statementDescriptor;
    }

    public CreateSubscriptionApiRequest setStatementDescriptor(StatementDescriptor statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public CreateSubscriptionApiRequest setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
        return this;
    }

    public ContractTerm getContractTerm() {
        return contractTerm;
    }

    public CreateSubscriptionApiRequest setContractTerm(ContractTerm contractTerm) {
        this.contractTerm = contractTerm;
        return this;
    }

    public BillingOverride getBillingOverride() {
        return billingOverride;
    }

    public CreateSubscriptionApiRequest setBillingOverride(BillingOverride billingOverride) {
        this.billingOverride = billingOverride;
        return this;
    }

    public List<SubscriptionItem> getSubscriptionItems() {
        return subscriptionItems;
    }

    public CreateSubscriptionApiRequest setSubscriptionItems(List<SubscriptionItem> subscriptionItems) {
        this.subscriptionItems = subscriptionItems;
        return this;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public CreateSubscriptionApiRequest setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
        return this;
    }

    public List<ItemTier> getItemTiers() {
        return itemTiers;
    }

    public CreateSubscriptionApiRequest setItemTiers(List<ItemTier> itemTiers) {
        this.itemTiers = itemTiers;
        return this;
    }

    // ========== FORM URL ENCODING CONVERTER ==========

    public String toFormUrlEncoded() {
        StringBuilder formParams = new StringBuilder();

        addFormField(formParams, "id", id);
        addFormField(formParams, "business_entity_id", businessEntityId);
        addFormField(formParams, "trial_end", trialEnd);
        addFormField(formParams, "billing_cycles", billingCycles);
        addFormField(formParams, "mandatory_items_to_remove", mandatoryItemsToRemove);
        addFormField(formParams, "net_term_days", netTermDays);
        addFormField(formParams, "start_date", startDate);
        addFormField(formParams, "auto_collection", autoCollection);
        addFormField(formParams, "terms_to_charge", termsToCharge);
        addFormField(formParams, "billing_alignment_mode", billingAlignmentMode);
        addFormField(formParams, "offline_payment_method", offlinePaymentMethod);
        addFormField(formParams, "po_number", poNumber);
        addFormField(formParams, "coupon_ids", couponIds);
        addFormField(formParams, "payment_source_id", paymentSourceId);
        addFormField(formParams, "override_relationship", overrideRelationship);
        addFormField(formParams, "invoice_notes", invoiceNotes);
        addFormField(formParams, "invoice_date", invoiceDate);
        addFormField(formParams, "meta_data", metaData);
        addFormField(formParams, "invoice_immediately", invoiceImmediately);
        addFormField(formParams, "replace_primary_payment_source", replacePrimaryPaymentSource);
        addFormField(formParams, "free_period", freePeriod);
        addFormField(formParams, "free_period_unit", freePeriodUnit);
        addFormField(formParams, "contract_term_billing_cycle_on_renewal", contractTermBillingCycleOnRenewal);
        addFormField(formParams, "create_pending_invoices", createPendingInvoices);
        addFormField(formParams, "auto_close_invoices", autoCloseInvoices);
        addFormField(formParams, "first_invoice_pending", firstInvoicePending);
        addFormField(formParams, "trial_end_action", trialEndAction);
        addFormField(formParams, "payment_initiator", paymentInitiator);

        if (subscriptionItems != null) {
            for (int i = 0; i < subscriptionItems.size(); i++) {
                SubscriptionItem item = subscriptionItems.get(i);
                addIndexedFormField(formParams, "subscription_items[item_price_id]", i, item.getItemPriceId());
                addIndexedFormField(formParams, "subscription_items[quantity]", i, item.getQuantity());
                addIndexedFormField(formParams, "subscription_items[quantity_in_decimal]", i,
                        item.getQuantityInDecimal());
                addIndexedFormField(formParams, "subscription_items[unit_price]", i, item.getUnitPrice());
                addIndexedFormField(formParams, "subscription_items[unit_price_in_decimal]", i,
                        item.getUnitPriceInDecimal());
                addIndexedFormField(formParams, "subscription_items[billing_cycles]", i, item.getBillingCycles());
                addIndexedFormField(formParams, "subscription_items[trial_end]", i, item.getTrialEnd());
                addIndexedFormField(formParams, "subscription_items[service_period_days]", i,
                        item.getServicePeriodDays());
                addIndexedFormField(formParams, "subscription_items[charge_on_event]", i, item.getChargeOnEvent());
                addIndexedFormField(formParams, "subscription_items[charge_once]", i, item.getChargeOnce());
                addIndexedFormField(formParams, "subscription_items[description]", i, item.getDescription());
                addIndexedFormField(formParams, "subscription_items[charge_on_option]", i, item.getChargeOnOption());
                addIndexedFormField(formParams, "subscription_items[usage_accumulation_reset_frequency]", i,
                        item.getUsageAccumulationResetFrequency());
            }
        }

        if (discounts != null) {
            for (int i = 0; i < discounts.size(); i++) {
                Discount discount = discounts.get(i);
                addIndexedFormField(formParams, "discounts[apply_on]", i, discount.getApplyOn());
                addIndexedFormField(formParams, "discounts[duration_type]", i, discount.getDurationType());
                addIndexedFormField(formParams, "discounts[percentage]", i, discount.getPercentage());
                addIndexedFormField(formParams, "discounts[amount]", i, discount.getAmount());
                addIndexedFormField(formParams, "discounts[period]", i, discount.getPeriod());
                addIndexedFormField(formParams, "discounts[period_unit]", i, discount.getPeriodUnit());
                addIndexedFormField(formParams, "discounts[included_in_mrr]", i, discount.getIncludedInMrr());
                addIndexedFormField(formParams, "discounts[item_price_id]", i, discount.getItemPriceId());
                addIndexedFormField(formParams, "discounts[quantity]", i, discount.getQuantity());
                addIndexedFormField(formParams, "discounts[discount_id]", i, discount.getDiscountId());
            }
        }

        if (itemTiers != null) {
            for (int i = 0; i < itemTiers.size(); i++) {
                ItemTier tier = itemTiers.get(i);
                addIndexedFormField(formParams, "item_tiers[item_price_id]", i, tier.getItemPriceId());
                addIndexedFormField(formParams, "item_tiers[starting_unit]", i, tier.getStartingUnit());
                addIndexedFormField(formParams, "item_tiers[ending_unit]", i, tier.getEndingUnit());
                addIndexedFormField(formParams, "item_tiers[price]", i, tier.getPrice());
                addIndexedFormField(formParams, "item_tiers[starting_unit_in_decimal]", i,
                        tier.getStartingUnitInDecimal());
                addIndexedFormField(formParams, "item_tiers[ending_unit_in_decimal]", i, tier.getEndingUnitInDecimal());
                addIndexedFormField(formParams, "item_tiers[price_in_decimal]", i, tier.getPriceInDecimal());
                addIndexedFormField(formParams, "item_tiers[pricing_type]", i, tier.getPricingType());
                addIndexedFormField(formParams, "item_tiers[package_size]", i, tier.getPackageSize());
            }
        }

        if (shippingAddress != null) {
            addFormField(formParams, "shipping_address[first_name]", shippingAddress.getFirstName());
            addFormField(formParams, "shipping_address[last_name]", shippingAddress.getLastName());
            addFormField(formParams, "shipping_address[email]", shippingAddress.getEmail());
            addFormField(formParams, "shipping_address[company]", shippingAddress.getCompany());
            addFormField(formParams, "shipping_address[phone]", shippingAddress.getPhone());
            addFormField(formParams, "shipping_address[line1]", shippingAddress.getLine1());
            addFormField(formParams, "shipping_address[line2]", shippingAddress.getLine2());
            addFormField(formParams, "shipping_address[line3]", shippingAddress.getLine3());
            addFormField(formParams, "shipping_address[city]", shippingAddress.getCity());
            addFormField(formParams, "shipping_address[state_code]", shippingAddress.getStateCode());
            addFormField(formParams, "shipping_address[state]", shippingAddress.getState());
            addFormField(formParams, "shipping_address[zip]", shippingAddress.getZip());
            addFormField(formParams, "shipping_address[country]", shippingAddress.getCountry());
            addFormField(formParams, "shipping_address[validation_status]", shippingAddress.getValidationStatus());
        }

        if (statementDescriptor != null) {
            addFormField(formParams, "statement_descriptor[descriptor]", statementDescriptor.getDescriptor());
        }

        if (paymentIntent != null) {
            addFormField(formParams, "payment_intent[id]", paymentIntent.getId());
            addFormField(formParams, "payment_intent[gateway_account_id]", paymentIntent.getGatewayAccountId());
            addFormField(formParams, "payment_intent[gw_token]", paymentIntent.getGwToken());
            addFormField(formParams, "payment_intent[payment_method_type]", paymentIntent.getPaymentMethodType());
            addFormField(formParams, "payment_intent[reference_id]", paymentIntent.getReferenceId());
            addFormField(formParams, "payment_intent[additional_information]",
                    paymentIntent.getAdditionalInformation());
        }

        if (contractTerm != null) {
            addFormField(formParams, "contract_term[action_at_term_end]", contractTerm.getActionAtTermEnd());
            addFormField(formParams, "contract_term[cancellation_cutoff_period]",
                    contractTerm.getCancellationCutoffPeriod());
        }

        if (billingOverride != null) {
            addFormField(formParams, "billing_override[max_excess_payment_usage]",
                    billingOverride.getMaxExcessPaymentUsage());
            addFormField(formParams, "billing_override[max_refundable_credits_usage]",
                    billingOverride.getMaxRefundableCreditsUsage());
        }

        return formParams.toString();
    }

    private void addFormField(StringBuilder formParams, String fieldName, Object value) {
        if (value != null) {
            if (formParams.length() > 0) {
                formParams.append("&");
            }
            formParams.append(fieldName).append("=").append(value);
        }
    }

    private void addIndexedFormField(StringBuilder formParams, String fieldName, int index, Object value) {
        if (value != null) {
            if (formParams.length() > 0) {
                formParams.append("&");
            }
            formParams.append(fieldName).append("[").append(index).append("]=").append(value);
        }
    }

    // =========================================================================
    // INNER CLASSES FOR SUBSECTIONS
    // =========================================================================

    /**
     * Inner class representing Subscription Item parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SubscriptionItem {

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

        public SubscriptionItem(String itemPriceId, Integer quantity) {
            this.itemPriceId = itemPriceId;
            this.quantity = quantity;
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

    /**
     * Inner class representing Discount parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Discount {

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

        public Discount(String discountId, Integer quantity) {
            this.discountId = discountId;
            this.quantity = quantity;
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

    /**
     * Inner class representing Item Tier parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ItemTier {

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

        public ItemTier(Integer startingUnit, Integer endingUnit, Long price) {
            this.startingUnit = startingUnit;
            this.endingUnit = endingUnit;
            this.price = price;
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

    /**
     * Inner class representing Shipping Address parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ShippingAddress {

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("company")
        private String company;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("line1")
        private String line1;

        @JsonProperty("line2")
        private String line2;

        @JsonProperty("line3")
        private String line3;

        @JsonProperty("city")
        private String city;

        @JsonProperty("state_code")
        private String stateCode;

        @JsonProperty("state")
        private String state;

        @JsonProperty("zip")
        private String zip;

        @JsonProperty("country")
        private String country;

        @JsonProperty("validation_status")
        private String validationStatus;

        public String getFirstName() {
            return firstName;
        }

        public ShippingAddress setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public ShippingAddress setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public ShippingAddress setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getCompany() {
            return company;
        }

        public ShippingAddress setCompany(String company) {
            this.company = company;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public ShippingAddress setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getLine1() {
            return line1;
        }

        public ShippingAddress setLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public String getLine2() {
            return line2;
        }

        public ShippingAddress setLine2(String line2) {
            this.line2 = line2;
            return this;
        }

        public String getLine3() {
            return line3;
        }

        public ShippingAddress setLine3(String line3) {
            this.line3 = line3;
            return this;
        }

        public String getCity() {
            return city;
        }

        public ShippingAddress setCity(String city) {
            this.city = city;
            return this;
        }

        public String getStateCode() {
            return stateCode;
        }

        public ShippingAddress setStateCode(String stateCode) {
            this.stateCode = stateCode;
            return this;
        }

        public String getState() {
            return state;
        }

        public ShippingAddress setState(String state) {
            this.state = state;
            return this;
        }

        public String getZip() {
            return zip;
        }

        public ShippingAddress setZip(String zip) {
            this.zip = zip;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public ShippingAddress setCountry(String country) {
            this.country = country;
            return this;
        }

        public String getValidationStatus() {
            return validationStatus;
        }

        public ShippingAddress setValidationStatus(String validationStatus) {
            this.validationStatus = validationStatus;
            return this;
        }
    }

    /**
     * Inner class representing Statement Descriptor parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class StatementDescriptor {

        @JsonProperty("descriptor")
        private String descriptor;

        public String getDescriptor() {
            return descriptor;
        }

        public StatementDescriptor setDescriptor(String descriptor) {
            this.descriptor = descriptor;
            return this;
        }
    }

    /**
     * Inner class representing Payment Intent parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PaymentIntent {

        @JsonProperty("id")
        private String id;

        @JsonProperty("gateway_account_id")
        private String gatewayAccountId;

        @JsonProperty("gw_token")
        private String gwToken;

        @JsonProperty("payment_method_type")
        private String paymentMethodType;

        @JsonProperty("reference_id")
        private String referenceId;

        @JsonProperty("additional_information")
        private Object additionalInformation;

        public String getId() {
            return id;
        }

        public PaymentIntent setId(String id) {
            this.id = id;
            return this;
        }

        public String getGatewayAccountId() {
            return gatewayAccountId;
        }

        public PaymentIntent setGatewayAccountId(String gatewayAccountId) {
            this.gatewayAccountId = gatewayAccountId;
            return this;
        }

        public String getGwToken() {
            return gwToken;
        }

        public PaymentIntent setGwToken(String gwToken) {
            this.gwToken = gwToken;
            return this;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public PaymentIntent setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
            return this;
        }

        public String getReferenceId() {
            return referenceId;
        }

        public PaymentIntent setReferenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Object getAdditionalInformation() {
            return additionalInformation;
        }

        public PaymentIntent setAdditionalInformation(Object additionalInformation) {
            this.additionalInformation = additionalInformation;
            return this;
        }
    }

    /**
     * Inner class representing Contract Term parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ContractTerm {

        @JsonProperty("action_at_term_end")
        private String actionAtTermEnd;

        @JsonProperty("cancellation_cutoff_period")
        private Integer cancellationCutoffPeriod;

        public String getActionAtTermEnd() {
            return actionAtTermEnd;
        }

        public ContractTerm setActionAtTermEnd(String actionAtTermEnd) {
            this.actionAtTermEnd = actionAtTermEnd;
            return this;
        }

        public Integer getCancellationCutoffPeriod() {
            return cancellationCutoffPeriod;
        }

        public ContractTerm setCancellationCutoffPeriod(Integer cancellationCutoffPeriod) {
            this.cancellationCutoffPeriod = cancellationCutoffPeriod;
            return this;
        }
    }

    /**
     * Inner class representing Billing Override parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BillingOverride {

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
}

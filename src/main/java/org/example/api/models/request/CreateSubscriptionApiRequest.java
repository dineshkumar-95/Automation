package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.common.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Subscription API Request.
 * Supports top-level fields, nested request objects, and list-based
 * subscription items, discounts, and item tiers.
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

    // ========== OBJECT-BASED HELPER METHODS FOR LISTS ==========

    public CreateSubscriptionApiRequest addSubscriptionItem(SubscriptionItem item) {
        if (this.subscriptionItems == null) {
            this.subscriptionItems = new ArrayList<>();
        }
        this.subscriptionItems.add(item);
        return this;
    }

    public CreateSubscriptionApiRequest addDiscount(Discount discount) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.add(discount);
        return this;
    }

    public CreateSubscriptionApiRequest addItemTier(ItemTier itemTier) {
        if (this.itemTiers == null) {
            this.itemTiers = new ArrayList<>();
        }
        this.itemTiers.add(itemTier);
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
            addFormField(formParams, "billing_override[max_excess_payment_usage]", billingOverride.getMaxExcessPaymentUsage());
            addFormField(formParams, "billing_override[max_refundable_credits_usage]", billingOverride.getMaxRefundableCreditsUsage());
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

}

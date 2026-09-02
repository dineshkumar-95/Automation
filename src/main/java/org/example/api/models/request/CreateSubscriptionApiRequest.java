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

}

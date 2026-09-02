package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.common.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Customer API Request.
 * Supports all parameters from Chargebee API documentation with inner classes for nested subsections.
 * Includes fluent setters and backward-compatible delegation methods.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCustomerApiRequest {

    // ========== TOP-LEVEL CUSTOMER FIELDS ==========
    
    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("preferred_currency_code")
    private String preferredCurrencyCode;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("company")
    private String company;

    @JsonProperty("auto_collection")
    private String autoCollection;

    @JsonProperty("net_term_days")
    private Integer netTermDays;

    @JsonProperty("allow_direct_debit")
    private Boolean allowDirectDebit;

    @JsonProperty("vat_number")
    private String vatNumber;

    @JsonProperty("vat_number_prefix")
    private String vatNumberPrefix;

    @JsonProperty("entity_identifier_scheme")
    private String entityIdentifierScheme;

    @JsonProperty("entity_identifier_standard")
    private String entityIdentifierStandard;

    @JsonProperty("registered_for_gst")
    private Boolean registeredForGst;

    @JsonProperty("is_einvoice_enabled")
    private Boolean isEinvoiceEnabled;

    @JsonProperty("einvoicing_method")
    private String einvoicingMethod;

    @JsonProperty("taxability")
    private String taxability;

    @JsonProperty("exemption_details")
    private String exemptionDetails;

    @JsonProperty("customer_type")
    private String customerType;

    @JsonProperty("client_profile_id")
    private String clientProfileId;

    @JsonProperty("taxjar_exemption_category")
    private String taxjarExemptionCategory;

    @JsonProperty("business_customer_without_vat_number")
    private Boolean businessCustomerWithoutVatNumber;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("entity_code")
    private String entityCode;

    @JsonProperty("exempt_number")
    private String exemptNumber;

    @JsonProperty("meta_data")
    private Object metaData;

    @JsonProperty("offline_payment_method")
    private String offlinePaymentMethod;

    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;

    @JsonProperty("consolidated_invoicing")
    private Boolean consolidatedInvoicing;

    @JsonProperty("token_id")
    private String tokenId;

    @JsonProperty("business_entity_id")
    private String businessEntityId;

    @JsonProperty("invoice_notes")
    private String invoiceNotes;

    // ========== SUBSECTIONS (NESTED OBJECTS) ==========

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

    @JsonProperty("card")
    private Card card;

    @JsonProperty("bank_account")
    private BankAccount bankAccount;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    @JsonProperty("payment_intent")
    private PaymentIntent paymentIntent;

    @JsonProperty("entity_identifiers")
    private List<EntityIdentifier> entityIdentifiers;

    @JsonProperty("tax_providers_fields")
    private List<TaxProvidersField> taxProvidersFields;

    // ========== TOP-LEVEL GETTERS AND SETTERS ==========

    public String getId() {
        return id;
    }

    public CreateCustomerApiRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateCustomerApiRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateCustomerApiRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateCustomerApiRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    public CreateCustomerApiRequest setPreferredCurrencyCode(String preferredCurrencyCode) {
        this.preferredCurrencyCode = preferredCurrencyCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateCustomerApiRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CreateCustomerApiRequest setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public CreateCustomerApiRequest setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
        return this;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public CreateCustomerApiRequest setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
        return this;
    }

    public Boolean getAllowDirectDebit() {
        return allowDirectDebit;
    }

    public CreateCustomerApiRequest setAllowDirectDebit(Boolean allowDirectDebit) {
        this.allowDirectDebit = allowDirectDebit;
        return this;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public CreateCustomerApiRequest setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    public String getVatNumberPrefix() {
        return vatNumberPrefix;
    }

    public CreateCustomerApiRequest setVatNumberPrefix(String vatNumberPrefix) {
        this.vatNumberPrefix = vatNumberPrefix;
        return this;
    }

    public String getEntityIdentifierScheme() {
        return entityIdentifierScheme;
    }

    public CreateCustomerApiRequest setEntityIdentifierScheme(String entityIdentifierScheme) {
        this.entityIdentifierScheme = entityIdentifierScheme;
        return this;
    }

    public String getEntityIdentifierStandard() {
        return entityIdentifierStandard;
    }

    public CreateCustomerApiRequest setEntityIdentifierStandard(String entityIdentifierStandard) {
        this.entityIdentifierStandard = entityIdentifierStandard;
        return this;
    }

    public Boolean getRegisteredForGst() {
        return registeredForGst;
    }

    public CreateCustomerApiRequest setRegisteredForGst(Boolean registeredForGst) {
        this.registeredForGst = registeredForGst;
        return this;
    }

    public Boolean getIsEinvoiceEnabled() {
        return isEinvoiceEnabled;
    }

    public CreateCustomerApiRequest setIsEinvoiceEnabled(Boolean isEinvoiceEnabled) {
        this.isEinvoiceEnabled = isEinvoiceEnabled;
        return this;
    }

    public String getEinvoicingMethod() {
        return einvoicingMethod;
    }

    public CreateCustomerApiRequest setEinvoicingMethod(String einvoicingMethod) {
        this.einvoicingMethod = einvoicingMethod;
        return this;
    }

    public String getTaxability() {
        return taxability;
    }

    public CreateCustomerApiRequest setTaxability(String taxability) {
        this.taxability = taxability;
        return this;
    }

    public String getExemptionDetails() {
        return exemptionDetails;
    }

    public CreateCustomerApiRequest setExemptionDetails(String exemptionDetails) {
        this.exemptionDetails = exemptionDetails;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public CreateCustomerApiRequest setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getClientProfileId() {
        return clientProfileId;
    }

    public CreateCustomerApiRequest setClientProfileId(String clientProfileId) {
        this.clientProfileId = clientProfileId;
        return this;
    }

    public String getTaxjarExemptionCategory() {
        return taxjarExemptionCategory;
    }

    public CreateCustomerApiRequest setTaxjarExemptionCategory(String taxjarExemptionCategory) {
        this.taxjarExemptionCategory = taxjarExemptionCategory;
        return this;
    }

    public Boolean getBusinessCustomerWithoutVatNumber() {
        return businessCustomerWithoutVatNumber;
    }

    public CreateCustomerApiRequest setBusinessCustomerWithoutVatNumber(Boolean businessCustomerWithoutVatNumber) {
        this.businessCustomerWithoutVatNumber = businessCustomerWithoutVatNumber;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public CreateCustomerApiRequest setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public CreateCustomerApiRequest setEntityCode(String entityCode) {
        this.entityCode = entityCode;
        return this;
    }

    public String getExemptNumber() {
        return exemptNumber;
    }

    public CreateCustomerApiRequest setExemptNumber(String exemptNumber) {
        this.exemptNumber = exemptNumber;
        return this;
    }

    public Object getMetaData() {
        return metaData;
    }

    public CreateCustomerApiRequest setMetaData(Object metaData) {
        this.metaData = metaData;
        return this;
    }

    public String getOfflinePaymentMethod() {
        return offlinePaymentMethod;
    }

    public CreateCustomerApiRequest setOfflinePaymentMethod(String offlinePaymentMethod) {
        this.offlinePaymentMethod = offlinePaymentMethod;
        return this;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public CreateCustomerApiRequest setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
        return this;
    }

    public Boolean getConsolidatedInvoicing() {
        return consolidatedInvoicing;
    }

    public CreateCustomerApiRequest setConsolidatedInvoicing(Boolean consolidatedInvoicing) {
        this.consolidatedInvoicing = consolidatedInvoicing;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public CreateCustomerApiRequest setTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getBusinessEntityId() {
        return businessEntityId;
    }

    public CreateCustomerApiRequest setBusinessEntityId(String businessEntityId) {
        this.businessEntityId = businessEntityId;
        return this;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public CreateCustomerApiRequest setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
        return this;
    }

    // ========== SUBSECTION GETTERS AND SETTERS ==========

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public CreateCustomerApiRequest setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public CreateCustomerApiRequest setCard(Card card) {
        this.card = card;
        return this;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public CreateCustomerApiRequest setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public CreateCustomerApiRequest setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public CreateCustomerApiRequest setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
        return this;
    }

    public List<EntityIdentifier> getEntityIdentifiers() {
        return entityIdentifiers;
    }

    public CreateCustomerApiRequest setEntityIdentifiers(List<EntityIdentifier> entityIdentifiers) {
        this.entityIdentifiers = entityIdentifiers;
        return this;
    }

    public CreateCustomerApiRequest addEntityIdentifier(EntityIdentifier entityIdentifier) {
        if (this.entityIdentifiers == null) {
            this.entityIdentifiers = new ArrayList<>();
        }
        this.entityIdentifiers.add(entityIdentifier);
        return this;
    }

    public List<TaxProvidersField> getTaxProvidersFields() {
        return taxProvidersFields;
    }

    public CreateCustomerApiRequest setTaxProvidersFields(List<TaxProvidersField> taxProvidersFields) {
        this.taxProvidersFields = taxProvidersFields;
        return this;
    }

    public CreateCustomerApiRequest addTaxProvidersField(TaxProvidersField taxProvidersField) {
        if (this.taxProvidersFields == null) {
            this.taxProvidersFields = new ArrayList<>();
        }
        this.taxProvidersFields.add(taxProvidersField);
        return this;
    }

}

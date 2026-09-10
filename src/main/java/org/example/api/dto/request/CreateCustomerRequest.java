package org.example.api.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.dto.request.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Customer API Request.
 * Supports all parameters from Chargebee API documentation with inner classes for nested subsections.
 * Includes fluent setters and backward-compatible delegation methods.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCustomerRequest {

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
    private CardRequest card;

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

    public CreateCustomerRequest setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateCustomerRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateCustomerRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateCustomerRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    public CreateCustomerRequest setPreferredCurrencyCode(String preferredCurrencyCode) {
        this.preferredCurrencyCode = preferredCurrencyCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateCustomerRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CreateCustomerRequest setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public CreateCustomerRequest setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
        return this;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public CreateCustomerRequest setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
        return this;
    }

    public Boolean getAllowDirectDebit() {
        return allowDirectDebit;
    }

    public CreateCustomerRequest setAllowDirectDebit(Boolean allowDirectDebit) {
        this.allowDirectDebit = allowDirectDebit;
        return this;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public CreateCustomerRequest setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    public String getVatNumberPrefix() {
        return vatNumberPrefix;
    }

    public CreateCustomerRequest setVatNumberPrefix(String vatNumberPrefix) {
        this.vatNumberPrefix = vatNumberPrefix;
        return this;
    }

    public String getEntityIdentifierScheme() {
        return entityIdentifierScheme;
    }

    public CreateCustomerRequest setEntityIdentifierScheme(String entityIdentifierScheme) {
        this.entityIdentifierScheme = entityIdentifierScheme;
        return this;
    }

    public String getEntityIdentifierStandard() {
        return entityIdentifierStandard;
    }

    public CreateCustomerRequest setEntityIdentifierStandard(String entityIdentifierStandard) {
        this.entityIdentifierStandard = entityIdentifierStandard;
        return this;
    }

    public Boolean getRegisteredForGst() {
        return registeredForGst;
    }

    public CreateCustomerRequest setRegisteredForGst(Boolean registeredForGst) {
        this.registeredForGst = registeredForGst;
        return this;
    }

    public Boolean getIsEinvoiceEnabled() {
        return isEinvoiceEnabled;
    }

    public CreateCustomerRequest setIsEinvoiceEnabled(Boolean isEinvoiceEnabled) {
        this.isEinvoiceEnabled = isEinvoiceEnabled;
        return this;
    }

    public String getEinvoicingMethod() {
        return einvoicingMethod;
    }

    public CreateCustomerRequest setEinvoicingMethod(String einvoicingMethod) {
        this.einvoicingMethod = einvoicingMethod;
        return this;
    }

    public String getTaxability() {
        return taxability;
    }

    public CreateCustomerRequest setTaxability(String taxability) {
        this.taxability = taxability;
        return this;
    }

    public String getExemptionDetails() {
        return exemptionDetails;
    }

    public CreateCustomerRequest setExemptionDetails(String exemptionDetails) {
        this.exemptionDetails = exemptionDetails;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public CreateCustomerRequest setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getClientProfileId() {
        return clientProfileId;
    }

    public CreateCustomerRequest setClientProfileId(String clientProfileId) {
        this.clientProfileId = clientProfileId;
        return this;
    }

    public String getTaxjarExemptionCategory() {
        return taxjarExemptionCategory;
    }

    public CreateCustomerRequest setTaxjarExemptionCategory(String taxjarExemptionCategory) {
        this.taxjarExemptionCategory = taxjarExemptionCategory;
        return this;
    }

    public Boolean getBusinessCustomerWithoutVatNumber() {
        return businessCustomerWithoutVatNumber;
    }

    public CreateCustomerRequest setBusinessCustomerWithoutVatNumber(Boolean businessCustomerWithoutVatNumber) {
        this.businessCustomerWithoutVatNumber = businessCustomerWithoutVatNumber;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public CreateCustomerRequest setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public CreateCustomerRequest setEntityCode(String entityCode) {
        this.entityCode = entityCode;
        return this;
    }

    public String getExemptNumber() {
        return exemptNumber;
    }

    public CreateCustomerRequest setExemptNumber(String exemptNumber) {
        this.exemptNumber = exemptNumber;
        return this;
    }

    public Object getMetaData() {
        return metaData;
    }

    public CreateCustomerRequest setMetaData(Object metaData) {
        this.metaData = metaData;
        return this;
    }

    public String getOfflinePaymentMethod() {
        return offlinePaymentMethod;
    }

    public CreateCustomerRequest setOfflinePaymentMethod(String offlinePaymentMethod) {
        this.offlinePaymentMethod = offlinePaymentMethod;
        return this;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public CreateCustomerRequest setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
        return this;
    }

    public Boolean getConsolidatedInvoicing() {
        return consolidatedInvoicing;
    }

    public CreateCustomerRequest setConsolidatedInvoicing(Boolean consolidatedInvoicing) {
        this.consolidatedInvoicing = consolidatedInvoicing;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public CreateCustomerRequest setTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getBusinessEntityId() {
        return businessEntityId;
    }

    public CreateCustomerRequest setBusinessEntityId(String businessEntityId) {
        this.businessEntityId = businessEntityId;
        return this;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public CreateCustomerRequest setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
        return this;
    }

    // ========== SUBSECTION GETTERS AND SETTERS ==========

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public CreateCustomerRequest setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public CardRequest getCard() {
        return card;
    }

    public CreateCustomerRequest setCard(CardRequest card) {
        this.card = card;
        return this;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public CreateCustomerRequest setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public CreateCustomerRequest setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public CreateCustomerRequest setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
        return this;
    }

    public List<EntityIdentifier> getEntityIdentifiers() {
        return entityIdentifiers;
    }

    public CreateCustomerRequest setEntityIdentifiers(List<EntityIdentifier> entityIdentifiers) {
        this.entityIdentifiers = entityIdentifiers;
        return this;
    }

    public CreateCustomerRequest addEntityIdentifier(EntityIdentifier entityIdentifier) {
        if (this.entityIdentifiers == null) {
            this.entityIdentifiers = new ArrayList<>();
        }
        this.entityIdentifiers.add(entityIdentifier);
        return this;
    }

    public List<TaxProvidersField> getTaxProvidersFields() {
        return taxProvidersFields;
    }

    public CreateCustomerRequest setTaxProvidersFields(List<TaxProvidersField> taxProvidersFields) {
        this.taxProvidersFields = taxProvidersFields;
        return this;
    }

    public CreateCustomerRequest addTaxProvidersField(TaxProvidersField taxProvidersField) {
        if (this.taxProvidersFields == null) {
            this.taxProvidersFields = new ArrayList<>();
        }
        this.taxProvidersFields.add(taxProvidersField);
        return this;
    }

}

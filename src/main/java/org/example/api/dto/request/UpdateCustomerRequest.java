package org.example.api.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.dto.request.common.TaxProvidersField;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class for Chargebee Create Customer API Request.
 * Supports all parameters from Chargebee API documentation with inner classes for nested subsections.
 * Includes fluent setters and backward-compatible delegation methods.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateCustomerRequest {

    // ========== TOP-LEVEL CUSTOMER FIELDS ==========

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

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("entity_code")
    private String entityCode;

    @JsonProperty("exempt_number")
    private String exemptNumber;

    @JsonProperty("offline_payment_method")
    private String offlinePaymentMethod;

    @JsonProperty("invoice_notes")
    private String invoiceNotes;

    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;

    @JsonProperty("meta_data")
    private Object metaData;

    @JsonProperty("fraud_flag")
    private Boolean fraudFlag;

    @JsonProperty("consolidated_invoicing")
    private Boolean consolidatedInvoicing;





    // ========== SUBSECTIONS (NESTED OBJECTS) ==========

    @JsonProperty("tax_providers_fields")
    private List<TaxProvidersField> taxProvidersFields;

    // ========== TOP-LEVEL GETTERS AND SETTERS ==========


    public String getFirstName() {
        return firstName;
    }

    public UpdateCustomerRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateCustomerRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateCustomerRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    public UpdateCustomerRequest setPreferredCurrencyCode(String preferredCurrencyCode) {
        this.preferredCurrencyCode = preferredCurrencyCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UpdateCustomerRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public UpdateCustomerRequest setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public UpdateCustomerRequest setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
        return this;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public UpdateCustomerRequest setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
        return this;
    }

    public Boolean getAllowDirectDebit() {
        return allowDirectDebit;
    }

    public UpdateCustomerRequest setAllowDirectDebit(Boolean allowDirectDebit) {
        this.allowDirectDebit = allowDirectDebit;
        return this;
    }

    public String getTaxability() {
        return taxability;
    }

    public UpdateCustomerRequest setTaxability(String taxability) {
        this.taxability = taxability;
        return this;
    }

    public String getExemptionDetails() {
        return exemptionDetails;
    }

    public UpdateCustomerRequest setExemptionDetails(String exemptionDetails) {
        this.exemptionDetails = exemptionDetails;
        return this;
    }

    public String getCustomerType() {
        return customerType;
    }

    public UpdateCustomerRequest setCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    public String getClientProfileId() {
        return clientProfileId;
    }

    public UpdateCustomerRequest setClientProfileId(String clientProfileId) {
        this.clientProfileId = clientProfileId;
        return this;
    }

    public String getTaxjarExemptionCategory() {
        return taxjarExemptionCategory;
    }

    public UpdateCustomerRequest setTaxjarExemptionCategory(String taxjarExemptionCategory) {
        this.taxjarExemptionCategory = taxjarExemptionCategory;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public UpdateCustomerRequest setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public UpdateCustomerRequest setEntityCode(String entityCode) {
        this.entityCode = entityCode;
        return this;
    }

    public String getExemptNumber() {
        return exemptNumber;
    }

    public UpdateCustomerRequest setExemptNumber(String exemptNumber) {
        this.exemptNumber = exemptNumber;
        return this;
    }

    public Object getMetaData() {
        return metaData;
    }

    public UpdateCustomerRequest setMetaData(Object metaData) {
        this.metaData = metaData;
        return this;
    }

    public String getOfflinePaymentMethod() {
        return offlinePaymentMethod;
    }

    public UpdateCustomerRequest setOfflinePaymentMethod(String offlinePaymentMethod) {
        this.offlinePaymentMethod = offlinePaymentMethod;
        return this;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public UpdateCustomerRequest setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
        return this;
    }

    public Boolean getConsolidatedInvoicing() {
        return consolidatedInvoicing;
    }

    public UpdateCustomerRequest setConsolidatedInvoicing(Boolean consolidatedInvoicing) {
        this.consolidatedInvoicing = consolidatedInvoicing;
        return this;
    }

    public Boolean getFraudFlag() {
        return fraudFlag;
    }

    public UpdateCustomerRequest setFraudFlag(Boolean fraudFlag) {
        this.fraudFlag = fraudFlag;
        return this;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public UpdateCustomerRequest setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
        return this;
    }

    // ========== Tax Providers GETTERS AND SETTERS ==========

    public List<TaxProvidersField> getTaxProvidersFields() {
        return taxProvidersFields;
    }

    public UpdateCustomerRequest setTaxProvidersFields(List<TaxProvidersField> taxProvidersFields) {
        this.taxProvidersFields = taxProvidersFields;
        return this;
    }

    public UpdateCustomerRequest addTaxProvidersField(TaxProvidersField taxProvidersField) {
        if (this.taxProvidersFields == null) {
            this.taxProvidersFields = new ArrayList<>();
        }
        this.taxProvidersFields.add(taxProvidersField);
        return this;
    }

}

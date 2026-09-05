package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("company")
    private String company;
    
    @JsonProperty("vat_number")
    private String vatNumber;
    
    @JsonProperty("auto_collection")
    private String autoCollection;
    
    @JsonProperty("offline_payment_method")
    private String offlinePaymentMethod;
    
    @JsonProperty("net_term_days")
    private Integer netTermDays;
    
    @JsonProperty("vat_number_validated_time")
    private Long vatNumberValidatedTime;
    
    @JsonProperty("vat_number_status")
    private String vatNumberStatus;
    
    @JsonProperty("allow_direct_debit")
    private Boolean allowDirectDebit;
    
    @JsonProperty("is_location_valid")
    private Boolean isLocationValid;
    
    @JsonProperty("created_at")
    private Long createdAt;
    
    @JsonProperty("created_from_ip")
    private String createdFromIp;
    
    @JsonProperty("exemption_details")
    private Object exemptionDetails; // Sometimes a list or string depending on API version, object is safest
    
    @JsonProperty("taxability")
    private String taxability;
    
    @JsonProperty("entity_code")
    private String entityCode;
    
    @JsonProperty("exempt_number")
    private String exemptNumber;
    
    @JsonProperty("resource_version")
    private Long resourceVersion;
    
    @JsonProperty("updated_at")
    private Long updatedAt;
    
    @JsonProperty("locale")
    private String locale;
    
    @JsonProperty("consolidated_invoicing")
    private Boolean consolidatedInvoicing;
    
    @JsonProperty("billing_date")
    private Integer billingDate;
    
    @JsonProperty("billing_date_mode")
    private String billingDateMode;
    
    @JsonProperty("billing_day_of_week")
    private String billingDayOfWeek;
    
    @JsonProperty("billing_day_of_week_mode")
    private String billingDayOfWeekMode;
    
    @JsonProperty("pii_cleared")
    private String piiCleared;
    
    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;
    
    @JsonProperty("card_status")
    private String cardStatus;
    
    @JsonProperty("promotional_credits")
    private Integer promotionalCredits;
    
    @JsonProperty("refundable_credits")
    private Integer refundableCredits;
    
    @JsonProperty("excess_payments")
    private Integer excessPayments;
    
    @JsonProperty("unbilled_charges")
    private Integer unbilledCharges;
    
    @JsonProperty("preferred_currency_code")
    private String preferredCurrencyCode;
    
    @JsonProperty("mrr")
    private Integer mrr;
    
    @JsonProperty("primary_payment_source_id")
    private String primaryPaymentSourceId;
    
    @JsonProperty("backup_payment_source_id")
    private String backupPaymentSourceId;
    
    @JsonProperty("channel")
    private String channel;
    
    @JsonProperty("deleted")
    private Boolean deleted;
    
    @JsonProperty("object")
    private String object;
    
    @JsonProperty("business_customer_without_vat_number")
    private Boolean businessCustomerWithoutVatNumber;
    
    @JsonProperty("client_profile_id")
    private String clientProfileId;
    
    @JsonProperty("customer_type")
    private String customerType;
    
    @JsonProperty("taxjar_exemption_category")
    private String taxjarExemptionCategory;
    
    @JsonProperty("registered_for_gst")
    private Boolean registeredForGst;
    
    @JsonProperty("is_einvoice_enabled")
    private Boolean isEinvoiceEnabled;
    
    @JsonProperty("einvoicing_method")
    private String einvoicingMethod;
    
    @JsonProperty("invoice_notes")
    private String invoiceNotes;
    
    // Nested Objects
    @JsonProperty("billing_address")
    private BillingAddress billingAddress;
    
    @JsonProperty("contacts")
    private List<Contact> contacts;
    
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    
    @JsonProperty("balances")
    private List<Balance> balances;
    
    @JsonProperty("entity_identifiers")
    private List<EntityIdentifier> entityIdentifiers;
    
    @JsonProperty("tax_providers_fields")
    private List<TaxProvidersField> taxProvidersFields;
    
    @JsonProperty("relationship")
    private Relationship relationship;
    
    @JsonProperty("parent_account_access")
    private ParentAccountAccess parentAccountAccess;
    
    @JsonProperty("child_account_access")
    private ChildAccountAccess childAccountAccess;
    
    @JsonProperty("meta_data")
    private Object metaData;

    // Getters and Setters

    public String getId() { return id; }
    public Customer setId(String id) { this.id = id; return this; }

    public String getFirstName() { return firstName; }
    public Customer setFirstName(String firstName) { this.firstName = firstName; return this; }

    public String getLastName() { return lastName; }
    public Customer setLastName(String lastName) { this.lastName = lastName; return this; }

    public String getEmail() { return email; }
    public Customer setEmail(String email) { this.email = email; return this; }

    public String getPhone() { return phone; }
    public Customer setPhone(String phone) { this.phone = phone; return this; }

    public String getCompany() { return company; }
    public Customer setCompany(String company) { this.company = company; return this; }

    public String getVatNumber() { return vatNumber; }
    public Customer setVatNumber(String vatNumber) { this.vatNumber = vatNumber; return this; }

    public String getAutoCollection() { return autoCollection; }
    public Customer setAutoCollection(String autoCollection) { this.autoCollection = autoCollection; return this; }

    public String getOfflinePaymentMethod() { return offlinePaymentMethod; }
    public Customer setOfflinePaymentMethod(String offlinePaymentMethod) { this.offlinePaymentMethod = offlinePaymentMethod; return this; }

    public Integer getNetTermDays() { return netTermDays; }
    public Customer setNetTermDays(Integer netTermDays) { this.netTermDays = netTermDays; return this; }

    public Long getVatNumberValidatedTime() { return vatNumberValidatedTime; }
    public Customer setVatNumberValidatedTime(Long vatNumberValidatedTime) { this.vatNumberValidatedTime = vatNumberValidatedTime; return this; }

    public String getVatNumberStatus() { return vatNumberStatus; }
    public Customer setVatNumberStatus(String vatNumberStatus) { this.vatNumberStatus = vatNumberStatus; return this; }

    public Boolean getAllowDirectDebit() { return allowDirectDebit; }
    public Customer setAllowDirectDebit(Boolean allowDirectDebit) { this.allowDirectDebit = allowDirectDebit; return this; }

    public Boolean getIsLocationValid() { return isLocationValid; }
    public Customer setIsLocationValid(Boolean isLocationValid) { this.isLocationValid = isLocationValid; return this; }

    public Long getCreatedAt() { return createdAt; }
    public Customer setCreatedAt(Long createdAt) { this.createdAt = createdAt; return this; }

    public String getCreatedFromIp() { return createdFromIp; }
    public Customer setCreatedFromIp(String createdFromIp) { this.createdFromIp = createdFromIp; return this; }

    public Object getExemptionDetails() { return exemptionDetails; }
    public Customer setExemptionDetails(Object exemptionDetails) { this.exemptionDetails = exemptionDetails; return this; }

    public String getTaxability() { return taxability; }
    public Customer setTaxability(String taxability) { this.taxability = taxability; return this; }

    public String getEntityCode() { return entityCode; }
    public Customer setEntityCode(String entityCode) { this.entityCode = entityCode; return this; }

    public String getExemptNumber() { return exemptNumber; }
    public Customer setExemptNumber(String exemptNumber) { this.exemptNumber = exemptNumber; return this; }

    public Long getResourceVersion() { return resourceVersion; }
    public Customer setResourceVersion(Long resourceVersion) { this.resourceVersion = resourceVersion; return this; }

    public Long getUpdatedAt() { return updatedAt; }
    public Customer setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; return this; }

    public String getLocale() { return locale; }
    public Customer setLocale(String locale) { this.locale = locale; return this; }

    public Boolean getConsolidatedInvoicing() { return consolidatedInvoicing; }
    public Customer setConsolidatedInvoicing(Boolean consolidatedInvoicing) { this.consolidatedInvoicing = consolidatedInvoicing; return this; }

    public Integer getBillingDate() { return billingDate; }
    public Customer setBillingDate(Integer billingDate) { this.billingDate = billingDate; return this; }

    public String getBillingDateMode() { return billingDateMode; }
    public Customer setBillingDateMode(String billingDateMode) { this.billingDateMode = billingDateMode; return this; }

    public String getBillingDayOfWeek() { return billingDayOfWeek; }
    public Customer setBillingDayOfWeek(String billingDayOfWeek) { this.billingDayOfWeek = billingDayOfWeek; return this; }

    public String getBillingDayOfWeekMode() { return billingDayOfWeekMode; }
    public Customer setBillingDayOfWeekMode(String billingDayOfWeekMode) { this.billingDayOfWeekMode = billingDayOfWeekMode; return this; }

    public String getPiiCleared() { return piiCleared; }
    public Customer setPiiCleared(String piiCleared) { this.piiCleared = piiCleared; return this; }

    public Boolean getAutoCloseInvoices() { return autoCloseInvoices; }
    public Customer setAutoCloseInvoices(Boolean autoCloseInvoices) { this.autoCloseInvoices = autoCloseInvoices; return this; }

    public String getCardStatus() { return cardStatus; }
    public Customer setCardStatus(String cardStatus) { this.cardStatus = cardStatus; return this; }

    public Integer getPromotionalCredits() { return promotionalCredits; }
    public Customer setPromotionalCredits(Integer promotionalCredits) { this.promotionalCredits = promotionalCredits; return this; }

    public Integer getRefundableCredits() { return refundableCredits; }
    public Customer setRefundableCredits(Integer refundableCredits) { this.refundableCredits = refundableCredits; return this; }

    public Integer getExcessPayments() { return excessPayments; }
    public Customer setExcessPayments(Integer excessPayments) { this.excessPayments = excessPayments; return this; }

    public Integer getUnbilledCharges() { return unbilledCharges; }
    public Customer setUnbilledCharges(Integer unbilledCharges) { this.unbilledCharges = unbilledCharges; return this; }

    public String getPreferredCurrencyCode() { return preferredCurrencyCode; }
    public Customer setPreferredCurrencyCode(String preferredCurrencyCode) { this.preferredCurrencyCode = preferredCurrencyCode; return this; }

    public Integer getMrr() { return mrr; }
    public Customer setMrr(Integer mrr) { this.mrr = mrr; return this; }

    public String getPrimaryPaymentSourceId() { return primaryPaymentSourceId; }
    public Customer setPrimaryPaymentSourceId(String primaryPaymentSourceId) { this.primaryPaymentSourceId = primaryPaymentSourceId; return this; }

    public String getBackupPaymentSourceId() { return backupPaymentSourceId; }
    public Customer setBackupPaymentSourceId(String backupPaymentSourceId) { this.backupPaymentSourceId = backupPaymentSourceId; return this; }

    public String getChannel() { return channel; }
    public Customer setChannel(String channel) { this.channel = channel; return this; }

    public Boolean getDeleted() { return deleted; }
    public Customer setDeleted(Boolean deleted) { this.deleted = deleted; return this; }

    public String getObject() { return object; }
    public Customer setObject(String object) { this.object = object; return this; }

    public Boolean getBusinessCustomerWithoutVatNumber() { return businessCustomerWithoutVatNumber; }
    public Customer setBusinessCustomerWithoutVatNumber(Boolean businessCustomerWithoutVatNumber) { this.businessCustomerWithoutVatNumber = businessCustomerWithoutVatNumber; return this; }

    public String getClientProfileId() { return clientProfileId; }
    public Customer setClientProfileId(String clientProfileId) { this.clientProfileId = clientProfileId; return this; }

    public String getCustomerType() { return customerType; }
    public Customer setCustomerType(String customerType) { this.customerType = customerType; return this; }

    public String getTaxjarExemptionCategory() { return taxjarExemptionCategory; }
    public Customer setTaxjarExemptionCategory(String taxjarExemptionCategory) { this.taxjarExemptionCategory = taxjarExemptionCategory; return this; }

    public Boolean getRegisteredForGst() { return registeredForGst; }
    public Customer setRegisteredForGst(Boolean registeredForGst) { this.registeredForGst = registeredForGst; return this; }

    public Boolean getIsEinvoiceEnabled() { return isEinvoiceEnabled; }
    public Customer setIsEinvoiceEnabled(Boolean isEinvoiceEnabled) { this.isEinvoiceEnabled = isEinvoiceEnabled; return this; }

    public String getEinvoicingMethod() { return einvoicingMethod; }
    public Customer setEinvoicingMethod(String einvoicingMethod) { this.einvoicingMethod = einvoicingMethod; return this; }

    public String getInvoiceNotes() { return invoiceNotes; }
    public Customer setInvoiceNotes(String invoiceNotes) { this.invoiceNotes = invoiceNotes; return this; }

    // Nested object getters and setters

    public BillingAddress getBillingAddress() { return billingAddress; }
    public Customer setBillingAddress(BillingAddress billingAddress) { this.billingAddress = billingAddress; return this; }

    public List<Contact> getContacts() { return contacts; }
    public Customer setContacts(List<Contact> contacts) { this.contacts = contacts; return this; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public Customer setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; return this; }

    public List<Balance> getBalances() { return balances; }
    public Customer setBalances(List<Balance> balances) { this.balances = balances; return this; }

    public List<EntityIdentifier> getEntityIdentifiers() { return entityIdentifiers; }
    public Customer setEntityIdentifiers(List<EntityIdentifier> entityIdentifiers) { this.entityIdentifiers = entityIdentifiers; return this; }

    public List<TaxProvidersField> getTaxProvidersFields() { return taxProvidersFields; }
    public Customer setTaxProvidersFields(List<TaxProvidersField> taxProvidersFields) { this.taxProvidersFields = taxProvidersFields; return this; }

    public Relationship getRelationship() { return relationship; }
    public Customer setRelationship(Relationship relationship) { this.relationship = relationship; return this; }

    public ParentAccountAccess getParentAccountAccess() { return parentAccountAccess; }
    public Customer setParentAccountAccess(ParentAccountAccess parentAccountAccess) { this.parentAccountAccess = parentAccountAccess; return this; }

    public ChildAccountAccess getChildAccountAccess() { return childAccountAccess; }
    public Customer setChildAccountAccess(ChildAccountAccess childAccountAccess) { this.childAccountAccess = childAccountAccess; return this; }

    public Object getMetaData() { return metaData; }
    public Customer setMetaData(Object metaData) { this.metaData = metaData; return this; }

}
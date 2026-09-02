package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    // ========== INDEXED ACCESSORS FOR ENTITY IDENTIFIERS (e.g. entity_identifiers[scheme][index]) ==========

    private EntityIdentifier getOrCreateEntityIdentifier(int index) {
        if (this.entityIdentifiers == null) {
            this.entityIdentifiers = new ArrayList<>();
        }
        while (this.entityIdentifiers.size() <= index) {
            this.entityIdentifiers.add(new EntityIdentifier());
        }
        return this.entityIdentifiers.get(index);
    }

    public CreateCustomerApiRequest entityIdentifierId(int index, String id) {
        getOrCreateEntityIdentifier(index).setId(id);
        return this;
    }

    public CreateCustomerApiRequest entityIdentifierScheme(int index, String scheme) {
        getOrCreateEntityIdentifier(index).setScheme(scheme);
        return this;
    }

    public CreateCustomerApiRequest entityIdentifierValue(int index, String value) {
        getOrCreateEntityIdentifier(index).setValue(value);
        return this;
    }

    public CreateCustomerApiRequest entityIdentifierStandard(int index, String standard) {
        getOrCreateEntityIdentifier(index).setStandard(standard);
        return this;
    }

    // ========== INDEXED ACCESSORS FOR TAX PROVIDER FIELDS (e.g. tax_providers_fields[field_id][index]) ==========

    private TaxProvidersField getOrCreateTaxProvidersField(int index) {
        if (this.taxProvidersFields == null) {
            this.taxProvidersFields = new ArrayList<>();
        }
        while (this.taxProvidersFields.size() <= index) {
            this.taxProvidersFields.add(new TaxProvidersField());
        }
        return this.taxProvidersFields.get(index);
    }

    public CreateCustomerApiRequest taxProvidersFieldProviderName(int index, String providerName) {
        getOrCreateTaxProvidersField(index).setProviderName(providerName);
        return this;
    }

    public CreateCustomerApiRequest taxProvidersFieldFieldId(int index, String fieldId) {
        getOrCreateTaxProvidersField(index).setFieldId(fieldId);
        return this;
    }

    public CreateCustomerApiRequest taxProvidersFieldFieldValue(int index, String fieldValue) {
        getOrCreateTaxProvidersField(index).setFieldValue(fieldValue);
        return this;
    }


    // =========================================================================
    // INNER CLASSES FOR SUBSECTIONS
    // =========================================================================

    /**
     * Inner class representing Customer Billing Address parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BillingAddress {

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

        public String getFirstName() { return firstName; }
        public BillingAddress setFirstName(String firstName) { this.firstName = firstName; return this; }

        public String getLastName() { return lastName; }
        public BillingAddress setLastName(String lastName) { this.lastName = lastName; return this; }

        public String getEmail() { return email; }
        public BillingAddress setEmail(String email) { this.email = email; return this; }

        public String getCompany() { return company; }
        public BillingAddress setCompany(String company) { this.company = company; return this; }

        public String getPhone() { return phone; }
        public BillingAddress setPhone(String phone) { this.phone = phone; return this; }

        public String getLine1() { return line1; }
        public BillingAddress setLine1(String line1) { this.line1 = line1; return this; }

        public String getLine2() { return line2; }
        public BillingAddress setLine2(String line2) { this.line2 = line2; return this; }

        public String getLine3() { return line3; }
        public BillingAddress setLine3(String line3) { this.line3 = line3; return this; }

        public String getCity() { return city; }
        public BillingAddress setCity(String city) { this.city = city; return this; }

        public String getStateCode() { return stateCode; }
        public BillingAddress setStateCode(String stateCode) { this.stateCode = stateCode; return this; }

        public String getState() { return state; }
        public BillingAddress setState(String state) { this.state = state; return this; }

        public String getZip() { return zip; }
        public BillingAddress setZip(String zip) { this.zip = zip; return this; }

        public String getCountry() { return country; }
        public BillingAddress setCountry(String country) { this.country = country; return this; }

        public String getValidationStatus() { return validationStatus; }
        public BillingAddress setValidationStatus(String validationStatus) { this.validationStatus = validationStatus; return this; }
    }

    /**
     * Inner class representing Raw Credit Card parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Card {

        @JsonProperty("gateway_account_id")
        private String gatewayAccountId;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("number")
        private String number;

        @JsonProperty("expiry_month")
        private Integer expiryMonth;

        @JsonProperty("expiry_year")
        private Integer expiryYear;

        @JsonProperty("cvv")
        private String cvv;

        @JsonProperty("preferred_scheme")
        private String preferredScheme;

        @JsonProperty("billing_addr1")
        private String billingAddr1;

        @JsonProperty("billing_addr2")
        private String billingAddr2;

        @JsonProperty("billing_city")
        private String billingCity;

        @JsonProperty("billing_state_code")
        private String billingStateCode;

        @JsonProperty("billing_state")
        private String billingState;

        @JsonProperty("billing_zip")
        private String billingZip;

        @JsonProperty("billing_country")
        private String billingCountry;

        @JsonProperty("additional_information")
        private Object additionalInformation;

        public String getGatewayAccountId() { return gatewayAccountId; }
        public Card setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

        public String getFirstName() { return firstName; }
        public Card setFirstName(String firstName) { this.firstName = firstName; return this; }

        public String getLastName() { return lastName; }
        public Card setLastName(String lastName) { this.lastName = lastName; return this; }

        public String getNumber() { return number; }
        public Card setNumber(String number) { this.number = number; return this; }

        public Integer getExpiryMonth() { return expiryMonth; }
        public Card setExpiryMonth(Integer expiryMonth) { this.expiryMonth = expiryMonth; return this; }

        public Integer getExpiryYear() { return expiryYear; }
        public Card setExpiryYear(Integer expiryYear) { this.expiryYear = expiryYear; return this; }

        public String getCvv() { return cvv; }
        public Card setCvv(String cvv) { this.cvv = cvv; return this; }

        public String getPreferredScheme() { return preferredScheme; }
        public Card setPreferredScheme(String preferredScheme) { this.preferredScheme = preferredScheme; return this; }

        public String getBillingAddr1() { return billingAddr1; }
        public Card setBillingAddr1(String billingAddr1) { this.billingAddr1 = billingAddr1; return this; }

        public String getBillingAddr2() { return billingAddr2; }
        public Card setBillingAddr2(String billingAddr2) { this.billingAddr2 = billingAddr2; return this; }

        public String getBillingCity() { return billingCity; }
        public Card setBillingCity(String billingCity) { this.billingCity = billingCity; return this; }

        public String getBillingStateCode() { return billingStateCode; }
        public Card setBillingStateCode(String billingStateCode) { this.billingStateCode = billingStateCode; return this; }

        public String getBillingState() { return billingState; }
        public Card setBillingState(String billingState) { this.billingState = billingState; return this; }

        public String getBillingZip() { return billingZip; }
        public Card setBillingZip(String billingZip) { this.billingZip = billingZip; return this; }

        public String getBillingCountry() { return billingCountry; }
        public Card setBillingCountry(String billingCountry) { this.billingCountry = billingCountry; return this; }

        public Object getAdditionalInformation() { return additionalInformation; }
        public Card setAdditionalInformation(Object additionalInformation) { this.additionalInformation = additionalInformation; return this; }
    }

    /**
     * Inner class representing Bank Account parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BankAccount {

        @JsonProperty("gateway_account_id")
        private String gatewayAccountId;

        @JsonProperty("iban")
        private String iban;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("company")
        private String company;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("bank_name")
        private String bankName;

        @JsonProperty("account_number")
        private String accountNumber;

        @JsonProperty("routing_number")
        private String routingNumber;

        @JsonProperty("bank_code")
        private String bankCode;

        @JsonProperty("account_type")
        private String accountType;

        @JsonProperty("account_holder_type")
        private String accountHolderType;

        @JsonProperty("echeck_type")
        private String echeckType;

        @JsonProperty("issuing_country")
        private String issuingCountry;

        @JsonProperty("swedish_identity_number")
        private String swedishIdentityNumber;

        @JsonProperty("billing_address")
        private Object billingAddress;

        public String getGatewayAccountId() { return gatewayAccountId; }
        public BankAccount setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

        public String getIban() { return iban; }
        public BankAccount setIban(String iban) { this.iban = iban; return this; }

        public String getFirstName() { return firstName; }
        public BankAccount setFirstName(String firstName) { this.firstName = firstName; return this; }

        public String getLastName() { return lastName; }
        public BankAccount setLastName(String lastName) { this.lastName = lastName; return this; }

        public String getCompany() { return company; }
        public BankAccount setCompany(String company) { this.company = company; return this; }

        public String getEmail() { return email; }
        public BankAccount setEmail(String email) { this.email = email; return this; }

        public String getPhone() { return phone; }
        public BankAccount setPhone(String phone) { this.phone = phone; return this; }

        public String getBankName() { return bankName; }
        public BankAccount setBankName(String bankName) { this.bankName = bankName; return this; }

        public String getAccountNumber() { return accountNumber; }
        public BankAccount setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; return this; }

        public String getRoutingNumber() { return routingNumber; }
        public BankAccount setRoutingNumber(String routingNumber) { this.routingNumber = routingNumber; return this; }

        public String getBankCode() { return bankCode; }
        public BankAccount setBankCode(String bankCode) { this.bankCode = bankCode; return this; }

        public String getAccountType() { return accountType; }
        public BankAccount setAccountType(String accountType) { this.accountType = accountType; return this; }

        public String getAccountHolderType() { return accountHolderType; }
        public BankAccount setAccountHolderType(String accountHolderType) { this.accountHolderType = accountHolderType; return this; }

        public String getEcheckType() { return echeckType; }
        public BankAccount setEcheckType(String echeckType) { this.echeckType = echeckType; return this; }

        public String getIssuingCountry() { return issuingCountry; }
        public BankAccount setIssuingCountry(String issuingCountry) { this.issuingCountry = issuingCountry; return this; }

        public String getSwedishIdentityNumber() { return swedishIdentityNumber; }
        public BankAccount setSwedishIdentityNumber(String swedishIdentityNumber) { this.swedishIdentityNumber = swedishIdentityNumber; return this; }

        public Object getBillingAddress() { return billingAddress; }
        public BankAccount setBillingAddress(Object billingAddress) { this.billingAddress = billingAddress; return this; }
    }

    /**
     * Inner class representing Payment Method parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PaymentMethod {

        @JsonProperty("type")
        private String type;

        @JsonProperty("gateway_account_id")
        private String gatewayAccountId;

        @JsonProperty("reference_id")
        private String referenceId;

        @JsonProperty("tmp_token")
        private String tmpToken;

        @JsonProperty("issuing_country")
        private String issuingCountry;

        @JsonProperty("additional_information")
        private Object additionalInformation;

        public String getType() { return type; }
        public PaymentMethod setType(String type) { this.type = type; return this; }

        public String getGatewayAccountId() { return gatewayAccountId; }
        public PaymentMethod setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

        public String getReferenceId() { return referenceId; }
        public PaymentMethod setReferenceId(String referenceId) { this.referenceId = referenceId; return this; }

        public String getTmpToken() { return tmpToken; }
        public PaymentMethod setTmpToken(String tmpToken) { this.tmpToken = tmpToken; return this; }

        public String getIssuingCountry() { return issuingCountry; }
        public PaymentMethod setIssuingCountry(String issuingCountry) { this.issuingCountry = issuingCountry; return this; }

        public Object getAdditionalInformation() { return additionalInformation; }
        public PaymentMethod setAdditionalInformation(Object additionalInformation) { this.additionalInformation = additionalInformation; return this; }
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

        public String getId() { return id; }
        public PaymentIntent setId(String id) { this.id = id; return this; }

        public String getGatewayAccountId() { return gatewayAccountId; }
        public PaymentIntent setGatewayAccountId(String gatewayAccountId) { this.gatewayAccountId = gatewayAccountId; return this; }

        public String getGwToken() { return gwToken; }
        public PaymentIntent setGwToken(String gwToken) { this.gwToken = gwToken; return this; }

        public String getPaymentMethodType() { return paymentMethodType; }
        public PaymentIntent setPaymentMethodType(String paymentMethodType) { this.paymentMethodType = paymentMethodType; return this; }

        public String getReferenceId() { return referenceId; }
        public PaymentIntent setReferenceId(String referenceId) { this.referenceId = referenceId; return this; }

        public Object getAdditionalInformation() { return additionalInformation; }
        public PaymentIntent setAdditionalInformation(Object additionalInformation) { this.additionalInformation = additionalInformation; return this; }
    }

    /**
     * Inner class representing Peppol BIS Entity Identifier parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class EntityIdentifier {

        @JsonProperty("id")
        private String id;

        @JsonProperty("scheme")
        private String scheme;

        @JsonProperty("value")
        private String value;

        @JsonProperty("standard")
        private String standard;

        public String getId() {
            return id;
        }
        public EntityIdentifier setId(String id) {
            this.id = id;
            return this;
        }

        public String getScheme() { return scheme; }
        public EntityIdentifier setScheme(String scheme) { this.scheme = scheme; return this; }

        public String getValue() { return value; }
        public EntityIdentifier setValue(String value) { this.value = value; return this; }

        public String getStandard() { return standard; }
        public EntityIdentifier setStandard(String standard) { this.standard = standard; return this; }
    }

    /**
     * Inner class representing Tax Provider Fields parameters.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TaxProvidersField {

        @JsonProperty("provider_name")
        private String providerName;

        @JsonProperty("field_id")
        private String fieldId;

        @JsonProperty("field_value")
        private String fieldValue;

        public String getProviderName() { return providerName; }
        public TaxProvidersField setProviderName(String providerName) { this.providerName = providerName; return this; }

        public String getFieldId() { return fieldId; }
        public TaxProvidersField setFieldId(String fieldId) { this.fieldId = fieldId; return this; }

        public String getFieldValue() { return fieldValue; }
        public TaxProvidersField setFieldValue(String fieldValue) { this.fieldValue = fieldValue; return this; }
    }

    // ========== FORM URL ENCODING CONVERTER ==========

    public String toFormUrlEncoded() {
        StringBuilder formParams = new StringBuilder();

        // Top-level fields
        addFormField(formParams, "id", id);
        addFormField(formParams, "first_name", firstName);
        addFormField(formParams, "last_name", lastName);
        addFormField(formParams, "email", email);
        addFormField(formParams, "preferred_currency_code", preferredCurrencyCode);
        addFormField(formParams, "phone", phone);
        addFormField(formParams, "company", company);
        addFormField(formParams, "auto_collection", autoCollection);
        addFormField(formParams, "net_term_days", netTermDays);
        addFormField(formParams, "allow_direct_debit", allowDirectDebit);
        addFormField(formParams, "vat_number", vatNumber);
        addFormField(formParams, "vat_number_prefix", vatNumberPrefix);
        addFormField(formParams, "entity_identifier_scheme", entityIdentifierScheme);
        addFormField(formParams, "entity_identifier_standard", entityIdentifierStandard);
        addFormField(formParams, "registered_for_gst", registeredForGst);
        addFormField(formParams, "is_einvoice_enabled", isEinvoiceEnabled);
        addFormField(formParams, "einvoicing_method", einvoicingMethod);
        addFormField(formParams, "taxability", taxability);
        addFormField(formParams, "exemption_details", exemptionDetails);
        addFormField(formParams, "customer_type", customerType);
        addFormField(formParams, "client_profile_id", clientProfileId);
        addFormField(formParams, "taxjar_exemption_category", taxjarExemptionCategory);
        addFormField(formParams, "business_customer_without_vat_number", businessCustomerWithoutVatNumber);
        addFormField(formParams, "locale", locale);
        addFormField(formParams, "entity_code", entityCode);
        addFormField(formParams, "exempt_number", exemptNumber);
        addFormField(formParams, "meta_data", metaData);
        addFormField(formParams, "offline_payment_method", offlinePaymentMethod);
        addFormField(formParams, "auto_close_invoices", autoCloseInvoices);
        addFormField(formParams, "consolidated_invoicing", consolidatedInvoicing);
        addFormField(formParams, "token_id", tokenId);
        addFormField(formParams, "business_entity_id", businessEntityId);
        addFormField(formParams, "invoice_notes", invoiceNotes);

        // Nested objects
        if (billingAddress != null) {
            addFormField(formParams, "billing_address[first_name]", billingAddress.getFirstName());
            addFormField(formParams, "billing_address[last_name]", billingAddress.getLastName());
            addFormField(formParams, "billing_address[email]", billingAddress.getEmail());
            addFormField(formParams, "billing_address[company]", billingAddress.getCompany());
            addFormField(formParams, "billing_address[phone]", billingAddress.getPhone());
            addFormField(formParams, "billing_address[line1]", billingAddress.getLine1());
            addFormField(formParams, "billing_address[line2]", billingAddress.getLine2());
            addFormField(formParams, "billing_address[line3]", billingAddress.getLine3());
            addFormField(formParams, "billing_address[city]", billingAddress.getCity());
            addFormField(formParams, "billing_address[state_code]", billingAddress.getStateCode());
            addFormField(formParams, "billing_address[state]", billingAddress.getState());
            addFormField(formParams, "billing_address[zip]", billingAddress.getZip());
            addFormField(formParams, "billing_address[country]", billingAddress.getCountry());
            addFormField(formParams, "billing_address[validation_status]", billingAddress.getValidationStatus());
        }

        if (card != null) {
            addFormField(formParams, "card[gateway_account_id]", card.getGatewayAccountId());
            addFormField(formParams, "card[first_name]", card.getFirstName());
            addFormField(formParams, "card[last_name]", card.getLastName());
            addFormField(formParams, "card[number]", card.getNumber());
            addFormField(formParams, "card[expiry_month]", card.getExpiryMonth());
            addFormField(formParams, "card[expiry_year]", card.getExpiryYear());
            addFormField(formParams, "card[cvv]", card.getCvv());
            addFormField(formParams, "card[preferred_scheme]", card.getPreferredScheme());
        }

        if (entityIdentifiers != null) {
            for (int i = 0; i < entityIdentifiers.size(); i++) {
                EntityIdentifier identifier = entityIdentifiers.get(i);
                addIndexedFormField(formParams, "entity_identifiers[id]", i, identifier.getId());
                addIndexedFormField(formParams, "entity_identifiers[scheme]", i, identifier.getScheme());
                addIndexedFormField(formParams, "entity_identifiers[value]", i, identifier.getValue());
                addIndexedFormField(formParams, "entity_identifiers[standard]", i, identifier.getStandard());
            }
        }

        if (taxProvidersFields != null) {
            for (int i = 0; i < taxProvidersFields.size(); i++) {
                TaxProvidersField field = taxProvidersFields.get(i);
                addIndexedFormField(formParams, "tax_providers_fields[provider_name]", i, field.getProviderName());
                addIndexedFormField(formParams, "tax_providers_fields[field_id]", i, field.getFieldId());
                addIndexedFormField(formParams, "tax_providers_fields[field_value]", i, field.getFieldValue());
            }
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

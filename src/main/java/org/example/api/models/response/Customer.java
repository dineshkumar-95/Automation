package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    
    @JsonProperty("company")
    private String company;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("auto_collection")
    private String autoCollection;
    
    @JsonProperty("net_term_days")
    private Integer netTermDays;
    
    @JsonProperty("allow_direct_debit")
    private Boolean allowDirectDebit;
    
    @JsonProperty("created_at")
    private Long createdAt;
    
    @JsonProperty("created_from_ip")
    private String createdFromIp;
    
    @JsonProperty("taxability")
    private String taxability;
    
    @JsonProperty("updated_at")
    private Long updatedAt;
    
    @JsonProperty("pii_cleared")
    private String piiCleared;
    
    @JsonProperty("channel")
    private String channel;
    
    @JsonProperty("resource_version")
    private Long resourceVersion;
    
    @JsonProperty("deleted")
    private Boolean deleted;
    
    @JsonProperty("object")
    private String object;
    
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
    
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    
    @JsonProperty("auto_close_invoices")
    private Boolean autoCloseInvoices;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAutoCollection() {
        return autoCollection;
    }

    public void setAutoCollection(String autoCollection) {
        this.autoCollection = autoCollection;
    }

    public Integer getNetTermDays() {
        return netTermDays;
    }

    public void setNetTermDays(Integer netTermDays) {
        this.netTermDays = netTermDays;
    }

    public Boolean getAllowDirectDebit() {
        return allowDirectDebit;
    }

    public void setAllowDirectDebit(Boolean allowDirectDebit) {
        this.allowDirectDebit = allowDirectDebit;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedFromIp() {
        return createdFromIp;
    }

    public void setCreatedFromIp(String createdFromIp) {
        this.createdFromIp = createdFromIp;
    }

    public String getTaxability() {
        return taxability;
    }

    public void setTaxability(String taxability) {
        this.taxability = taxability;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPiiCleared() {
        return piiCleared;
    }

    public void setPiiCleared(String piiCleared) {
        this.piiCleared = piiCleared;
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

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Integer getPromotionalCredits() {
        return promotionalCredits;
    }

    public void setPromotionalCredits(Integer promotionalCredits) {
        this.promotionalCredits = promotionalCredits;
    }

    public Integer getRefundableCredits() {
        return refundableCredits;
    }

    public void setRefundableCredits(Integer refundableCredits) {
        this.refundableCredits = refundableCredits;
    }

    public Integer getExcessPayments() {
        return excessPayments;
    }

    public void setExcessPayments(Integer excessPayments) {
        this.excessPayments = excessPayments;
    }

    public Integer getUnbilledCharges() {
        return unbilledCharges;
    }

    public void setUnbilledCharges(Integer unbilledCharges) {
        this.unbilledCharges = unbilledCharges;
    }

    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    public void setPreferredCurrencyCode(String preferredCurrencyCode) {
        this.preferredCurrencyCode = preferredCurrencyCode;
    }

    public Integer getMrr() {
        return mrr;
    }

    public void setMrr(Integer mrr) {
        this.mrr = mrr;
    }

    public Boolean getAutoCloseInvoices() {
        return autoCloseInvoices;
    }

    public void setAutoCloseInvoices(Boolean autoCloseInvoices) {
        this.autoCloseInvoices = autoCloseInvoices;
    }

    public String getPrimaryPaymentSourceId() {
        return primaryPaymentSourceId;
    }

    public void setPrimaryPaymentSourceId(String primaryPaymentSourceId) {
        this.primaryPaymentSourceId = primaryPaymentSourceId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Inner class for PaymentMethod
    public static class PaymentMethod {
        @JsonProperty("object")
        private String object;
        
        @JsonProperty("type")
        private String type;
        
        @JsonProperty("reference_id")
        private String referenceId;
        
        @JsonProperty("gateway")
        private String gateway;
        
        @JsonProperty("gateway_account_id")
        private String gatewayAccountId;
        
        @JsonProperty("status")
        private String status;

        // Getters and Setters
        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReferenceId() {
            return referenceId;
        }

        public void setReferenceId(String referenceId) {
            this.referenceId = referenceId;
        }

        public String getGateway() {
            return gateway;
        }

        public void setGateway(String gateway) {
            this.gateway = gateway;
        }

        public String getGatewayAccountId() {
            return gatewayAccountId;
        }

        public void setGatewayAccountId(String gatewayAccountId) {
            this.gatewayAccountId = gatewayAccountId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
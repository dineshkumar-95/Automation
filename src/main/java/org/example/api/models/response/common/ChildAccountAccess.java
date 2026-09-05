package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAccountAccess {

    @JsonProperty("portal_edit_subscriptions")
    private String portalEditSubscriptions;

    @JsonProperty("portal_download_invoices")
    private String portalDownloadInvoices;

    @JsonProperty("send_subscription_emails")
    private Boolean sendSubscriptionEmails;

    @JsonProperty("send_invoice_emails")
    private Boolean sendInvoiceEmails;

    @JsonProperty("send_payment_emails")
    private Boolean sendPaymentEmails;

    public String getPortalEditSubscriptions() { return portalEditSubscriptions; }
    public ChildAccountAccess setPortalEditSubscriptions(String portalEditSubscriptions) { this.portalEditSubscriptions = portalEditSubscriptions; return this; }

    public String getPortalDownloadInvoices() { return portalDownloadInvoices; }
    public ChildAccountAccess setPortalDownloadInvoices(String portalDownloadInvoices) { this.portalDownloadInvoices = portalDownloadInvoices; return this; }

    public Boolean getSendSubscriptionEmails() { return sendSubscriptionEmails; }
    public ChildAccountAccess setSendSubscriptionEmails(Boolean sendSubscriptionEmails) { this.sendSubscriptionEmails = sendSubscriptionEmails; return this; }

    public Boolean getSendInvoiceEmails() { return sendInvoiceEmails; }
    public ChildAccountAccess setSendInvoiceEmails(Boolean sendInvoiceEmails) { this.sendInvoiceEmails = sendInvoiceEmails; return this; }

    public Boolean getSendPaymentEmails() { return sendPaymentEmails; }
    public ChildAccountAccess setSendPaymentEmails(Boolean sendPaymentEmails) { this.sendPaymentEmails = sendPaymentEmails; return this; }
}

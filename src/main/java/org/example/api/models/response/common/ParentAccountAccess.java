package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentAccountAccess {

    @JsonProperty("portal_edit_child_subscriptions")
    private String portalEditChildSubscriptions;

    @JsonProperty("portal_download_child_invoices")
    private String portalDownloadChildInvoices;

    @JsonProperty("send_subscription_emails")
    private Boolean sendSubscriptionEmails;

    @JsonProperty("send_invoice_emails")
    private Boolean sendInvoiceEmails;

    @JsonProperty("send_payment_emails")
    private Boolean sendPaymentEmails;

    public String getPortalEditChildSubscriptions() { return portalEditChildSubscriptions; }
    public ParentAccountAccess setPortalEditChildSubscriptions(String portalEditChildSubscriptions) { this.portalEditChildSubscriptions = portalEditChildSubscriptions; return this; }

    public String getPortalDownloadChildInvoices() { return portalDownloadChildInvoices; }
    public ParentAccountAccess setPortalDownloadChildInvoices(String portalDownloadChildInvoices) { this.portalDownloadChildInvoices = portalDownloadChildInvoices; return this; }

    public Boolean getSendSubscriptionEmails() { return sendSubscriptionEmails; }
    public ParentAccountAccess setSendSubscriptionEmails(Boolean sendSubscriptionEmails) { this.sendSubscriptionEmails = sendSubscriptionEmails; return this; }

    public Boolean getSendInvoiceEmails() { return sendInvoiceEmails; }
    public ParentAccountAccess setSendInvoiceEmails(Boolean sendInvoiceEmails) { this.sendInvoiceEmails = sendInvoiceEmails; return this; }

    public Boolean getSendPaymentEmails() { return sendPaymentEmails; }
    public ParentAccountAccess setSendPaymentEmails(Boolean sendPaymentEmails) { this.sendPaymentEmails = sendPaymentEmails; return this; }
}

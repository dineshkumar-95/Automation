package org.example.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.model.common.Card;
import org.example.api.model.common.PaymentSource;
import org.example.api.model.common.Transaction;
import org.example.api.model.customer.Customer;
import org.example.api.model.emaillog.EmailLog;
import org.example.api.model.invoice.Invoice;
import org.example.api.model.subscription.Subscription;

/**
 * Generic Chargebee API response envelope.
 * Replaces the old concrete ChargebeeResponse, Customers, Subscriptions, Cards wrapper classes.
 * Contains all possible top-level entity fields; only the relevant ones will be populated per API call.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("card")
    private Card card;

    @JsonProperty("subscription")
    private Subscription subscription;

    @JsonProperty("transaction")
    private Transaction transaction;

    @JsonProperty("payment_source")
    private PaymentSource paymentSource;

    @JsonProperty("email_log")
    private EmailLog emailLog;

    @JsonProperty("invoice")
    private Invoice invoice;

    public Customer getCustomer() { return customer; }
    public ApiResponse setCustomer(Customer customer) { this.customer = customer; return this; }

    public Card getCard() { return card; }
    public ApiResponse setCard(Card card) { this.card = card; return this; }

    public Subscription getSubscription() { return subscription; }
    public ApiResponse setSubscription(Subscription subscription) { this.subscription = subscription; return this; }

    public Transaction getTransaction() { return transaction; }
    public ApiResponse setTransaction(Transaction transaction) { this.transaction = transaction; return this; }

    public PaymentSource getPaymentSource() { return paymentSource; }
    public ApiResponse setPaymentSource(PaymentSource paymentSource) { this.paymentSource = paymentSource; return this; }

    public EmailLog getEmailLog() { return emailLog; }
    public ApiResponse setEmailLog(EmailLog emailLog) { this.emailLog = emailLog; return this; }

    public Invoice getInvoice() { return invoice; }
    public ApiResponse setInvoice(Invoice invoice) { this.invoice = invoice; return this; }
}

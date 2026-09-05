package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.*;
import org.example.api.models.response.EmailLog;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargebeeResponse {

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

    public Customer getCustomer() {
        return customer;
    }

    public ChargebeeResponse setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public ChargebeeResponse setCard(Card card) {
        this.card = card;
        return this;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public ChargebeeResponse setSubscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public ChargebeeResponse setTransaction(Transaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public PaymentSource getPaymentSource() {
        return paymentSource;
    }

    public ChargebeeResponse setPaymentSource(PaymentSource paymentSource) {
        this.paymentSource = paymentSource;
        return this;
    }

    public EmailLog getEmailLog() {
        return emailLog;
    }

    public ChargebeeResponse setEmailLog(EmailLog emailLog) {
        this.emailLog = emailLog;
        return this;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public ChargebeeResponse setInvoice(Invoice invoice) {
        this.invoice = invoice;
        return this;
    }
}
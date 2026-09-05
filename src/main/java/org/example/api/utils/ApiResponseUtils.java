package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.models.response.common.*;
import org.example.api.models.response.*;

import java.util.List;

public final class ApiResponseUtils {
    public static Subscription subscription(Response response) {
        return response.jsonPath().getObject("subscription", Subscription.class);
    }

    public static Customer customer(Response response) {
        return response.jsonPath().getObject("customer", Customer.class);
    }

    public static Customers customers(Response response) {
        // response.as() automatically maps the root JSON object to our Customers wrapper class
        return response.as(Customers.class);
    }

    public static Invoice invoice(Response response) {
        return response.jsonPath().getObject("invoice", Invoice.class);
    }

    public static Card card(Response response) {
        return response.jsonPath().getObject("card", Card.class);
    }

    public static Transaction transaction(Response response) {
        return response.jsonPath().getObject("transaction", Transaction.class);
    }

    public static PaymentSource paymentSource(Response response) {
        return response.jsonPath().getObject("payment_source", PaymentSource.class);
    }

    public static EmailLog emailLog(Response response) {
        return response.jsonPath().getObject("email_log", EmailLog.class);
    }

    public static List<EmailLog> emailLogs(Response response) {
        return response.jsonPath().getList("email_logs", EmailLog.class);
    }
}

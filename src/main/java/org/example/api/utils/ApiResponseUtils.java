package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.models.response.common.*;
import org.example.api.models.response.*;

public final class ApiResponseUtils {
    public static Subscription subscription(Response response) {
        return response.jsonPath().getObject("subscription", Subscription.class);
    }

    public static Customer customer(Response response) {
        return response.jsonPath().getObject("customer", Customer.class);
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

    public static java.util.List<EmailLog> emailLogs(Response response) {
        return response.jsonPath().getList("email_logs", EmailLog.class);
    }
}

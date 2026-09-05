package org.example.api.utils;

import io.restassured.response.Response;
import org.example.api.models.response.ChargebeeResponse;
import org.example.api.models.response.ChargebeeListResponse;
import org.example.api.models.response.Customers;
import org.example.api.models.response.Customer;
import org.example.api.models.response.Subscription;
import org.example.api.models.response.Invoice;
import org.example.api.models.response.EmailLog;
import org.example.api.models.response.common.*;
import java.util.List;

public final class ApiResponseUtils {
    
    public static ChargebeeResponse parse(Response response) {
        return response.as(ChargebeeResponse.class);
    }

    public static ChargebeeListResponse parseList(Response response) {
        return response.as(ChargebeeListResponse.class);
    }

    // Backwards compatibility methods - deprecated
    @Deprecated
    public static Subscription subscription(Response response) {
        return parse(response).getSubscription();
    }

    @Deprecated
    public static Customer customer(Response response) {
        return parse(response).getCustomer();
    }

    @Deprecated
    public static Customers customers(Response response) {
        return parseList(response).getCustomers();
    }

    @Deprecated
    public static Invoice invoice(Response response) {
        return parse(response).getInvoice();
    }

    @Deprecated
    public static Card card(Response response) {
        return parse(response).getCard();
    }

    @Deprecated
    public static Transaction transaction(Response response) {
        return parse(response).getTransaction();
    }

    @Deprecated
    public static PaymentSource paymentSource(Response response) {
        return parse(response).getPaymentSource();
    }

    @Deprecated
    public static EmailLog emailLog(Response response) {
        return parse(response).getEmailLog();
    }

    @Deprecated
    public static List<EmailLog> emailLogs(Response response) {
        return response.jsonPath().getList("email_logs", EmailLog.class);
    }
}

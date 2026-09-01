package org.example.api.utils;

import io.restassured.response.Response;
import org.example.models.api.response.Card;
import org.example.models.api.response.Customer;
import org.example.models.api.response.Invoice;
import org.example.models.api.response.Subscription;

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
}

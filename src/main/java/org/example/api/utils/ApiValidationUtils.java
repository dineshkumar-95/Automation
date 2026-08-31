package org.example.api.utils;

import java.util.Arrays;
import java.util.List;

public class ApiValidationUtils {

    public static final List<String> IGNORE_FIELDS = Arrays.asList(
            // Customer Fields
            "customer.id",
            "customer.email",
            "customer.created_at",
            "customer.updated_at",
            "customer.resource_version",
            "customer.created_from_ip",
//            "customer.card_status",
            "customer.primary_payment_source_id",
            "customer.mrr",

            // Subscription Fields
            "subscription.id",
            "subscription.customer_id",
            "subscription.current_term_start",
            "subscription.current_term_end",
            "subscription.next_billing_at",
            "subscription.created_at",
            "subscription.started_at",
            "subscription.activated_at",
            "subscription.updated_at",
            "subscription.resource_version",
            "subscription.due_since",
            "subscription.subscription_items[*].current_term_start",
            "subscription.subscription_items[*].current_term_end",
            "subscription.subscription_items[*].next_billing_at",

            // Card Fields
            "card.customer_id",
            "card.payment_source_id",
            "card.created_at",
            "card.updated_at",
            "card.ip_address",
            "card.resource_version",

            // Invoice Fields
            "invoice.id",
            "invoice.customer_id",
            "invoice.subscription_id",
            "invoice.date",
            "invoice.due_date",
            "invoice.updated_at",
            "invoice.resource_version",
            "invoice.generated_at",
            "invoice.line_items[*].id",
            "invoice.line_items[*].subscription_id",
            "invoice.line_items[*].customer_id",
            "invoice.line_items[*].date_from",
            "invoice.line_items[*].date_to",
            "invoice.line_item_tiers[*].line_item_id"
    );
}

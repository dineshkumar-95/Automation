package org.example.api.mapper.common;

import org.example.api.models.request.common.*;

import java.util.List;

import static org.example.api.utils.FormUrlEncoder.addField;
import static org.example.api.utils.FormUrlEncoder.addIndexedField;

public class ChargebeeFormMapper {

    // ========== COMMON OBJECT ENCODING METHODS ==========

    public static void addTaxProvidersFields(StringBuilder formParams, List<TaxProvidersField> taxProvidersFields) {
        if (taxProvidersFields != null) {
            for (int i = 0; i < taxProvidersFields.size(); i++) {
                TaxProvidersField field = taxProvidersFields.get(i);
                addIndexedField(formParams, "tax_providers_fields[provider_name]", i, field.getProviderName());
                addIndexedField(formParams, "tax_providers_fields[field_id]", i, field.getFieldId());
                addIndexedField(formParams, "tax_providers_fields[field_value]", i, field.getFieldValue());
            }
        }
    }

    public static void addEntityIdentifiers(StringBuilder formParams, List<EntityIdentifier> entityIdentifiers) {
        if (entityIdentifiers != null) {
            for (int i = 0; i < entityIdentifiers.size(); i++) {
                EntityIdentifier identifier = entityIdentifiers.get(i);
                addIndexedField(formParams, "entity_identifiers[id]", i, identifier.getId());
                addIndexedField(formParams, "entity_identifiers[scheme]", i, identifier.getScheme());
                addIndexedField(formParams, "entity_identifiers[value]", i, identifier.getValue());
                addIndexedField(formParams, "entity_identifiers[standard]", i, identifier.getStandard());
            }
        }
    }

    public static void addSubscriptionItems(StringBuilder formParams, List<SubscriptionItem> subscriptionItems) {
        if (subscriptionItems != null) {
            for (int i = 0; i < subscriptionItems.size(); i++) {
                SubscriptionItem item = subscriptionItems.get(i);
                addIndexedField(formParams, "subscription_items[item_price_id]", i, item.getItemPriceId());
                addIndexedField(formParams, "subscription_items[quantity]", i, item.getQuantity());
                addIndexedField(formParams, "subscription_items[quantity_in_decimal]", i, item.getQuantityInDecimal());
                addIndexedField(formParams, "subscription_items[unit_price]", i, item.getUnitPrice());
                addIndexedField(formParams, "subscription_items[unit_price_in_decimal]", i, item.getUnitPriceInDecimal());
                addIndexedField(formParams, "subscription_items[billing_cycles]", i, item.getBillingCycles());
                addIndexedField(formParams, "subscription_items[trial_end]", i, item.getTrialEnd());
                addIndexedField(formParams, "subscription_items[service_period_days]", i, item.getServicePeriodDays());
                addIndexedField(formParams, "subscription_items[charge_on_event]", i, item.getChargeOnEvent());
                addIndexedField(formParams, "subscription_items[charge_once]", i, item.getChargeOnce());
                addIndexedField(formParams, "subscription_items[description]", i, item.getDescription());
                addIndexedField(formParams, "subscription_items[charge_on_option]", i, item.getChargeOnOption());
                addIndexedField(formParams, "subscription_items[usage_accumulation_reset_frequency]", i, item.getUsageAccumulationResetFrequency());
            }
        }
    }

    public static void addDiscounts(StringBuilder formParams, List<Discount> discounts) {
        if (discounts != null) {
            for (int i = 0; i < discounts.size(); i++) {
                Discount discount = discounts.get(i);
                addIndexedField(formParams, "discounts[apply_on]", i, discount.getApplyOn());
                addIndexedField(formParams, "discounts[duration_type]", i, discount.getDurationType());
                addIndexedField(formParams, "discounts[percentage]", i, discount.getPercentage());
                addIndexedField(formParams, "discounts[amount]", i, discount.getAmount());
                addIndexedField(formParams, "discounts[period]", i, discount.getPeriod());
                addIndexedField(formParams, "discounts[period_unit]", i, discount.getPeriodUnit());
                addIndexedField(formParams, "discounts[included_in_mrr]", i, discount.getIncludedInMrr());
                addIndexedField(formParams, "discounts[item_price_id]", i, discount.getItemPriceId());
                addIndexedField(formParams, "discounts[quantity]", i, discount.getQuantity());
                addIndexedField(formParams, "discounts[discount_id]", i, discount.getDiscountId());
            }
        }
    }

    public static void addItemTiers(StringBuilder formParams, List<ItemTier> itemTiers) {
        if (itemTiers != null) {
            for (int i = 0; i < itemTiers.size(); i++) {
                ItemTier tier = itemTiers.get(i);
                addIndexedField(formParams, "item_tiers[item_price_id]", i, tier.getItemPriceId());
                addIndexedField(formParams, "item_tiers[starting_unit]", i, tier.getStartingUnit());
                addIndexedField(formParams, "item_tiers[ending_unit]", i, tier.getEndingUnit());
                addIndexedField(formParams, "item_tiers[price]", i, tier.getPrice());
                addIndexedField(formParams, "item_tiers[starting_unit_in_decimal]", i, tier.getStartingUnitInDecimal());
                addIndexedField(formParams, "item_tiers[ending_unit_in_decimal]", i, tier.getEndingUnitInDecimal());
                addIndexedField(formParams, "item_tiers[price_in_decimal]", i, tier.getPriceInDecimal());
                addIndexedField(formParams, "item_tiers[pricing_type]", i, tier.getPricingType());
                addIndexedField(formParams, "item_tiers[package_size]", i, tier.getPackageSize());
            }
        }
    }

    public static void addShippingAddress(StringBuilder formParams, ShippingAddress shippingAddress) {
        if (shippingAddress != null) {
            addField(formParams, "shipping_address[first_name]", shippingAddress.getFirstName());
            addField(formParams, "shipping_address[last_name]", shippingAddress.getLastName());
            addField(formParams, "shipping_address[email]", shippingAddress.getEmail());
            addField(formParams, "shipping_address[company]", shippingAddress.getCompany());
            addField(formParams, "shipping_address[phone]", shippingAddress.getPhone());
            addField(formParams, "shipping_address[line1]", shippingAddress.getLine1());
            addField(formParams, "shipping_address[line2]", shippingAddress.getLine2());
            addField(formParams, "shipping_address[line3]", shippingAddress.getLine3());
            addField(formParams, "shipping_address[city]", shippingAddress.getCity());
            addField(formParams, "shipping_address[state_code]", shippingAddress.getStateCode());
            addField(formParams, "shipping_address[state]", shippingAddress.getState());
            addField(formParams, "shipping_address[zip]", shippingAddress.getZip());
            addField(formParams, "shipping_address[country]", shippingAddress.getCountry());
            addField(formParams, "shipping_address[validation_status]", shippingAddress.getValidationStatus());
        }
    }

    public static void addBillingAddress(StringBuilder formParams, BillingAddress billingAddress) {
        if (billingAddress != null) {
            addField(formParams, "billing_address[first_name]", billingAddress.getFirstName());
            addField(formParams, "billing_address[last_name]", billingAddress.getLastName());
            addField(formParams, "billing_address[email]", billingAddress.getEmail());
            addField(formParams, "billing_address[company]", billingAddress.getCompany());
            addField(formParams, "billing_address[phone]", billingAddress.getPhone());
            addField(formParams, "billing_address[line1]", billingAddress.getLine1());
            addField(formParams, "billing_address[line2]", billingAddress.getLine2());
            addField(formParams, "billing_address[line3]", billingAddress.getLine3());
            addField(formParams, "billing_address[city]", billingAddress.getCity());
            addField(formParams, "billing_address[state_code]", billingAddress.getStateCode());
            addField(formParams, "billing_address[state]", billingAddress.getState());
            addField(formParams, "billing_address[zip]", billingAddress.getZip());
            addField(formParams, "billing_address[country]", billingAddress.getCountry());
            addField(formParams, "billing_address[validation_status]", billingAddress.getValidationStatus());
        }
    }

    public static void addPaymentIntent(StringBuilder formParams, PaymentIntent paymentIntent) {
        if (paymentIntent != null) {
            addField(formParams, "payment_intent[id]", paymentIntent.getId());
            addField(formParams, "payment_intent[gateway_account_id]", paymentIntent.getGatewayAccountId());
            addField(formParams, "payment_intent[gw_token]", paymentIntent.getGwToken());
            addField(formParams, "payment_intent[payment_method_type]", paymentIntent.getPaymentMethodType());
            addField(formParams, "payment_intent[reference_id]", paymentIntent.getReferenceId());
            addField(formParams, "payment_intent[additional_information]", paymentIntent.getAdditionalInformation());
        }
    }

    public static void addStatementDescriptor(StringBuilder formParams, StatementDescriptor statementDescriptor) {
        if (statementDescriptor != null) {
            addField(formParams, "statement_descriptor[descriptor]", statementDescriptor.getDescriptor());
        }
    }

    public static void addContractTerm(StringBuilder formParams, ContractTerm contractTerm) {
        if (contractTerm != null) {
            addField(formParams, "contract_term[action_at_term_end]", contractTerm.getActionAtTermEnd());
            addField(formParams, "contract_term[cancellation_cutoff_period]", contractTerm.getCancellationCutoffPeriod());
        }
    }

    public static void addBillingOverride(StringBuilder formParams, BillingOverride billingOverride) {
        if (billingOverride != null) {
            addField(formParams, "billing_override[max_excess_payment_usage]", billingOverride.getMaxExcessPaymentUsage());
            addField(formParams, "billing_override[max_refundable_credits_usage]", billingOverride.getMaxRefundableCreditsUsage());
        }
    }

    public static void addCard(StringBuilder formParams, Card card) {
        if (card != null) {
            addField(formParams, "card[gateway_account_id]", card.getGatewayAccountId());
            addField(formParams, "card[first_name]", card.getFirstName());
            addField(formParams, "card[last_name]", card.getLastName());
            addField(formParams, "card[number]", card.getNumber());
            addField(formParams, "card[expiry_month]", card.getExpiryMonth());
            addField(formParams, "card[expiry_year]", card.getExpiryYear());
            addField(formParams, "card[cvv]", card.getCvv());
            addField(formParams, "card[preferred_scheme]", card.getPreferredScheme());
        }
    }

    public static void addContact(StringBuilder formParams, Contact contact) {
        if (contact != null) {
            addField(formParams,"contact[id]",contact.getId());
            addField(formParams,"contact[first_name]",contact.getFirstName());
            addField(formParams,"contact[last_name]",contact.getLastName());
            addField(formParams, "contact[email]",contact.getEmail());
            addField(formParams, "contact[phone]", contact.getPhone());
            addField(formParams, "contact[label]", contact.getLabel());
            addField(formParams, "contact[enabled]", contact.getEnabled());
            addField(formParams, "contact[send_billing_email]",contact.getSendBillingEmail());
            addField(formParams, "contact[send_account_email]",contact.getSendAccountEmail());
        }
    }


}

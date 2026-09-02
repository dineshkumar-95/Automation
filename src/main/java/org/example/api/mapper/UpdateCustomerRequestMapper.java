package org.example.api.mapper;

import org.example.api.models.common.TaxProvidersField;
import org.example.api.models.request.UpdateCustomerApiRequest;
import org.example.api.utils.FormUrlEncoder;

public class UpdateCustomerRequestMapper {
    private UpdateCustomerRequestMapper() {
    }
    public static String toFormUrlEncoded(UpdateCustomerApiRequest request) {

        StringBuilder formParams = new StringBuilder();

        // ========== TOP-LEVEL CUSTOMER FIELDS ==========

        FormUrlEncoder.addField(formParams, "first_name", request.getFirstName());
        FormUrlEncoder.addField(formParams, "last_name", request.getLastName());
        FormUrlEncoder.addField(formParams, "email", request.getEmail());
        FormUrlEncoder.addField(formParams, "preferred_currency_code", request.getPreferredCurrencyCode());
        FormUrlEncoder.addField(formParams, "phone", request.getPhone());
        FormUrlEncoder.addField(formParams, "company", request.getCompany());
        FormUrlEncoder.addField(formParams, "auto_collection", request.getAutoCollection());
        FormUrlEncoder.addField(formParams, "net_term_days", request.getNetTermDays());
        FormUrlEncoder.addField(formParams, "allow_direct_debit", request.getAllowDirectDebit());
        FormUrlEncoder.addField(formParams, "taxability", request.getTaxability());
        FormUrlEncoder.addField(formParams, "exemption_details", request.getExemptionDetails());
        FormUrlEncoder.addField(formParams, "customer_type", request.getCustomerType());
        FormUrlEncoder.addField(formParams, "client_profile_id", request.getClientProfileId());
        FormUrlEncoder.addField(formParams, "taxjar_exemption_category", request.getTaxjarExemptionCategory());
        FormUrlEncoder.addField(formParams, "locale", request.getLocale());
        FormUrlEncoder.addField(formParams, "entity_code", request.getEntityCode());
        FormUrlEncoder.addField(formParams, "exempt_number", request.getExemptNumber());
        FormUrlEncoder.addField(formParams, "offline_payment_method", request.getOfflinePaymentMethod());
        FormUrlEncoder.addField(formParams, "invoice_notes", request.getInvoiceNotes());
        FormUrlEncoder.addField(formParams, "auto_close_invoices", request.getAutoCloseInvoices());
        FormUrlEncoder.addField(formParams, "meta_data", request.getMetaData());
        FormUrlEncoder.addField(formParams, "fraud_flag", request.getFraudFlag());
        FormUrlEncoder.addField(formParams, "consolidated_invoicing", request.getConsolidatedInvoicing());

        // ========== TAX PROVIDERS FIELDS ==========

        if (request.getTaxProvidersFields() != null) {
            for (int i = 0; i < request.getTaxProvidersFields().size(); i++) {
                TaxProvidersField field = request.getTaxProvidersFields().get(i);
                FormUrlEncoder.addIndexedField(formParams, "tax_providers_fields[provider_name]", i, field.getProviderName());
                FormUrlEncoder.addIndexedField(formParams, "tax_providers_fields[field_id]", i, field.getFieldId());
                FormUrlEncoder.addIndexedField(formParams, "tax_providers_fields[field_value]", i, field.getFieldValue());
            }
        }

        return formParams.toString();
    }

}

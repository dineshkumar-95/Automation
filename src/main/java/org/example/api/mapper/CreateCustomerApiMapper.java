package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.CreateCustomerApiRequest;
import org.example.api.utils.FormUrlEncoder;

public class CreateCustomerApiMapper {
    private CreateCustomerApiMapper() {
    }


        public static String toFormUrlEncoded(CreateCustomerApiRequest request) {

            StringBuilder formParams = new StringBuilder();

            // ========== TOP-LEVEL CUSTOMER FIELDS ==========

            FormUrlEncoder.addField(formParams, "id", request.getId());
            FormUrlEncoder.addField(formParams, "first_name", request.getFirstName());
            FormUrlEncoder.addField(formParams, "last_name", request.getLastName());
            FormUrlEncoder.addField(formParams, "email", request.getEmail());
            FormUrlEncoder.addField(formParams, "preferred_currency_code", request.getPreferredCurrencyCode());
            FormUrlEncoder.addField(formParams, "phone", request.getPhone());
            FormUrlEncoder.addField(formParams, "company", request.getCompany());
            FormUrlEncoder.addField(formParams, "auto_collection", request.getAutoCollection());
            FormUrlEncoder.addField(formParams, "net_term_days", request.getNetTermDays());
            FormUrlEncoder.addField(formParams, "allow_direct_debit", request.getAllowDirectDebit());
            FormUrlEncoder.addField(formParams, "vat_number", request.getVatNumber());
            FormUrlEncoder.addField(formParams, "vat_number_prefix", request.getVatNumberPrefix());
            FormUrlEncoder.addField(formParams, "entity_identifier_scheme", request.getEntityIdentifierScheme());
            FormUrlEncoder.addField(formParams, "entity_identifier_standard", request.getEntityIdentifierStandard());
            FormUrlEncoder.addField(formParams, "registered_for_gst", request.getRegisteredForGst());
            FormUrlEncoder.addField(formParams, "is_einvoice_enabled", request.getIsEinvoiceEnabled());
            FormUrlEncoder.addField(formParams, "einvoicing_method", request.getEinvoicingMethod());
            FormUrlEncoder.addField(formParams, "taxability", request.getTaxability());
            FormUrlEncoder.addField(formParams, "exemption_details", request.getExemptionDetails());
            FormUrlEncoder.addField(formParams, "customer_type", request.getCustomerType());
            FormUrlEncoder.addField(formParams, "client_profile_id", request.getClientProfileId());
            FormUrlEncoder.addField(formParams, "taxjar_exemption_category", request.getTaxjarExemptionCategory());
            FormUrlEncoder.addField(formParams, "business_customer_without_vat_number", request.getBusinessCustomerWithoutVatNumber());
            FormUrlEncoder.addField(formParams, "locale", request.getLocale());
            FormUrlEncoder.addField(formParams, "entity_code", request.getEntityCode());
            FormUrlEncoder.addField(formParams, "exempt_number", request.getExemptNumber());
            FormUrlEncoder.addField(formParams, "meta_data", request.getMetaData());
            FormUrlEncoder.addField(formParams, "offline_payment_method", request.getOfflinePaymentMethod());
            FormUrlEncoder.addField(formParams, "auto_close_invoices", request.getAutoCloseInvoices());
            FormUrlEncoder.addField(formParams, "consolidated_invoicing", request.getConsolidatedInvoicing());
            FormUrlEncoder.addField(formParams, "token_id", request.getTokenId());
            FormUrlEncoder.addField(formParams, "business_entity_id", request.getBusinessEntityId());
            FormUrlEncoder.addField(formParams, "invoice_notes", request.getInvoiceNotes());

            // ========== COMMON NESTED / LIST SECTIONS ==========

            ChargebeeFormMapper.addBillingAddress(formParams, request.getBillingAddress());
            ChargebeeFormMapper.addCard(formParams, request.getCard());
            ChargebeeFormMapper.addEntityIdentifiers(formParams, request.getEntityIdentifiers());
            ChargebeeFormMapper.addTaxProvidersFields(formParams, request.getTaxProvidersFields());

            return formParams.toString();
        }

}

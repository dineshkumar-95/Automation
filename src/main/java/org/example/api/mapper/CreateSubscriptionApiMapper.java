package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFormMapper;
import org.example.api.models.request.CreateSubscriptionApiRequest;
import org.example.api.utils.FormUrlEncoder;

public class CreateSubscriptionApiMapper {

    private CreateSubscriptionApiMapper() {
    }

    public static String toFormUrlEncoded(CreateSubscriptionApiRequest request) {

        StringBuilder formParams = new StringBuilder();

        // ========== TOP-LEVEL SUBSCRIPTION FIELDS ==========

        FormUrlEncoder.addField(formParams, "id", request.getId());
        FormUrlEncoder.addField(formParams, "business_entity_id", request.getBusinessEntityId());
        FormUrlEncoder.addField(formParams, "trial_end", request.getTrialEnd());
        FormUrlEncoder.addField(formParams, "billing_cycles", request.getBillingCycles());
        FormUrlEncoder.addField(formParams, "mandatory_items_to_remove", request.getMandatoryItemsToRemove());
        FormUrlEncoder.addField(formParams, "net_term_days", request.getNetTermDays());
        FormUrlEncoder.addField(formParams, "start_date", request.getStartDate());
        FormUrlEncoder.addField(formParams, "auto_collection", request.getAutoCollection());
        FormUrlEncoder.addField(formParams, "terms_to_charge", request.getTermsToCharge());
        FormUrlEncoder.addField(formParams, "billing_alignment_mode", request.getBillingAlignmentMode());
        FormUrlEncoder.addField(formParams, "offline_payment_method", request.getOfflinePaymentMethod());
        FormUrlEncoder.addField(formParams, "po_number", request.getPoNumber());
        FormUrlEncoder.addField(formParams, "coupon_ids", request.getCouponIds());
        FormUrlEncoder.addField(formParams, "payment_source_id", request.getPaymentSourceId());
        FormUrlEncoder.addField(formParams, "override_relationship", request.getOverrideRelationship());
        FormUrlEncoder.addField(formParams, "invoice_notes", request.getInvoiceNotes());
        FormUrlEncoder.addField(formParams, "invoice_date", request.getInvoiceDate());
        FormUrlEncoder.addField(formParams, "meta_data", request.getMetaData());
        FormUrlEncoder.addField(formParams, "invoice_immediately", request.getInvoiceImmediately());
        FormUrlEncoder.addField(formParams, "replace_primary_payment_source", request.getReplacePrimaryPaymentSource());
        FormUrlEncoder.addField(formParams, "free_period", request.getFreePeriod());
        FormUrlEncoder.addField(formParams, "free_period_unit", request.getFreePeriodUnit());
        FormUrlEncoder.addField(formParams, "contract_term_billing_cycle_on_renewal", request.getContractTermBillingCycleOnRenewal());
        FormUrlEncoder.addField(formParams, "create_pending_invoices", request.getCreatePendingInvoices());
        FormUrlEncoder.addField(formParams, "auto_close_invoices", request.getAutoCloseInvoices());
        FormUrlEncoder.addField(formParams, "first_invoice_pending", request.getFirstInvoicePending());
        FormUrlEncoder.addField(formParams, "trial_end_action", request.getTrialEndAction());
        FormUrlEncoder.addField(formParams, "payment_initiator", request.getPaymentInitiator());

        // ========== COMMON NESTED / LIST SECTIONS ==========

        ChargebeeFormMapper.addSubscriptionItems(formParams, request.getSubscriptionItems());
        ChargebeeFormMapper.addDiscounts(formParams, request.getDiscounts());
        ChargebeeFormMapper.addItemTiers(formParams, request.getItemTiers());
        ChargebeeFormMapper.addShippingAddress(formParams, request.getShippingAddress());
        ChargebeeFormMapper.addStatementDescriptor(formParams, request.getStatementDescriptor());
        ChargebeeFormMapper.addPaymentIntent(formParams, request.getPaymentIntent());
        ChargebeeFormMapper.addContractTerm(formParams, request.getContractTerm());
        ChargebeeFormMapper.addBillingOverride(formParams, request.getBillingOverride());

        return formParams.toString();
    }
}

package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Tax Provider Fields parameters.
 * Used by CreateCustomerApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxProvidersField {

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("field_id")
    private String fieldId;

    @JsonProperty("field_value")
    private String fieldValue;

    public String getProviderName() { return providerName; }
    public TaxProvidersField setProviderName(String providerName) { this.providerName = providerName; return this; }

    public String getFieldId() { return fieldId; }
    public TaxProvidersField setFieldId(String fieldId) { this.fieldId = fieldId; return this; }

    public String getFieldValue() { return fieldValue; }
    public TaxProvidersField setFieldValue(String fieldValue) { this.fieldValue = fieldValue; return this; }
}
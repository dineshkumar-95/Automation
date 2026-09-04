package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Statement Descriptor parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementDescriptor {

    @JsonProperty("descriptor")
    private String descriptor;

    public String getDescriptor() {
        return descriptor;
    }

    public StatementDescriptor setDescriptor(String descriptor) {
        this.descriptor = descriptor;
        return this;
    }
}
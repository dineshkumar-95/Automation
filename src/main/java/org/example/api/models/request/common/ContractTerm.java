package org.example.api.models.request.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common class representing Contract Term parameters.
 * Used by CreateSubscriptionApiRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractTerm {

    @JsonProperty("action_at_term_end")
    private String actionAtTermEnd;

    @JsonProperty("cancellation_cutoff_period")
    private Integer cancellationCutoffPeriod;

    public String getActionAtTermEnd() {
        return actionAtTermEnd;
    }

    public ContractTerm setActionAtTermEnd(String actionAtTermEnd) {
        this.actionAtTermEnd = actionAtTermEnd;
        return this;
    }

    public Integer getCancellationCutoffPeriod() {
        return cancellationCutoffPeriod;
    }

    public ContractTerm setCancellationCutoffPeriod(Integer cancellationCutoffPeriod) {
        this.cancellationCutoffPeriod = cancellationCutoffPeriod;
        return this;
    }
}
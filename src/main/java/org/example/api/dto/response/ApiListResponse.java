package org.example.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.model.common.Card;
import org.example.api.model.customer.Customer;
import org.example.api.model.subscription.Subscription;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic Chargebee API list response envelope.
 * The "list" array contains ApiResponse items (each may have customer, subscription, card, etc.).
 * Replaces ChargebeeListResponse, Customers, Subscriptions, Cards wrapper classes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiListResponse {

    @JsonProperty("list")
    private List<ApiResponse> list;

    @JsonProperty("next_offset")
    private String nextOffset;

    public List<ApiResponse> getList() {
        return list != null ? list : Collections.emptyList();
    }

    public ApiListResponse setList(List<ApiResponse> list) {
        this.list = list;
        return this;
    }

    public String getNextOffset() { return nextOffset; }
    public ApiListResponse setNextOffset(String nextOffset) { this.nextOffset = nextOffset; return this; }

    // ─── Convenience extraction methods ───────────────────────────────────────

    /** Returns all Customer objects from this list response. */
    public List<Customer> getCustomers() {
        return getList().stream()
                .map(ApiResponse::getCustomer)
                .filter(c -> c != null)
                .collect(Collectors.toList());
    }

    /** Returns all Subscription objects from this list response. */
    public List<Subscription> getSubscriptions() {
        return getList().stream()
                .map(ApiResponse::getSubscription)
                .filter(s -> s != null)
                .collect(Collectors.toList());
    }

    /** Returns all Card objects from this list response. */
    public List<Card> getCards() {
        return getList().stream()
                .map(ApiResponse::getCard)
                .filter(c -> c != null)
                .collect(Collectors.toList());
    }

    /** Returns the first ApiResponse item, or null if the list is empty. */
    public ApiResponse first() {
        List<ApiResponse> items = getList();
        return items.isEmpty() ? null : items.get(0);
    }

    public int size() {
        return list != null ? list.size() : 0;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}

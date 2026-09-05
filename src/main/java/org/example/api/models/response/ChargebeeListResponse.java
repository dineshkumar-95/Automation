package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.Card;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargebeeListResponse {

    @JsonProperty("list")
    private List<ChargebeeResponse> list;

    @JsonProperty("next_offset")
    private String nextOffset;

    public List<ChargebeeResponse> getList() {
        return list;
    }

    public ChargebeeListResponse setList(List<ChargebeeResponse> list) {
        this.list = list;
        return this;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public ChargebeeListResponse setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
        return this;
    }

    // Convenience methods to extract specific entity types from the list
    public Customers getCustomers() {
        if (list == null) {
            return new Customers();
        }
        List<Customer> customerList = list.stream()
                .map(ChargebeeResponse::getCustomer)
                .filter(customer -> customer != null)
                .collect(Collectors.toList());
        return new Customers().setList(customerList);
    }

    public Cards getCards() {
        if (list == null) {
            return new Cards();
        }
        List<Card> cardList = list.stream()
                .map(ChargebeeResponse::getCard)
                .filter(card -> card != null)
                .collect(Collectors.toList());
        return new Cards().setList(cardList);
    }

    public Subscriptions getSubscriptions() {
        if (list == null) {
            return new Subscriptions();
        }
        List<Subscription> subscriptionList = list.stream()
                .map(ChargebeeResponse::getSubscription)
                .filter(subscription -> subscription != null)
                .collect(Collectors.toList());
        return new Subscriptions().setList(subscriptionList);
    }
}
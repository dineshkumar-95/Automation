package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.Card;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customers {

    @JsonProperty("list")
    private List<CustomerEntry> list;

    @JsonProperty("next_offset")
    private String nextOffset;

    public List<CustomerEntry> getList() { return list; }
    public Customers setList(List<CustomerEntry> list) { this.list = list; return this; }

    public String getNextOffset() { return nextOffset; }
    public Customers setNextOffset(String nextOffset) { this.nextOffset = nextOffset; return this; }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CustomerEntry {

        @JsonProperty("customer")
        private Customer customer;

        @JsonProperty("card")
        private Card card;

        public Customer getCustomer() { return customer; }
        public CustomerEntry setCustomer(Customer customer) { this.customer = customer; return this; }

        public Card getCard() { return card; }
        public CustomerEntry setCard(Card card) { this.card = card; return this; }
    }
}

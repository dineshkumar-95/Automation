package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.common.Card;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cards {

    @JsonProperty("list")
    private List<Card> list;

    public List<Card> getList() {
        return list != null ? list : Collections.emptyList();
    }

    public Cards setList(List<Card> list) {
        this.list = list;
        return this;
    }

    // Convenience methods
    public int size() {
        return list != null ? list.size() : 0;
    }

    public Card get(int index) {
        return list != null && index >= 0 && index < list.size() ? list.get(index) : null;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}
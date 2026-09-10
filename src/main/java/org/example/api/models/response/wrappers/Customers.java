package org.example.api.models.response.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.response.Customer;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customers {

    @JsonProperty("list")
    private List<Customer> list;

    public List<Customer> getList() {
        return list != null ? list : Collections.emptyList();
    }

    public Customers setList(List<Customer> list) {
        this.list = list;
        return this;
    }

    // Convenience methods
    public int size() {
        return list != null ? list.size() : 0;
    }

    public Customer get(int index) {
        return list != null && index >= 0 && index < list.size() ? list.get(index) : null;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}
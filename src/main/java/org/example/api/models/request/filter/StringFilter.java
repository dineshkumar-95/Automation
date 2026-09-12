package org.example.api.models.request.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/**
 * Generic Filter POJO for String properties in Chargebee List APIs.
 * Supports fluent parent chaining (returns parent P).
 * Supports operators: is, is_not, starts_with, in, not_in, is_present.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringFilter<P> {

    private final P parent;

    @JsonProperty("is")
    private String is;

    @JsonProperty("is_not")
    private String isNot;

    @JsonProperty("starts_with")
    private String startsWith;

    @JsonProperty("in")
    private List<String> in;

    @JsonProperty("not_in")
    private List<String> notIn;

    @JsonProperty("is_present")
    private Boolean isPresent;

    @SuppressWarnings("unchecked")
    public StringFilter() {
        this.parent = (P) this;
    }

    public StringFilter(P parent) {
        this.parent = parent != null ? parent : (P) this;
    }

    // Fluent Parent-Chaining Setters
    public P is(String value) {
        this.is = value;
        return parent;
    }

    public P isNot(String value) {
        this.isNot = value;
        return parent;
    }

    public P startsWith(String prefix) {
        this.startsWith = prefix;
        return parent;
    }

    public P in(String... values) {
        this.in = Arrays.asList(values);
        return parent;
    }

    public P in(List<String> values) {
        this.in = values;
        return parent;
    }

    public P notIn(String... values) {
        this.notIn = Arrays.asList(values);
        return parent;
    }

    public P isPresent(Boolean isPresent) {
        this.isPresent = isPresent;
        return parent;
    }

    // Getters for Mapper
    public String getIs() {
        return is;
    }

    public String getIsNot() {
        return isNot;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public List<String> getIn() {
        return in;
    }

    public List<String> getNotIn() {
        return notIn;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }
}

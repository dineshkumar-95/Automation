package org.example.api.models.request.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/**
 * Generic Filter POJO for Numeric/Amount properties in Chargebee List APIs.
 * Supports fluent parent chaining (returns parent P).
 * Supports operators: is, is_not, gt, gte, lt, lte, between.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberFilter<T extends Number, P> {

    private final P parent;

    @JsonProperty("is")
    private T is;

    @JsonProperty("is_not")
    private T isNot;

    @JsonProperty("gt")
    private T gt;

    @JsonProperty("gte")
    private T gte;

    @JsonProperty("lt")
    private T lt;

    @JsonProperty("lte")
    private T lte;

    @JsonProperty("between")
    private List<T> between;


    public NumberFilter(P parent) {
        this.parent = parent;
    }

    // Fluent Parent-Chaining Setters
    public P is(T is) {
        this.is = is;
        return parent;
    }

    public P isNot(T isNot) {
        this.isNot = isNot;
        return parent;
    }

    public P gt(T gt) {
        this.gt = gt;
        return parent;
    }

    public P gte(T gte) {
        this.gte = gte;
        return parent;
    }

    public P lt(T lt) {
        this.lt = lt;
        return parent;
    }

    public P lte(T lte) {
        this.lte = lte;
        return parent;
    }

    public P between(T min, T max) {
        this.between = Arrays.asList(min, max);
        return parent;
    }

    // Getters for Mapper
    public T getIs() {
        return is;
    }

    public T getIsNot() {
        return isNot;
    }

    public T getGt() {
        return gt;
    }

    public T getGte() {
        return gte;
    }

    public T getLt() {
        return lt;
    }

    public T getLte() {
        return lte;
    }

    public List<T> getBetween() {
        return between;
    }
}

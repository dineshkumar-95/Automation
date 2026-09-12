package org.example.api.models.request.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/**
 * Generic Filter POJO for Timestamp/Date properties in Chargebee List APIs.
 * Supports fluent parent chaining (returns parent P).
 * Supports operators: after, before, on, between, is_present.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimestampFilter<P> {

    private final P parent;

    @JsonProperty("after")
    private Long after;

    @JsonProperty("before")
    private Long before;

    @JsonProperty("on")
    private Long on;

    @JsonProperty("between")
    private List<Long> between;

    @JsonProperty("is_present")
    private Boolean isPresent;

    @SuppressWarnings("unchecked")
    public TimestampFilter() {
        this.parent = (P) this;
    }

    public TimestampFilter(P parent) {
        this.parent = parent != null ? parent : (P) this;
    }

    // Fluent Parent-Chaining Setters
    public P after(Long epochSeconds) {
        this.after = epochSeconds;
        return parent;
    }

    public P before(Long epochSeconds) {
        this.before = epochSeconds;
        return parent;
    }

    public P on(Long epochSeconds) {
        this.on = epochSeconds;
        return parent;
    }

    public P between(Long startEpochSeconds, Long endEpochSeconds) {
        this.between = Arrays.asList(startEpochSeconds, endEpochSeconds);
        return parent;
    }

    public P isPresent(Boolean isPresent) {
        this.isPresent = isPresent;
        return parent;
    }

    // Getters for Mapper
    public Long getAfter() {
        return after;
    }

    public Long getBefore() {
        return before;
    }

    public Long getOn() {
        return on;
    }

    public List<Long> getBetween() {
        return between;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }
}

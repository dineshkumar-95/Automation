package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.request.filter.StringFilter;
import org.example.api.models.request.filter.TimestampFilter;

/**
 * Model class for Chargebee List Customers API Request.
 * Supports exact parameters accepted by List Customers endpoint with fluent sub-builders.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListCustomersRequest {

    // Base Pagination & Sorting fields for List Customers API
    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("offset")
    private String offset;

    @JsonProperty("include_deleted")
    private Boolean includeDeleted;

    @JsonProperty("sort_by[asc]")
    private String sortByAsc;

    @JsonProperty("sort_by[desc]")
    private String sortByDesc;

    // Filter fields
    @JsonProperty("id")
    private StringFilter<ListCustomersRequest> id;

    @JsonProperty("first_name")
    private StringFilter<ListCustomersRequest> firstName;

    @JsonProperty("last_name")
    private StringFilter<ListCustomersRequest> lastName;

    @JsonProperty("email")
    private StringFilter<ListCustomersRequest> email;

    @JsonProperty("company")
    private StringFilter<ListCustomersRequest> company;

    @JsonProperty("phone")
    private StringFilter<ListCustomersRequest> phone;

    @JsonProperty("auto_collection")
    private StringFilter<ListCustomersRequest> autoCollection;

    @JsonProperty("taxability")
    private StringFilter<ListCustomersRequest> taxability;

    @JsonProperty("created_at")
    private TimestampFilter<ListCustomersRequest> createdAt;

    @JsonProperty("updated_at")
    private TimestampFilter<ListCustomersRequest> updatedAt;

    public ListCustomersRequest() {
    }

    // Fluent Setters for Base Pagination & Sorting
    public ListCustomersRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListCustomersRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListCustomersRequest offset(String offset) {
        this.offset = offset;
        return this;
    }

    public ListCustomersRequest setOffset(String offset) {
        this.offset = offset;
        return this;
    }

    public ListCustomersRequest includeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
        return this;
    }

    public ListCustomersRequest setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
        return this;
    }

    public ListCustomersRequest sortByAsc(String sortByAsc) {
        this.sortByAsc = sortByAsc;
        return this;
    }

    public ListCustomersRequest setSortByAsc(String sortByAsc) {
        this.sortByAsc = sortByAsc;
        return this;
    }

    public ListCustomersRequest sortByDesc(String sortByDesc) {
        this.sortByDesc = sortByDesc;
        return this;
    }

    public ListCustomersRequest setSortByDesc(String sortByDesc) {
        this.sortByDesc = sortByDesc;
        return this;
    }

    // Fluent Sub-Builder Entry Methods (Returns Sub-Builder with 'this' as parent)
    public StringFilter<ListCustomersRequest> id() {
        if (this.id == null) {
            this.id = new StringFilter<>(this);
        }
        return this.id;
    }

    public StringFilter<ListCustomersRequest> firstName() {
        if (this.firstName == null) {
            this.firstName = new StringFilter<>(this);
        }
        return this.firstName;
    }

    public StringFilter<ListCustomersRequest> lastName() {
        if (this.lastName == null) {
            this.lastName = new StringFilter<>(this);
        }
        return this.lastName;
    }

    public StringFilter<ListCustomersRequest> email() {
        if (this.email == null) {
            this.email = new StringFilter<>(this);
        }
        return this.email;
    }

    public StringFilter<ListCustomersRequest> company() {
        if (this.company == null) {
            this.company = new StringFilter<>(this);
        }
        return this.company;
    }

    public StringFilter<ListCustomersRequest> phone() {
        if (this.phone == null) {
            this.phone = new StringFilter<>(this);
        }
        return this.phone;
    }

    public StringFilter<ListCustomersRequest> autoCollection() {
        if (this.autoCollection == null) {
            this.autoCollection = new StringFilter<>(this);
        }
        return this.autoCollection;
    }

    public StringFilter<ListCustomersRequest> taxability() {
        if (this.taxability == null) {
            this.taxability = new StringFilter<>(this);
        }
        return this.taxability;
    }

    public TimestampFilter<ListCustomersRequest> createdAt() {
        if (this.createdAt == null) {
            this.createdAt = new TimestampFilter<>(this);
        }
        return this.createdAt;
    }

    public TimestampFilter<ListCustomersRequest> updatedAt() {
        if (this.updatedAt == null) {
            this.updatedAt = new TimestampFilter<>(this);
        }
        return this.updatedAt;
    }

    // Standard Getters for Mapper / Jackson
    public Integer getLimit() {
        return limit;
    }

    public String getOffset() {
        return offset;
    }

    public Boolean getIncludeDeleted() {
        return includeDeleted;
    }

    public String getSortByAsc() {
        return sortByAsc;
    }

    public String getSortByDesc() {
        return sortByDesc;
    }

    public StringFilter<ListCustomersRequest> getId() {
        return id;
    }

    public StringFilter<ListCustomersRequest> getFirstName() {
        return firstName;
    }

    public StringFilter<ListCustomersRequest> getLastName() {
        return lastName;
    }

    public StringFilter<ListCustomersRequest> getEmail() {
        return email;
    }

    public StringFilter<ListCustomersRequest> getCompany() {
        return company;
    }

    public StringFilter<ListCustomersRequest> getPhone() {
        return phone;
    }

    public StringFilter<ListCustomersRequest> getAutoCollection() {
        return autoCollection;
    }

    public StringFilter<ListCustomersRequest> getTaxability() {
        return taxability;
    }

    public TimestampFilter<ListCustomersRequest> getCreatedAt() {
        return createdAt;
    }

    public TimestampFilter<ListCustomersRequest> getUpdatedAt() {
        return updatedAt;
    }
}

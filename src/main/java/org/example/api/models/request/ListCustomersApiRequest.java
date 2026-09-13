package org.example.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.models.request.filter.Sort;
import org.example.api.models.request.filter.StringFilter;
import org.example.api.models.request.filter.TimestampFilter;

/**
 * Model class for Chargebee List Customers API Request.
 * Supports exact parameters accepted by List Customers endpoint with fluent sub-builders.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListCustomersApiRequest {

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

    @JsonProperty("sort_by")
    private Sort<ListCustomersApiRequest> sortBy;


    public Sort<ListCustomersApiRequest> getSortBy() {
        return sortBy;
    }

    public Sort<ListCustomersApiRequest> setSortBy() {
        this.sortBy = new Sort<>(this);
        return this.sortBy;
    }


    // Filter fields
    @JsonProperty("id")
    private StringFilter<ListCustomersApiRequest> id;

    @JsonProperty("first_name")
    private StringFilter<ListCustomersApiRequest> firstName;

    @JsonProperty("last_name")
    private StringFilter<ListCustomersApiRequest> lastName;

    @JsonProperty("email")
    private StringFilter<ListCustomersApiRequest> email;

    @JsonProperty("company")
    private StringFilter<ListCustomersApiRequest> company;

    @JsonProperty("phone")
    private StringFilter<ListCustomersApiRequest> phone;

    @JsonProperty("auto_collection")
    private StringFilter<ListCustomersApiRequest> autoCollection;

    @JsonProperty("taxability")
    private StringFilter<ListCustomersApiRequest> taxability;

    @JsonProperty("created_at")
    private TimestampFilter<ListCustomersApiRequest> createdAt;

    @JsonProperty("updated_at")
    private TimestampFilter<ListCustomersApiRequest> updatedAt;

    public ListCustomersApiRequest() {
    }

    // Fluent Setters for Base Pagination & Sorting

    public ListCustomersApiRequest setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public ListCustomersApiRequest setOffset(String offset) {
        this.offset = offset;
        return this;
    }

    public ListCustomersApiRequest setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
        return this;
    }

    public ListCustomersApiRequest setSortByAsc(String sortByAsc) {
        this.sortByAsc = sortByAsc;
        return this;
    }

    public ListCustomersApiRequest setSortByDesc(String sortByDesc) {
        this.sortByDesc = sortByDesc;
        return this;
    }

    // Fluent Sub-Builder Entry Methods (Returns Sub-Builder with 'this' as parent)
    public StringFilter<ListCustomersApiRequest> setId() {
        if (this.id == null) {
            this.id = new StringFilter<>(this);
        }
        return this.id;
    }

    public StringFilter<ListCustomersApiRequest> setFirstName() {
        if (this.firstName == null) {
            this.firstName = new StringFilter<>(this);
        }
        return this.firstName;
    }

    public StringFilter<ListCustomersApiRequest> setLastName() {
        if (this.lastName == null) {
            this.lastName = new StringFilter<>(this);
        }
        return this.lastName;
    }

    public StringFilter<ListCustomersApiRequest> setEmail() {
        if (this.email == null) {
            this.email = new StringFilter<>(this);
        }
        return this.email;
    }

    public StringFilter<ListCustomersApiRequest> setCompany() {
        if (this.company == null) {
            this.company = new StringFilter<>(this);
        }
        return this.company;
    }

    public StringFilter<ListCustomersApiRequest> setPhone() {
        if (this.phone == null) {
            this.phone = new StringFilter<>(this);
        }
        return this.phone;
    }

    public StringFilter<ListCustomersApiRequest> seAutoCollection() {
        if (this.autoCollection == null) {
            this.autoCollection = new StringFilter<>(this);
        }
        return this.autoCollection;
    }

    public StringFilter<ListCustomersApiRequest> setTaxability() {
        if (this.taxability == null) {
            this.taxability = new StringFilter<>(this);
        }
        return this.taxability;
    }

    public TimestampFilter<ListCustomersApiRequest> setCreatedAt() {
        if (this.createdAt == null) {
            this.createdAt = new TimestampFilter<>(this);
        }
        return this.createdAt;
    }

    public TimestampFilter<ListCustomersApiRequest> setUpdatedAt() {
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

    public StringFilter<ListCustomersApiRequest> getId() {
        return id;
    }

    public StringFilter<ListCustomersApiRequest> getFirstName() {
        return firstName;
    }

    public StringFilter<ListCustomersApiRequest> getLastName() {
        return lastName;
    }

    public StringFilter<ListCustomersApiRequest> getEmail() {
        return email;
    }

    public StringFilter<ListCustomersApiRequest> getCompany() {
        return company;
    }

    public StringFilter<ListCustomersApiRequest> getPhone() {
        return phone;
    }

    public StringFilter<ListCustomersApiRequest> getAutoCollection() {
        return autoCollection;
    }

    public StringFilter<ListCustomersApiRequest> getTaxability() {
        return taxability;
    }

    public TimestampFilter<ListCustomersApiRequest> getCreatedAt() {
        return createdAt;
    }

    public TimestampFilter<ListCustomersApiRequest> getUpdatedAt() {
        return updatedAt;
    }
}

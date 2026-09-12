package org.example.api.mapper;

import org.example.api.mapper.common.ChargebeeFilterMapper;
import org.example.api.models.request.ListCustomersApiRequest;
import org.example.api.utils.QueryParamUtils;

import java.util.HashMap;
import java.util.Map;

public class ListCustomersApiMapper {

    private ListCustomersApiMapper() {
    }

    /**
     * Converts ListCustomersRequest object into a Map of query parameters suitable for RestAssured queryParams()
     */
    public static Map<String, Object> toQueryParams(ListCustomersApiRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request == null) {
            return params;
        }

        // Base Pagination & Sorting
        QueryParamUtils.addParam(params, "limit", request.getLimit());
        QueryParamUtils.addParam(params, "offset", request.getOffset());
        QueryParamUtils.addParam(params, "include_deleted", request.getIncludeDeleted());
        QueryParamUtils.addParam(params, "sort_by[asc]", request.getSortByAsc());
        QueryParamUtils.addParam(params, "sort_by[desc]", request.getSortByDesc());

        // Customer Specific String Filters
        ChargebeeFilterMapper.appendStringFilter(params, "id", request.getId());
        ChargebeeFilterMapper.appendStringFilter(params, "first_name", request.getFirstName());
        ChargebeeFilterMapper.appendStringFilter(params, "last_name", request.getLastName());
        ChargebeeFilterMapper.appendStringFilter(params, "email", request.getEmail());
        ChargebeeFilterMapper.appendStringFilter(params, "company", request.getCompany());
        ChargebeeFilterMapper.appendStringFilter(params, "phone", request.getPhone());
        ChargebeeFilterMapper.appendStringFilter(params, "auto_collection", request.getAutoCollection());
        ChargebeeFilterMapper.appendStringFilter(params, "taxability", request.getTaxability());

        // Timestamp Filters
        ChargebeeFilterMapper.appendTimestampFilter(params, "created_at", request.getCreatedAt());
        ChargebeeFilterMapper.appendTimestampFilter(params, "updated_at", request.getUpdatedAt());

        return params;
    }
}

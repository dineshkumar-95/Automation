package org.example.api.mapper.common;

import org.example.api.models.request.filter.NumberFilter;
import org.example.api.models.request.filter.Sort;
import org.example.api.models.request.filter.StringFilter;
import org.example.api.models.request.filter.TimestampFilter;
import org.example.api.utils.QueryParamUtils;

import java.util.Map;

/**
 * Reusable helper class for mapping Chargebee List API filter parameters.
 * Delegates query parameter map population to QueryParamUtils.
 */
public class ChargebeeFilterMapper {

    private ChargebeeFilterMapper() {
    }


    /**
     * Serializes String filter operators (is, is_not, starts_with, in, not_in, is_present).
     */
    public static void appendSorting(Map<String, Object> params, String paramName, Sort<?> filter) {
        if (filter == null) return;
        QueryParamUtils.addParam(params, paramName + "[asc]", filter.getAsc());
        QueryParamUtils.addParam(params, paramName + "[desc]", filter.getDesc());
    }

    /**
     * Serializes String filter operators (is, is_not, starts_with, in, not_in, is_present).
     */
    public static void appendStringFilter(Map<String, Object> params, String paramName, StringFilter<?> filter) {
        if (filter == null) return;
        QueryParamUtils.addParam(params, paramName + "[is]", filter.getIs());
        QueryParamUtils.addParam(params, paramName + "[is_not]", filter.getIsNot());
        QueryParamUtils.addParam(params, paramName + "[starts_with]", filter.getStartsWith());
        QueryParamUtils.addParam(params, paramName + "[is_present]", filter.getIsPresent());

        if (filter.getIn() != null && !filter.getIn().isEmpty()) {
            QueryParamUtils.addParam(params, paramName + "[in]", filter.getIn().toString());
        }
        if (filter.getNotIn() != null && !filter.getNotIn().isEmpty()) {
            QueryParamUtils.addParam(params, paramName + "[not_in]", filter.getNotIn().toString());
        }
    }

    /**
     * Serializes Timestamp/Date filter operators (after, before, on, between, is_present).
     */
    public static void appendTimestampFilter(Map<String, Object> params, String paramName, TimestampFilter<?> filter) {
        if (filter == null) return;
        QueryParamUtils.addParam(params, paramName + "[after]", filter.getAfter());
        QueryParamUtils.addParam(params, paramName + "[before]", filter.getBefore());
        QueryParamUtils.addParam(params, paramName + "[on]", filter.getOn());
        QueryParamUtils.addParam(params, paramName + "[is_present]", filter.getIsPresent());

        if (filter.getBetween() != null && filter.getBetween().size() == 2) {
            QueryParamUtils.addParam(params, paramName + "[between]", filter.getBetween().toString());
        }
    }

    /**
     * Serializes Numeric/Amount filter operators (is, is_not, gt, gte, lt, lte, between).
     */
    public static void appendNumberFilter(Map<String, Object> params, String paramName, NumberFilter<?, ?> filter) {
        if (filter == null) return;
        QueryParamUtils.addParam(params, paramName + "[is]", filter.getIs());
        QueryParamUtils.addParam(params, paramName + "[is_not]", filter.getIsNot());
        QueryParamUtils.addParam(params, paramName + "[gt]", filter.getGt());
        QueryParamUtils.addParam(params, paramName + "[gte]", filter.getGte());
        QueryParamUtils.addParam(params, paramName + "[lt]", filter.getLt());
        QueryParamUtils.addParam(params, paramName + "[lte]", filter.getLte());

        if (filter.getBetween() != null && filter.getBetween().size() == 2) {
            QueryParamUtils.addParam(params, paramName + "[between]", filter.getBetween().toString());
        }
    }
}

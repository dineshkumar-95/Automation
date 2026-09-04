package org.example.api.utils;

public class FormUrlEncoder {

    public static void addField(StringBuilder formParams, String fieldName, Object value) {
        if (value != null) {
            if (formParams.length() > 0) {
                formParams.append("&");
            }
            formParams.append(fieldName).append("=").append(value);
        }
    }

    public static void addIndexedField(StringBuilder formParams, String fieldName, int index, Object value) {
        if (value != null) {
            if (formParams.length() > 0) {
                formParams.append("&");
            }
            formParams.append(fieldName).append("[").append(index).append("]=").append(value);
        }
    }
}

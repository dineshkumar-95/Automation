package org.example.api.models.request.filter;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sort<P> {

    private final P parent;

    public Sort(P parent) {
        this.parent = parent;
    }

    private String asc;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public P setDesc(String value) {
        this.desc = value;
        return parent;
    }

    public String getAsc() {
        return asc;
    }

    public P setAsc(String value) {
        this.asc = value;
        return parent;
    }



}

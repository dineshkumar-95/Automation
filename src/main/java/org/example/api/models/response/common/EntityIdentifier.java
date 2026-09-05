package org.example.api.models.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityIdentifier {

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("standard")
    private String standard;

    public String getId() { return id; }
    public EntityIdentifier setId(String id) { this.id = id; return this; }

    public String getValue() { return value; }
    public EntityIdentifier setValue(String value) { this.value = value; return this; }

    public String getScheme() { return scheme; }
    public EntityIdentifier setScheme(String scheme) { this.scheme = scheme; return this; }

    public String getStandard() { return standard; }
    public EntityIdentifier setStandard(String standard) { this.standard = standard; return this; }
}

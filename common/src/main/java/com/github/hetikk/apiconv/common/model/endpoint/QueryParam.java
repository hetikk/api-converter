package com.github.hetikk.apiconv.common.model.endpoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryParam {

    private String name;
    private String value;
    private String description;
    private Boolean required;
    private Boolean deprecated;

}

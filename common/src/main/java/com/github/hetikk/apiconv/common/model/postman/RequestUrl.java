package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestUrl {

    private String raw;

    private String protocol;

    private List<String> host;

    private String port;

    private List<String> path;

    @JsonProperty("query")
    private List<RequestUrlQuery> queries;

    @JsonProperty("variable")
    private List<RequestUrlVariable> variables;

}

package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Request {

    public enum Method {
        GET, POST, PUT, PATCH, DELETE
    }

    private Auth auth;

    private Method method;

    @JsonProperty("header")
    private List<Header> headers;

    private Body body;

    private RequestUrl url;

}

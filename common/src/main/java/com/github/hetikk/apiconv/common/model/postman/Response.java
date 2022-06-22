package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response {

    private String name;

    private Request originalRequest;

    private String status;

    private int code;

    @JsonProperty("_postman_previewlanguage")
    private String postmanPreviewLanguage;

    @JsonProperty("header")
    private List<Header> headers;

    @JsonProperty("cookie")
    private List<Object> cookies;

    private String body;

}

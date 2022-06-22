package com.github.hetikk.apiconv.common.model.postman;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUrlQuery {

    private String key;

    private String value;

    private boolean disabled;

    private String description;

}
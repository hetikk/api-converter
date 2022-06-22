package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {

    @JsonProperty("_postman_id")
    private String postmanId;

    private String name;

    private String schema;

}

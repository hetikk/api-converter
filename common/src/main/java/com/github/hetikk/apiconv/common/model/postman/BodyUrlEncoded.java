package com.github.hetikk.apiconv.common.model.postman;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyUrlEncoded {

    private String key;

    private String value;

    private String type;

    private String description;

    private boolean disabled;

}
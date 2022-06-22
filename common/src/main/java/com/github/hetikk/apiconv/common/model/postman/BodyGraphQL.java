package com.github.hetikk.apiconv.common.model.postman;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyGraphQL {

    private String query;

    private String variables;

}
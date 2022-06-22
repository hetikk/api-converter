package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Auth {

    @RequiredArgsConstructor
    public enum Type implements IEnum {
        NO_AUTH("noauth"),
        BEARER("bearer"),
        BASIC("basic");

        private final String value;

        public String value() {
            return this.value;
        }
    }

    private Type type;

    @JsonProperty("bearer")
    private List<AuthBearer> bearers;

    @JsonProperty("basic")
    private List<AuthBasic> basics;

}

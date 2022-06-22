package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Body {

    @RequiredArgsConstructor
    public enum Mode implements IEnum {
        FILE("file"),
        FORM_DATA("formdata"),
        GRAPH_QL("graphql"),
        RAW("raw"),
        URL_ENCODED("urlencoded");

        private final String value;

        public String value() {
            return this.value;
        }
    }

    private Mode mode;

    private String raw;

    private BodyGraphQL graphql;

    private List<BodyUrlEncoded> urlencoded;

    @JsonProperty("formdata")
    private List<BodyFormData> formData;

    private BodyFile file;

    private BodyOptions options;

}

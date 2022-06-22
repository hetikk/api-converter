package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.FormDataSrcToListConverter;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.FormDataSrcToStringConverter;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BodyFormData {

    @RequiredArgsConstructor
    public enum Type implements IEnum {
        FILE("file"),
        TEXT("text");

        private final String value;

        public String value() {
            return this.value;
        }
    }

    private String key;

    private String value;

    @JsonSerialize(converter = FormDataSrcToStringConverter.class)
    @JsonDeserialize(converter = FormDataSrcToListConverter.class)
    private List<String> src;

    private Type type = Type.TEXT;

    private String contentType;

    private String description;

    private boolean disabled;

}

package com.github.hetikk.apiconv.common.model.postman.jackson.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IEnumDeserializer<T extends IEnum> extends JsonDeserializer<T> {

    private final Class<T> targetEnum;

    public IEnumDeserializer(Class<T> targetEnum) {
        super();
        this.targetEnum = targetEnum;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return IEnum.from(p.getText(), targetEnum);
    }
}
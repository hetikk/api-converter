package com.github.hetikk.apiconv.common.model.postman.jackson.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Optional;

public class IEnumSerializer<T extends IEnum> extends JsonSerializer<T> {

    private final Class<T> targetEnum;

    public IEnumSerializer(Class<T> targetEnum) {
        super();
        this.targetEnum = targetEnum;
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Optional<T> data = Optional.of(value);
        gen.writeObject(data.get().value());
    }

}
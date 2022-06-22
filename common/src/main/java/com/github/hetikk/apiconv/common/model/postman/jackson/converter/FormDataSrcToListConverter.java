package com.github.hetikk.apiconv.common.model.postman.jackson.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class FormDataSrcToListConverter extends StdConverter<JsonNode, List<String>> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public List<String> convert(JsonNode value) {
        List<String> srcs = new ArrayList<>();

        if (value == null || value.isNull()) {
            return srcs;
        }

        String content = value.toString();
        if (value.isArray()) {
            return MAPPER.readValue(content, new TypeReference<>() {
            });
        }

        srcs.add(MAPPER.readValue(content, String.class));
        return srcs;
    }
}
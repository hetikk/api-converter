package com.github.hetikk.apiconv.common.model.postman.jackson.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.SneakyThrows;

import java.util.List;

public class FormDataSrcToStringConverter extends StdConverter<List<String>, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convert(List<String> srcs) {
        if (srcs == null) {
            return "";
        }

        if (srcs.size() == 1) {
            return MAPPER.writeValueAsString(srcs.get(0));
        }

        return MAPPER.writeValueAsString(List.of(srcs));
    }
}
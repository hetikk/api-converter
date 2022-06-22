package com.github.hetikk.apiconv.common.model.postman.jackson.converter;

import com.github.hetikk.apiconv.common.exeption.ApiConverterException;

import java.util.Objects;

public interface IEnum {

    String value();

    static <T extends IEnum> T from(String value, Class<T> targetEnum) {
        if (Objects.isNull(value)) {
            throw new ApiConverterException("Require not null value");
        }

        for (T enumObj : targetEnum.getEnumConstants()) {
            if (value.equals(enumObj.value())) {
                return enumObj;
            }
        }

        throw new ApiConverterException(String.format("Not fount enum=%s with value=%s", targetEnum.getCanonicalName(), value));
    }

}

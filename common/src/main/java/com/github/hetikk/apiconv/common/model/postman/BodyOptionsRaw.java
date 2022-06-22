package com.github.hetikk.apiconv.common.model.postman;

import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BodyOptionsRaw {

    @RequiredArgsConstructor
    public enum Language implements IEnum {
        TEXT("text"),
        JSON("json"),
        JAVA_SCRIPT("javascript"),
        HTML("html"),
        XML("xml");

        private final String value;

        public String value() {
            return this.value;
        }
    }

    private Language language;

}
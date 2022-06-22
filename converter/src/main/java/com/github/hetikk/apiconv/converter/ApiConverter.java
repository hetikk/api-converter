package com.github.hetikk.apiconv.converter;

import com.github.hetikk.apiconv.converter.output.ApiSchemaOutput;
import com.github.hetikk.apiconv.converter.input.ApiSchemaInput;

public class ApiConverter {

    private final ApiSchemaInput input;
    private final ApiSchemaOutput output;

    private ApiConverter(ApiSchemaInput input, ApiSchemaOutput output) {
        this.input = input;
        this.output = output;
    }

    public void convert() {
        output.submit(input.get());
    }

    public static ApiConverterBuilder builder() {
        return new ApiConverterBuilder();
    }

    public static class ApiConverterBuilder {

        private ApiSchemaInput input;
        private ApiSchemaOutput output;

        public ApiConverterBuilder input(ApiSchemaInput input) {
            this.input = input;
            return this;
        }

        public ApiConverterBuilder output(ApiSchemaOutput output) {
            this.output = output;
            return this;
        }

        public ApiConverter build() {
            return new ApiConverter(input, output);
        }

    }

}

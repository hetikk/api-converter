package com.github.hetikk.apiconv.common.model.endpoint;

public class Endpoint extends ApiSchemaItem {

    @Override
    boolean isEndpoint() {
        return true;
    }

    @Override
    boolean isGroup() {
        return false;
    }

}

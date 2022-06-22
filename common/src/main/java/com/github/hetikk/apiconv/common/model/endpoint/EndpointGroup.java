package com.github.hetikk.apiconv.common.model.endpoint;

public class EndpointGroup extends ApiSchemaItem {

    @Override
    boolean isEndpoint() {
        return false;
    }

    @Override
    boolean isGroup() {
        return true;
    }

}

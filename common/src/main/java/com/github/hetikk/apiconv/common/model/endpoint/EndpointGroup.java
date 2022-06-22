package com.github.hetikk.apiconv.common.model.endpoint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EndpointGroup extends ApiSchemaItem implements Serializable {

    @Override
    boolean isEndpoint() {
        return false;
    }

    @Override
    boolean isGroup() {
        return true;
    }

}

package com.github.hetikk.apiconv.common.model.endpoint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Endpoint extends ApiSchemaItem implements Comparable<Endpoint>, Serializable {

    private String endpoint;
    private Method method;
    private String summary;
    private String description;
    private List<Parameter> parameters;

    @Override
    boolean isEndpoint() {
        return true;
    }

    @Override
    boolean isGroup() {
        return false;
    }

    @Override
    public int compareTo(Endpoint o) {
        int compare = this.endpoint.compareTo(o.endpoint);
        if (compare == 0) {
            compare = Integer.compare(this.method.getOrder(), o.method.getOrder());
        }
        return compare;
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "endpoint='" + endpoint + '\'' +
                ", method=" + method +
                '}';
    }
}

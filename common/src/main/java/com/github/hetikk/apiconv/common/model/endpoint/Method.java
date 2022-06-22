package com.github.hetikk.apiconv.common.model.endpoint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Method {

    GET(1),
    POST(2),
    PUT(3),
    PATCH(4),
    DELETE(5),
    OPTIONS(6);

    private final int order;

}
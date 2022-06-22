package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Item {

    private String name;

    private ProtocolProfileBehavior protocolProfileBehavior;

    private Auth auth;

    @JsonProperty("item")
    private List<Item> items;

    @JsonProperty("event")
    private List<Event> events;

    private Request request;

    @JsonProperty("response")
    private List<Response> responses;

}

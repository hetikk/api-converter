package com.github.hetikk.apiconv.common.model.postman;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostmanCollection {

    private Info info;

    @JsonProperty("item")
    private List<Item> items;

    @JsonProperty("event")
    private List<Event> events;

}

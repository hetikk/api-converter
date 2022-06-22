package com.github.hetikk.apiconv.common.model.postman;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventScript {

    private String type;

    private List<String> exec;

}
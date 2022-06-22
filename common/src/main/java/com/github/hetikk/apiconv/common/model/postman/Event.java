package com.github.hetikk.apiconv.common.model.postman;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private String listen;

    private EventScript script;

}

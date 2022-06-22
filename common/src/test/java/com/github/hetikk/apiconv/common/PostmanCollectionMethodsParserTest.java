package com.github.hetikk.apiconv.common;

import com.github.hetikk.apiconv.common.model.postman.Item;
import com.github.hetikk.apiconv.common.model.postman.Request;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanCollectionMethodsParserTest extends AbstractTest {

    @Test
    public void _1_get() {
        Item item = methodsFolder.getItems().get(0);
        Request request = item.getRequest();

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(Request.Method.GET));
    }

    @Test
    public void _2_post() {
        Item item = methodsFolder.getItems().get(1);
        Request request = item.getRequest();

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(Request.Method.POST));
    }

    @Test
    public void _3_put() {
        Item item = methodsFolder.getItems().get(2);
        Request request = item.getRequest();

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(Request.Method.PUT));
    }

    @Test
    public void _4_patch() {
        Item item = methodsFolder.getItems().get(3);
        Request request = item.getRequest();

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(Request.Method.PATCH));
    }

    @Test
    public void _5_delete() {
        Item item = methodsFolder.getItems().get(4);
        Request request = item.getRequest();

        assertThat(request.getMethod(), notNullValue());
        assertThat(request.getMethod(), is(Request.Method.DELETE));
    }

}

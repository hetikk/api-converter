package com.github.hetikk.apiconv.common;

import com.github.hetikk.apiconv.common.model.postman.Item;
import com.github.hetikk.apiconv.common.model.postman.RequestUrl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanCollectionParamsParserTest extends AbstractTest {

    @Test
    public void _1_queryParams() {
        Item item = paramsFolder.getItems().get(0);
        RequestUrl url = item.getRequest().getUrl();

        assertThat(url.getRaw(), notNullValue());
        assertThat(url.getHost(), notNullValue());
        assertThat(url.getHost().size(), greaterThanOrEqualTo(1));
        assertThat(url.getPort(), notNullValue());

        assertThat(url.getQueries(), notNullValue());
        assertThat(url.getQueries(), hasSize(2));

        assertThat(url.getQueries().get(0).getKey(), notNullValue());
        assertThat(url.getQueries().get(0).getValue(), notNullValue());

        assertThat(url.getQueries().get(1).getKey(), notNullValue());
        assertThat(url.getQueries().get(1).getValue(), notNullValue());
        assertThat(url.getQueries().get(1).isDisabled(), is(true));
    }

    @Test
    public void _2_pathParams() {
        Item item = paramsFolder.getItems().get(1);
        RequestUrl url = item.getRequest().getUrl();

        assertThat(url.getRaw(), notNullValue());
        assertThat(url.getHost(), notNullValue());
        assertThat(url.getHost().size(), greaterThanOrEqualTo(1));

        assertThat(url.getPath(), notNullValue());
        assertThat(url.getPath(), hasSize(2));
        assertThat(url.getVariables(), notNullValue());
        assertThat(url.getVariables(), hasSize(2));

        assertThat(url.getPath().get(0), notNullValue());
        assertThat(url.getVariables().get(0).getKey(), notNullValue());
        assertThat(url.getVariables().get(0).getValue(), notNullValue());

        assertThat(url.getPath().get(1), notNullValue());
        assertThat(url.getVariables().get(1).getKey(), notNullValue());
        assertThat(url.getVariables().get(1).getValue(), notNullValue());
    }

}

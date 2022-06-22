package com.github.hetikk.apiconv.common;

import com.github.hetikk.apiconv.common.model.postman.Body;
import com.github.hetikk.apiconv.common.model.postman.BodyFormData;
import com.github.hetikk.apiconv.common.model.postman.BodyGraphQL;
import com.github.hetikk.apiconv.common.model.postman.BodyOptionsRaw;
import com.github.hetikk.apiconv.common.model.postman.BodyUrlEncoded;
import com.github.hetikk.apiconv.common.model.postman.Item;
import lombok.SneakyThrows;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class PostmanCollectionBodyParserTest extends AbstractTest {

    @Test
    @SneakyThrows
    public void _1_none() {
        Item item = bodyFolder.getItems().get(0);
        Body body = item.getRequest().getBody();
        assertThat(body, nullValue());
    }

    @Test
    @SneakyThrows
    public void _2_formData() {
        Item item = bodyFolder.getItems().get(1);
        Body body = item.getRequest().getBody();
        List<BodyFormData> data = item.getRequest().getBody().getFormData();

        assertThat(body, notNullValue());
        assertThat(body.getMode(), is(Body.Mode.FORM_DATA));
        assertThat(data, notNullValue());
        assertThat(data, hasSize(4));

        assertThat(data.get(0), notNullValue());
        assertThat(data.get(0).getType(), is(BodyFormData.Type.TEXT));
        assertThat(data.get(0).getContentType(), notNullValue());

        assertThat(data.get(1), notNullValue());
        assertThat(data.get(1).getType(), is(BodyFormData.Type.TEXT));
        assertThat(data.get(1).isDisabled(), is(true));

        assertThat(data.get(2), notNullValue());
        assertThat(data.get(2).getType(), is(BodyFormData.Type.FILE));
        assertThat(data.get(2).getSrc(), hasSize(1));

        assertThat(data.get(3), notNullValue());
        assertThat(data.get(3).getType(), is(BodyFormData.Type.FILE));
        assertThat(data.get(3).getSrc().size(), greaterThan(1));
    }

    @Test
    @SneakyThrows
    public void _3_urlEncoded() {
        Item item = bodyFolder.getItems().get(2);
        Body body = item.getRequest().getBody();
        List<BodyUrlEncoded> data = item.getRequest().getBody().getUrlencoded();

        assertThat(body, notNullValue());
        assertThat(body.getMode(), is(Body.Mode.URL_ENCODED));
        assertThat(data, notNullValue());
        assertThat(data, hasSize(2));

        assertThat(data.get(0), notNullValue());
        assertThat(data.get(0).getKey(), notNullValue());
        assertThat(data.get(0).getValue(), notNullValue());
        assertThat(data.get(0).getDescription(), notNullValue());
        assertThat(data.get(0).isDisabled(), is(false));

        assertThat(data.get(1), notNullValue());
        assertThat(data.get(1).getKey(), notNullValue());
        assertThat(data.get(1).getValue(), notNullValue());
        assertThat(data.get(1).getDescription(), notNullValue());
        assertThat(data.get(1).isDisabled(), is(true));
    }

    @Test
    @SneakyThrows
    public void _4_1_raw_text() {
        Item item = bodyFolder.getItems().get(3);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.RAW));
        assertThat(body.getRaw(), notNullValue());
    }

    @Test
    @SneakyThrows
    public void _4_2_raw_javaScript() {
        Item item = bodyFolder.getItems().get(4);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.RAW));
        assertThat(body.getRaw(), notNullValue());
        MatcherAssert.assertThat(body.getOptions().getRaw().getLanguage(), Matchers.is(BodyOptionsRaw.Language.JAVA_SCRIPT));
    }

    @Test
    @SneakyThrows
    public void _4_3_raw_json() {
        Item item = bodyFolder.getItems().get(5);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.RAW));
        assertThat(body.getRaw(), notNullValue());
        assertThat(body.getOptions().getRaw().getLanguage(), is(BodyOptionsRaw.Language.JSON));
    }

    @Test
    @SneakyThrows
    public void _4_4_raw_html() {
        Item item = bodyFolder.getItems().get(6);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.RAW));
        assertThat(body.getRaw(), notNullValue());
        assertThat(body.getOptions().getRaw().getLanguage(), is(BodyOptionsRaw.Language.HTML));
    }

    @Test
    @SneakyThrows
    public void _4_5_raw_xml() {
        Item item = bodyFolder.getItems().get(7);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.RAW));
        assertThat(body.getRaw(), notNullValue());
        assertThat(body.getOptions().getRaw().getLanguage(), is(BodyOptionsRaw.Language.XML));
    }

    @Test
    @SneakyThrows
    public void _5_binary() {
        Item item = bodyFolder.getItems().get(8);
        Body body = item.getRequest().getBody();

        assertThat(body.getMode(), is(Body.Mode.FILE));
        assertThat(body.getFile().getSrc(), notNullValue());
    }

    @Test
    @SneakyThrows
    public void _6_graphQL() {
        Item item = bodyFolder.getItems().get(9);
        Body body = item.getRequest().getBody();
        BodyGraphQL data = body.getGraphql();

        assertThat(body.getMode(), is(Body.Mode.GRAPH_QL));
        assertThat(data, notNullValue());
        assertThat(data.getQuery(), notNullValue());
        assertThat(data.getVariables(), notNullValue());
    }

}

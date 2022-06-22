package com.github.hetikk.apiconv.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.hetikk.apiconv.common.model.postman.Item;
import com.github.hetikk.apiconv.common.model.postman.PostmanCollection;
import com.github.hetikk.apiconv.common.model.postman.jackson.PostmanModelsModule;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@TestMethodOrder(MethodOrderer.MethodName.class)
public abstract class AbstractTest {

    protected static final ObjectMapper mapper;

    protected static final PostmanCollection collection;
    protected static final Item paramsFolder;
    protected static final Item methodsFolder;
    protected static final Item bodyFolder;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new PostmanModelsModule());
        mapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);

        File collectionFile = new File(AbstractTest.class.getResource("/postman-collection.json").getFile());
        try {
            String content = Files.readString(Paths.get(collectionFile.getAbsolutePath()));
            collection = mapper.readValue(content, PostmanCollection.class);
            paramsFolder = collection.getItems().get(0);
            methodsFolder = collection.getItems().get(1);
            bodyFolder = collection.getItems().get(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.github.hetikk.apiconv.common.model.postman.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.hetikk.apiconv.common.model.postman.Auth;
import com.github.hetikk.apiconv.common.model.postman.Body;
import com.github.hetikk.apiconv.common.model.postman.BodyFormData;
import com.github.hetikk.apiconv.common.model.postman.BodyOptionsRaw;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnumDeserializer;
import com.github.hetikk.apiconv.common.model.postman.jackson.converter.IEnumSerializer;

public class PostmanModelsModule extends SimpleModule {

    public PostmanModelsModule() {
        super();

        Class<Body.Mode> modeClass = Body.Mode.class;
        this.addSerializer(modeClass, new IEnumSerializer<>(modeClass));
        this.addDeserializer(modeClass, new IEnumDeserializer<>(modeClass));

        Class<BodyOptionsRaw.Language> languageClass = BodyOptionsRaw.Language.class;
        this.addSerializer(languageClass, new IEnumSerializer<>(languageClass));
        this.addDeserializer(languageClass, new IEnumDeserializer<>(languageClass));

        Class<BodyFormData.Type> bodyFormDataType = BodyFormData.Type.class;
        this.addSerializer(bodyFormDataType, new IEnumSerializer<>(bodyFormDataType));
        this.addDeserializer(bodyFormDataType, new IEnumDeserializer<>(bodyFormDataType));

        Class<Auth.Type> authType = Auth.Type.class;
        this.addSerializer(authType, new IEnumSerializer<>(authType));
        this.addDeserializer(authType, new IEnumDeserializer<>(authType));
    }

}

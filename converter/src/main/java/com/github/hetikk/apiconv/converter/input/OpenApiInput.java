package com.github.hetikk.apiconv.converter.input;

import com.github.hetikk.apiconv.common.model.endpoint.ApiSchema;
import com.github.hetikk.apiconv.common.model.endpoint.Endpoint;
import com.github.hetikk.apiconv.common.model.endpoint.Method;
import com.github.hetikk.apiconv.common.model.endpoint.Parameter;
import com.google.common.collect.ImmutableMap;
import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenApiInput implements ApiSchemaInput {

    private static final Map<String, Pair<Method, Function<PathItem, Operation>>> PATH_ITEM_METHODS_MAP = ImmutableMap.of(
            "get", Pair.of(Method.GET, PathItem::getGet),
            "put", Pair.of(Method.PUT, PathItem::getPut),
            "post", Pair.of(Method.POST, PathItem::getPost),
            "delete", Pair.of(Method.DELETE, PathItem::getDelete),
            "options", Pair.of(Method.OPTIONS, PathItem::getOptions),
            "patch", Pair.of(Method.PATCH, PathItem::getPatch)
    );

    private final OpenAPI openAPI;

    public OpenApiInput(File file) {
        SwaggerParseResult result = new OpenAPIParser().readLocation(file.getAbsolutePath(), null, null);
        openAPI = result.getOpenAPI();
    }

    @Override
    public ApiSchema get() {
        List<Endpoint> endpoints = getEndpoints();
        for (Endpoint endpoint : endpoints) {
            System.out.println(endpoint);
        }
        return group(endpoints);
    }

    private List<Endpoint> getEndpoints() {
        return openAPI.getPaths().entrySet().stream()
                .flatMap(e -> extractEndpointsFromPathItem(e.getKey(), e.getValue()))
                .sorted()
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private Stream<Endpoint> extractEndpointsFromPathItem(String targetEndpoint, PathItem pathItem) {
        Stream.Builder<Endpoint> builder = Stream.builder();
        for (String operationName : PATH_ITEM_METHODS_MAP.keySet()) {
            Field field = pathItem.getClass().getDeclaredField(operationName);
            field.setAccessible(true);
            if (Operation.class.isAssignableFrom(field.getType())) {
                Operation operation = (Operation) field.get(pathItem);
                Method method = PATH_ITEM_METHODS_MAP.get(operationName).getKey();
                if (operation != null) {
                    builder.add(convertOperation(targetEndpoint, operation, method));
                }
            }
        }
        return builder.build();
    }

    private Endpoint convertOperation(String targetEndpoint, Operation operation, Method method) {
        Endpoint endpoint = new Endpoint();
        endpoint.setEndpoint(targetEndpoint);
        endpoint.setMethod(method);
        endpoint.setSummary(operation.getSummary());
        endpoint.setDescription(operation.getDescription());
        endpoint.setParameters(convertParameters(operation.getParameters()));
        return endpoint;
    }

    private List<Parameter> convertParameters(List<io.swagger.v3.oas.models.parameters.Parameter> params) {

    }

    private ApiSchema group(List<Endpoint> endpoints) {
        ApiSchema schema = new ApiSchema();
        return schema;
    }

}

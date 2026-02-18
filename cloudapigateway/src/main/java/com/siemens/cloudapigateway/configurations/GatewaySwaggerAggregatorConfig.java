package com.siemens.cloudapigateway.configurations;

import jakarta.annotation.PostConstruct;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
public class GatewaySwaggerAggregatorConfig {

    private final RouteDefinitionLocator routeDefinitionLocator;
    private final SwaggerUiConfigProperties swaggerUiConfigProperties;

    public GatewaySwaggerAggregatorConfig(RouteDefinitionLocator routeDefinitionLocator,
                                         SwaggerUiConfigProperties swaggerUiConfigProperties) {
        this.routeDefinitionLocator = routeDefinitionLocator;
        this.swaggerUiConfigProperties = swaggerUiConfigProperties;
    }

    @PostConstruct
    public void init() {
        // springdoc expects Set, not List
        Set<SwaggerUiConfigProperties.SwaggerUrl> urls =
                swaggerUiConfigProperties.getUrls() != null
                        ? swaggerUiConfigProperties.getUrls()
                        : new LinkedHashSet<>();

        routeDefinitionLocator.getRouteDefinitions().subscribe(def -> {
            String routeId = def.getId();
            if (routeId == null || routeId.isBlank()) return;

            // Your route ids are like: HOSPITALMANGEMENTAPI_PREFIX
            // We use _PREFIX routes as the "service routes"
            if (!routeId.endsWith("_PREFIX")) return;

            String serviceName = routeId.replace("_PREFIX", "");

            SwaggerUiConfigProperties.SwaggerUrl url = new SwaggerUiConfigProperties.SwaggerUrl();
            url.setName(serviceName);
            url.setUrl("/" + serviceName + "/v3/api-docs"); // routed through gateway

            urls.add(url);
        });

        swaggerUiConfigProperties.setUrls(urls);
    }
}
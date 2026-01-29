package com.cognizant.hospitalmgmt.configurations;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPISecurityConfig {

        @Value("${keycloak.issuer}")  // e.g. http://host.docker.internal:8080/realms/master
        String issuer;

        private static final String OAUTH_SCHEME_NAME = "keycloak";

        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                        // define the OAuth2 scheme
                        .components(new Components()
                                .addSecuritySchemes(OAUTH_SCHEME_NAME, oauthScheme()))

                        // 🔑 this is where you attach the SecurityRequirement
                        // it tells Swagger: "every operation requires the 'developer' scope"
                        .addSecurityItem(new SecurityRequirement()
                                .addList(OAUTH_SCHEME_NAME, List.of("developer")))

                        .info(new Info()
                                .title("Customer Management Service")
                                .description("Customer API with OAuth2 Security")
                                .version("1.0"));
        }

        private SecurityScheme oauthScheme() {
                String authUrl  = issuer + "/protocol/openid-connect/auth";
                String tokenUrl = issuer + "/protocol/openid-connect/token";

                OAuthFlow code = new OAuthFlow()
                        .authorizationUrl(authUrl)
                        .tokenUrl(tokenUrl)

                        .scopes(new Scopes().addString("developer", "Developer access")
                                .addString("manager", "Manager access"));

                return new SecurityScheme()
                        .type(SecurityScheme.Type.OAUTH2)

                        .flows(new OAuthFlows().authorizationCode(code));
        }
}


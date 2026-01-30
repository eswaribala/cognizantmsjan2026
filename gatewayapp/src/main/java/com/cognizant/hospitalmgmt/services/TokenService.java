package com.cognizant.hospitalmgmt.services;

import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TokenService {

    private final ReactiveOAuth2AuthorizedClientManager manager;

    public TokenService(ReactiveClientRegistrationRepository registrations,
                        ServerOAuth2AuthorizedClientRepository authorizedClients) {

        ReactiveOAuth2AuthorizedClientProvider provider =
                ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
                        .clientCredentials()
                        .build();

        DefaultReactiveOAuth2AuthorizedClientManager m =
                new DefaultReactiveOAuth2AuthorizedClientManager(registrations, authorizedClients);

        m.setAuthorizedClientProvider(provider);
        this.manager = m;
    }

    public Mono<String> getToken(String registrationId) {
        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId(registrationId)
                // principal name can be anything for client_credentials
                .principal("gateway-service")
                .build();

        return manager.authorize(request)
                .map(OAuth2AuthorizedClient::getAccessToken)
                .map(OAuth2AccessToken::getTokenValue);
    }
}

package com.cognizant.hospitalmgmt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import com.cognizant.hospitalmgmt.services.TokenService;

import reactor.core.publisher.Mono;

@RestController
public class ApiController {
	@Autowired
	private TokenService tokenService;
	@GetMapping(value = "/token")
	public Mono<String> getHome(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
		
		OAuth2AccessToken client = authorizedClient.getAccessToken();
		client.getScopes().forEach(System.out::println);
		return Mono.just(client.getTokenValue());
	}

	@GetMapping("/")
	public Mono<String> index(WebSession session) {
		return Mono.just(session.getId());
	}
	 @GetMapping("/token/developer")
	    public Mono<String> developerToken() {
		  return tokenService.getToken("keycloak-with-developer-scope");
	    }

	    @GetMapping("/token/tester")
	    public Mono<String> testerToken() {
	        
	    	  return tokenService.getToken("keycloak-with-tester-scope");
	
	    }

}

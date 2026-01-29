package com.cognizant.hospitalmgmt.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
//spring boot 2.x
//@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
//spring boot 3.x
@EnableMethodSecurity
public class SecurityConfig  {

	/*protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorize -> authorize.anyRequest().authenticated())
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

	@Bean
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}*/

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req -> req
						// allow swagger & docs
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
						.requestMatchers(HttpMethod.OPTIONS).permitAll()
						// protect your APIs
						.requestMatchers("/api/**").authenticated()
						.anyRequest().permitAll()
				)
				.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));

		return http.build();
	}

}

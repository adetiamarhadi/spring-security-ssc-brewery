package com.github.adetiamarhadi.springsecuritysscbrewery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/", "/webjars/**", "/login", "/resources/**").permitAll()
                                .requestMatchers("/beers/find", "/beers*").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/beer/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/beerUpc/{upc}").permitAll()
                )
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        // @formatter:on
        return http.build();
    }
}


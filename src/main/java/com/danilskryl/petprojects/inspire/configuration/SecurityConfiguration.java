package com.danilskryl.petprojects.inspire.configuration;

import com.danilskryl.petprojects.inspire.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.*;

//@EnableWebSecurity
//@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers(GET, "/courses/**")
                        .hasAnyRole(
                                Role.OWNER.name(),
                                Role.ADMIN.name(),
                                Role.STUDENT.name(),
                                Role.TEACHER.name()
                        )
                        .requestMatchers
                                (POST, "/courses/**")
                        .hasAnyRole(
                                Role.OWNER.name(),
                                Role.ADMIN.name(),
                                Role.TEACHER.name()
                        )
                        .requestMatchers
                                (DELETE, "/courses/**")
                        .hasAnyRole(
                                Role.OWNER.name(),
                                Role.ADMIN.name(),
                                Role.TEACHER.name()
                        )
                        .requestMatchers
                                (PUT, "/courses/**")
                        .hasAnyRole(
                                Role.OWNER.name(),
                                Role.ADMIN.name(),
                                Role.TEACHER.name()
                        )
                );

        return http.build();
    }
}

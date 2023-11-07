package com.danilskryl.petprojects.inspire.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static com.danilskryl.petprojects.inspire.entity.Role.OWNER;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(req -> req
//                        .requestMatchers("/login").permitAll()
//                        .requestMatchers("/registration").permitAll()
//                        .requestMatchers("/admin/**").hasRole(OWNER.name())
//                        .anyRequest().authenticated())
//                .formLogin(form ->
//                        form.loginPage("/login")
//                                .permitAll())
//                .logout(LogoutConfigurer::permitAll);
//        return http.build();
//    }
}

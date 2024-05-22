package com.finki.ukim.mk.predmetnik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomIndexPasswordAuthenticationProvider customIndexPasswordAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RequestMatcher adminPages = request -> {
            String path = request.getServletPath();
            return path.startsWith("/admin/") || path.equals("/admin");
        };

        RequestMatcher publicPages = request -> {
            String path = request.getServletPath();
            return path.equals("/register");
        };

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/images/**", "/css/**", "/js/**", "/static/**").permitAll()
                .requestMatchers(publicPages).permitAll()
                .requestMatchers(adminPages).hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/courses", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access_denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customIndexPasswordAuthenticationProvider);
    }

}

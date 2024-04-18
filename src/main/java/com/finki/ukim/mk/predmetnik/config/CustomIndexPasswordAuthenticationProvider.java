package com.finki.ukim.mk.predmetnik.config;

import com.finki.ukim.mk.predmetnik.service.StudentService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


    @Component
    public class CustomIndexPasswordAuthenticationProvider implements AuthenticationProvider {

        private final StudentService studentService;
        private final PasswordEncoder passwordEncoder;

        public CustomIndexPasswordAuthenticationProvider(StudentService studentService, PasswordEncoder passwordEncoder) {
            this.studentService = studentService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String index = authentication.getName();
            String password = authentication.getCredentials().toString();

            if ("".equals(index) || "".equals(password)) {
                throw new BadCredentialsException("Invalid credentials");
            }

            UserDetails userDetails = this.studentService.loadUserByUsername(index);

            if (passwordEncoder.matches(password, userDetails.getPassword()))
                throw new BadCredentialsException("Invalid credentials");

            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }
    }


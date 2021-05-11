package com.abhinavjdwij.learn.LearnSpringSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
Basic Auth example
Drawback: Basic Auth requires username / password for each request, no login / logout feature
 */

/*

 ** means zero or more directories, * means zero or more characters

 */

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("CustomPasswordEncoder")
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/public/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails abhinavUser = User.builder()
                .username("abhinav")
                .password(passwordEncoder.encode("password"))
                .roles("STUDENT").build();

        UserDetails adminUser = User.builder()
                .username("admin_local")
                .password(passwordEncoder.encode("admin_pass"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(abhinavUser, adminUser);
    }
}

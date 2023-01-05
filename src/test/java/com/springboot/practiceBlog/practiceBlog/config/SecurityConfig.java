package com.springboot.practiceBlog.practiceBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)              // used for method based security & prepostEnabled=true for using @PreAuthorize annotation
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



        @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ramesh = User.builder().username("ramesh").password(passwordEncoder()
                .encode("password")).roles("admin").build();
        UserDetails admin = User.builder().username("new").password(passwordEncoder()
                .encode("new")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(ramesh, admin);
    }
}

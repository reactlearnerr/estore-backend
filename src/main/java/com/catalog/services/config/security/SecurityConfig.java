package com.catalog.services.config.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/admin/").hasRole("ADMIN")
                .antMatchers("/","/*/index.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
                //.and()
               // .logout().logoutUrl("/logout").logoutSuccessUrl("/swagger-ui/index.html");
    }
}


# Common Tips

## Errors
1. You can open swagger-ui but you will see this error - __Failed to load remote configuration.__
-   If your configuration doesn't have the authentication type (formLogin or httpBasic) then you will encounter this error
```
protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/swagger-ui/*")
                .permitAll()
                .anyRequest()
                .authenticated();
``` 
To Solve this issue, add the auth type. E.g., __.and().httpBasic();__
2. If you encounter this error ``org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'springSecurityFilterChain' defined in class path resource [org/springframework/security/config/annotation/web/configuration/WebSecurityConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.servlet.Filter]: Factory method 'springSecurityFilterChain' threw exception; nested exception is org.springframework.security.config.annotation.AlreadyBuiltException: This object has already been built
   ``
- This can occur if you are trying to run http.build() method explicitly in the configure method that you override inside the SecurityConfig class. The http instance would have already built so no need to build again.

## Tips
- Make sure you are mindful of the version with SB and spring framework. For SB v2.7 and spring v5.7 onwards WebSecurityConfigurer is deprecated so your configuration needs to be updated accordingly.
- Below v2.7 SB (2.6.13), your config can extend WebSecurityConfigurer 
Backend Implementation for the ecommerce project using Springboot and React

## Spring Security Setup
To enable spring security on the application, follow the below steps
- Add the springboot-security dependency in the POM.xml
```
                <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```
- After adding this dependency, you will be having The default AuthenticationManager that has a single user: ``user``
- A random password that you can get it by checking the application startup logs by finding the text:
  ``Using default security password: ``
- You can disable the above security setup by creating your own set of credentials inside application.yml
```
spring:
  security:
    user:
      name: prithvi
      password: passw0rd
```
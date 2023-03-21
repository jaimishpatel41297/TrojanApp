/*
 * package com.example.trojans.configuration;
 * 
 * import org.h2.server.web.WebServlet; import
 * org.springframework.boot.web.servlet.ServletRegistrationBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 * 
 * @Configuration public class LoginAppConfig implements WebMvcConfigurer{
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { BCryptPasswordEncoder
 * encyptPassword = new BCryptPasswordEncoder(); return encyptPassword; }
 * 
 * @Bean ServletRegistrationBean beanRegistration() { ServletRegistrationBean
 * registrationBean = new ServletRegistrationBean(new WebServlet());
 * registrationBean.addUrlMappings("/console/*"); return registrationBean; } }
 */
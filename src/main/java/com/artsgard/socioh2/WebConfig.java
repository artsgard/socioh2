package com.artsgard.socioh2;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;



//@Configuration
public class WebConfig {
    /*
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registration = new ServletRegistrationBean( new org.h2.server.web.WebServlet());
        registration.addUrlMappings("/h2-console/*");
        registration.addInitParameter("webAllowOthers", "true");
        registration.addInitParameter("webPort", "7777");// <-- the port your wish goes here

        return registration;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatchers(HttpMethod.GET, "/h2/**").permitAll()
                .antMatchers(HttpMethod.POST, "/h2/**").permitAll()
                .anyRequest().authenticated();

//to avoid X-Frame-Options header of Spring Security. 
        http.headers().frameOptions().disable();
    }
*/
}

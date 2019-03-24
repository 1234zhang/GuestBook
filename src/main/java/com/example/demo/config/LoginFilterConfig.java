package com.example.demo.config;

import com.example.demo.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class LoginFilterConfig {
    @Bean
    public Filter LoginFilter(){
        return new LoginFilter();
    }
    @Bean
    public FilterRegistrationBean IdentityRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DelegatingFilterProxy("LoginFilter"));
        filterRegistrationBean.addUrlPatterns("/message/*");
        filterRegistrationBean.setName("LoginFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}

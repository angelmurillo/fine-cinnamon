package com.finecinnamon.eventviewer.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
         
        @Override
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
                 
                PageableArgumentResolver resolver = new PageableArgumentResolver();
                resolver.setFallbackPagable(new PageRequest(1, 20));
                 
                argumentResolvers.add(new ServletWebArgumentResolverAdapter(resolver));
        }
}

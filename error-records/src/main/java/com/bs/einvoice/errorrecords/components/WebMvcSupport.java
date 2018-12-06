package com.bs.einvoice.errorrecords.components;

import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

@Configuration
public class WebMvcSupport extends WebMvcConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("添加访问拦截器");
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/**")
                .excludePathPatterns("/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.debug("添加静态资源处理器");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String s) {
                return null;
            }
        });
    }
}

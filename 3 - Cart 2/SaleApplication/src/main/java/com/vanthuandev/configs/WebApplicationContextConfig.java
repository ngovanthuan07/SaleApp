/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vanthuandev.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author ngova
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.vanthuandev.controllers",
    "com.vanthuandev.repository",
    "com.vanthuandev.service"
//    "com.vanthuandev.validator",
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

	
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/");

        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/");
    }

    @Override
    public Validator getValidator() {
        // Giới thiệu Bean Validator
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        // Giới thiệu Bean Validator
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new CategoryFormatter());
//    }
//    @Bean
//    public WebAppValidator productValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new ProductNameValidator());
//        WebAppValidator v = new WebAppValidator();
//        v.setSpringValidators(springValidators);
//        return v;
//    }
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resource = new InternalResourceViewResolver();
        resource.setViewClass(JstlView.class);
        resource.setPrefix("/WEB-INF/jsp/");
        resource.setSuffix(".jsp");
        return resource;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "lap-trinh-java",
                "api_key", "431218625765133",
                "api_secret", "T_1S6MZmo_T5xKZxnNW2byMRtAM",
                "secure", true
        ));

        return c;
    }

}

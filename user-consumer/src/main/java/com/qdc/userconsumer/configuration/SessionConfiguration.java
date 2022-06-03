package com.qdc.userconsumer.configuration;


import com.qdc.userconsumer.filter.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//将拦截器添加到SpringBoot配置中
public class SessionConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/user/positionDetail");
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/user/companyDetail");
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/user/findPositionByPlace");
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/user/findPositionLikepName");
    }
}

package com.example.springbootdemo.config;

import com.example.springbootdemo.bean.HelloService;
import com.example.springbootdemo.component.LoginHandlerInterceptor;
import com.example.springbootdemo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Configuration当前类是一个配置类
 */
@Configuration
public class MyAppConfig {
    /**
     * 将方法的返回值添加到配置文件中,容器中的组件名就是方法名
     * 也就是说HelloService会添加到容器中,并且它的名字是方法的名称helloService,如果方法名改成其他的,那么也将改名
     * 例如helloService->hello,那么hello就代表了HelloService
     * @return
     */
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/user/login","/asserts/**","/webjars/**","/css/**");
            }
        };
        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

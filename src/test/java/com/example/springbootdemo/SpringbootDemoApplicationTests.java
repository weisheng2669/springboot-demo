package com.example.springbootdemo;

import com.example.springbootdemo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot的单元测试
 *
 * 可以在测试期间可以自动注入
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void hasHelloService(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
       logger.trace("trace 日志");
       logger.debug("debug 日志");
       logger.warn("warning 日志");
    }

}

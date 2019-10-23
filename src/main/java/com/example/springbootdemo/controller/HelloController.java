package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Person;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
//@EnableAutoConfiguration
/*
@RestController
   = @Controller + @EnableAutoConfiguration
*/
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "Hello";
    }

    //转发这个请求/success
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //然后到classpath:/templates/+result.html
        map.put("name","cssaadsasdsc");
        map.put("users", Arrays.asList("zs","ls"));
        return "result";
    }

    @RequestMapping({"/","/index.html"})
    public String index(){
       return "index";
    }
}

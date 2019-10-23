package com.example.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger("LoginController");
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //为了防止登录的过程中,再次提交表单,可以进行重定向
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            logger.info("用户名或密码错误");
            map.put("msg","用户名或密码错误");
            return "index";
        }
    }
}

package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
//设置想要跳转的父路径
//@RequestMapping(value = "/c")
public class HelloWorldController {

    @RequestMapping("/")
    //返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
    @ResponseBody
    public String index() {
        return "Hello World2！";
    }
}

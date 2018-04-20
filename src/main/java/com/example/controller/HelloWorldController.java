package com.example.controller;

import com.example.domain.User;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController //@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
//设置想要跳转的父路径
//@RequestMapping(value = "/c")
public class HelloWorldController {

    @RequestMapping("/")
    //返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用
    @ResponseBody
    public String index() {

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
//        log.info("Call Hello Word：" + date);

        return "Hello World！";
    }
}

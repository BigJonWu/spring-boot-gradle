package com.example.controller;

import com.example.producer.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RabbitTestController {

    @Autowired
    HelloSender helloSender;

    @RequestMapping("msg")
    public String index() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

        String sendMsg = "Message Send:" + date;
        helloSender.send(sendMsg);

        return sendMsg;
    }

    @RequestMapping("msgs")
    public void test() {

        for (int i=0;i<100;i++){
            helloSender.send(String.valueOf(i));
        }
    }
}

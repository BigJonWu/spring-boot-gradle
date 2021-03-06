package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/mongojpatest")
public class CustomerJpaController {
    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.remove(id);
        return "delete sucess";
    }

    @RequestMapping("/add")
    public String insert() {
        User user = new User(16, ""+16, 16,"");
        userService.insert(user);
        return "sucess";
    }

    @RequestMapping("/insert")
    public String insertAll() {
        List<User> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list.add(new User(i, "" + i, i,""));
        }

        userService.insertAll(list);
        return "sucess";
    }

    @RequestMapping("/find/all")
    public List<User> find(){
        return userService.findAll();
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id){
        User user =new User(id, "" +1, 1,"");
        userService.update(user);
        return "sucess";
    }
}
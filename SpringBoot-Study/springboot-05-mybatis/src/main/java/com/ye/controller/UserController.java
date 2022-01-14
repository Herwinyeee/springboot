package com.ye.controller;

import com.ye.pojo.User;
import com.ye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "query/")
    public List<User> queryUserList(){
        List<User> users = userService.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
    @GetMapping(value = "queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        User user = userService.queryUserById(id);
        System.out.println(user);
        return user;
    }
    @GetMapping(value = "deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") int id){
        int i = userService.deleteUserById(id);
        if(i == 1){
            return "ok";
        }else {
            return "not ok";
        }
    }
    @GetMapping(value = "update/{id}/{name}")
    public String updateUser(@PathVariable("id") int id, @PathVariable("name") String name){
        User user = new User(id,name);
        int i = userService.updateUser(user);
        if(i == 1){
            return "ok";
        }else {
            return "not ok";
        }

    }
    @GetMapping(value = "add/{id}/{name}")
    public String addUser(@PathVariable("id") int id, @PathVariable("name") String name){
        User user = new User(id,name);
        int i = userService.addUser(user);
        if(i == 1){
            return "ok";
        }else {
            return "not ok";
        }
    }
}

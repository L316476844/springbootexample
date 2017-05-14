package org.jon.lv.controller;

import org.jon.lv.domain.User;
import org.jon.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package org.jon.lv.controller.UserController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 15:30
 * version V1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id")Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping("/add")
    public Integer add(@RequestBody User user){
        return userService.save(user);
    }
}

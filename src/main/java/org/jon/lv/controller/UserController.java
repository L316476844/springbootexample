package org.jon.lv.controller;

import org.jon.lv.domain.User;
import org.jon.lv.result.ResultDO;
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
    public ResultDO<User> get(@PathVariable("id")Integer id){
        ResultDO<User> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        resultDO.setData(userService.getUserById(id));
        return resultDO;
    }

    @RequestMapping("/add")
    public ResultDO<Integer> add(User user){
        ResultDO<Integer> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        resultDO.setData(userService.save(user));
        return resultDO;
    }
}

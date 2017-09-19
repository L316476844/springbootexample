package org.jon.lv.service;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.jon.lv.domain.User;
import org.jon.lv.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package org.jon.lv.service.UserServiceTest
 * @Description: UserServiceTest
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 17:21
 * version V1.0.0
 */
public class UserServiceTest extends SpringbootexampleApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveDouble(){
        User user = new User();
        user.setHead("测试121212");
        user.setName("hello world");
        userService.saveDouble(user);

        System.out.println(user);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setHead("dev world");
        user.setName("dev world");
        userService.save(user);
        System.out.println(user);
    }

    @Test
    public void testQueryPage(){
        Page<User> page = userService.queryPage(1,2);
        System.out.println(page);
    }

    @Test
    public void testGetOne(){
        User user = userService.getUserById(82006);
        System.out.println(user);
    }
}

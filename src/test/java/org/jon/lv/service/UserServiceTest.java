package org.jon.lv.service;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.jon.lv.domain.User;
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
    public void testSave(){

        User user = new User();
        user.setName("sahksdhk");
        userService.save(user);

        System.out.println(user);
    }

}

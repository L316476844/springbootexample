package org.jon.lv.service;

import org.jon.lv.domain.User;
import org.jon.lv.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package org.jon.lv.service.UserService
 * @Description: UserService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 15:30
 * version V1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer save(User user){
        userMapper.insert(user);

        return user.getId();
    }

    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}

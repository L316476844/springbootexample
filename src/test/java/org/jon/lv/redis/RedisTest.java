package org.jon.lv.redis;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.jon.lv.domain.User;
import org.junit.Test;

/**
 * @Package org.jon.lv.redis.RedisTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 15:01
 * version V1.0.0
 */
public class RedisTest extends SpringbootexampleApplicationTests {

    @Test
    public void setVal(){
//        RedisUtils.set("springboottest111111", "中国式", 10000L);
        User user = new User();
        user.setName("测试");
        user.setPhone("123444444444");
        RedisUtils.set("springboottest", user, 10000L);
    }

    @Test
    public void getVal(){
        System.out.println("**************************" + RedisUtils.get("springboottest"));
    }
}

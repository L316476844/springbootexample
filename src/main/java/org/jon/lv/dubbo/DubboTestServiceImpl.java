package org.jon.lv.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package org.jon.lv.dubbo.DubboTestServiceImpl
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 10:25
 * version V1.0.0
 */
@Service
public class DubboTestServiceImpl implements DubboTestService{
    @Autowired
    private DubboDemoService dubboDemoService;

    @Override
    public void say(String words) {
        dubboDemoService.say(words);
        System.out.println("test----------##############" + words);
    }

    @Override
    public String info(String content) {
        return "test----------$$$$$$$$$$$$".concat(content);
    }
}

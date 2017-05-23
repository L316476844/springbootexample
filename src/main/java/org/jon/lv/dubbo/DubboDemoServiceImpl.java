package org.jon.lv.dubbo;


import org.springframework.stereotype.Service;

/**
 * @Package org.jon.lv.dubbo.DubboDemoServiceImpl
 * @Description: DubboDemoServiceImpl
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/19 13:35
 * version V1.0.0
 */
@Service
public class DubboDemoServiceImpl implements DubboDemoService{
    @Override
    public void say(String words) {
        System.out.println("##############" + words);
    }

    @Override
    public String info(String content) {
        return "$$$$$$$$$$$$".concat(content);
    }
}

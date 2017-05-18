package org.jon.lv.xml;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package org.jon.lv.xml.XmlTest
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 15:40
 * version V1.0.0
 */
public class XmlTest extends SpringbootexampleApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    public void testSay(){
        helloService.say("你好吗？");
    }
}

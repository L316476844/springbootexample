package org.jon.lv.dubbo;

/**
 * @Package org.jon.lv.dubbo.DubboTestService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/22 10:24
 * version V1.0.0
 */
public interface DubboTestService {
    void say(String words);

    String info(String content);
}

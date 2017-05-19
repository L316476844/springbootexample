package org.jon.lv.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package org.jon.lv.kafka.MsgConsumer
 * @Description: 消息消费者
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 16:15
 * version V1.0.0
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"jon-replicated-topic","jon-replicated-topic2"})
    public void processMessage(String content) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$" + content);
    }
}

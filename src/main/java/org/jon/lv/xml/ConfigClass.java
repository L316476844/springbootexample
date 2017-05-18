package org.jon.lv.xml;

/**
 * @Package org.jon.lv.xml.ConfigClass
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 15:38
 * version V1.0.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
 * file路径： locations = {"file:d:/test/application-bean1.xml"};
 */

@Configuration
@ImportResource(locations={"classpath:xml/application-bean.xml"})
public class ConfigClass {
    //配置无法扫描到的类
}

package org.jon.lv.dubbo;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;

/**
 * @Package org.jon.lv.dubbo.ServiceBean
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/23 9:53
 * version V1.0.0
 */
public class ServiceBean extends com.alibaba.dubbo.config.spring.ServiceBean {
    public ServiceBean() {
    }

    @PostConstruct
    public void init() {
        if(this.getRef() == null) {
            Class interfaceClass = this.getInterfaceClass();
            if(null == interfaceClass && logger.isDebugEnabled()) {
                logger.debug(" 没有注入服务接口或注入接口名称不是接口类名");
                return;
            }

            Map objectMap = getSpringContext().getBeansOfType(interfaceClass);
            if(objectMap != null && !objectMap.isEmpty()) {
                if(objectMap.size() > 1) {
                    if(logger.isDebugEnabled()) {
                        logger.debug(interfaceClass + " 实例个数多余1个 ,需要手动指定具体实例");
                    }
                } else {
                    Iterator i$ = objectMap.values().iterator();
                    if(i$.hasNext()) {
                        Object object = i$.next();
                        this.setRef(object);
                        if(logger.isDebugEnabled()) {
                            logger.debug(" 自动为 " + interfaceClass + " 指定实例 " + object);
                        }
                    }
                }
            } else if(logger.isDebugEnabled()) {
                logger.debug(interfaceClass + " 没有找到实例,不能自动指定实例");
            }
        }

    }
}

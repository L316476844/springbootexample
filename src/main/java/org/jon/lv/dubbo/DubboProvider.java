package org.jon.lv.dubbo;

import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.spring.ServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Package org.jon.lv.dubbo.DubboProvider
 * @Description: DubboProvider
 * Author lv bin
 * @date 2017/5/22 10:04
 * version V1.0.0
 */
@Component
public class DubboProvider {

    /**
     * 1、dubbo提供者的使用方式可以是在service的实现类上加入 dubbo的@Service注解
     *
     * 2、也可以使用此处类中的方式进行提供 在service实现类上使用 spring的@Service注解
     */

//    @Bean
//    public ServiceBean<DubboDemoService> dubboDemoService(ProviderConfig providerConfig, DubboDemoService dubboDemoService){
//        ServiceBean<DubboDemoService> serviceBean = new ServiceBean<>();
//        serviceBean.setProvider(providerConfig);
//        serviceBean.setInterface(DubboDemoService.class);
//        serviceBean.setRef(dubboDemoService);
//        return serviceBean;
//    }
//
//    @Bean
//    public ServiceBean<DubboTestService> dubboTestService(ProviderConfig providerConfig, DubboTestService dubboTestService){
//        ServiceBean<DubboTestService> serviceBean = new ServiceBean<>();
//        serviceBean.setProvider(providerConfig);
//        serviceBean.setInterface(DubboTestService.class);
//        serviceBean.setRef(dubboTestService);
//        return serviceBean;
//    }
}

package org.jon.lv.dubbo;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.rpc.Exporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;

/**
 * @Package org.jon.lv.dubbo.DubboConfig
 * @Description: DubboConfig
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/19 16:28
 * version V1.0.0
 */
@Configuration
@ConditionalOnClass(Exporter.class)
@PropertySource(value = "classpath:/dubbo.properties")
public class DubboConfig{

    /**
     * 设置dubbo扫描包
     * @return
     */
    @Bean
    public AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String annotationPackage) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(annotationPackage);
        return annotationBean;
    }

    /**
     * 注入dubbo上下文
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig(@Value("${dubbo.app.name}") String appName){
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(appName);
        return applicationConfig;
    }

    /**
     * 注入dubbo注册中心配置,基于zookeeper
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(@Value("${dubbo.registry.url}") String registryUrl,
                                         @Value("${dubbo.registry.file}") String registryFile) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$" + registryUrl);
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setDefault(true);
        registry.setAddress(registryUrl);
        registry.setFile(registryFile);
        return registry;
    }

    /**
     * 默认基于dubbo协议提供服务
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(@Value("${dubbo.protocol.port}")Integer protocolPort) {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(protocolPort);
        protocolConfig.setThreads(200);
        return protocolConfig;
    }

    /**
     * 监控
     * @return
     */
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    /**
     * dubbo服务提供
     * @param applicationConfig
     * @param registryConfig
     * @param protocolConfig
     * @param monitorConfig
     * @return
     */
    @Bean(name="defaultProvider")
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig, MonitorConfig monitorConfig,
                                         @Value("${dubbo.provider.timeout}") Integer providerTimeout,
                                         @Value("${dubbo.provider.retries}")Integer retries,
                                         @Value("${dubbo.provider.delay}")Integer delay,
                                         @Value("${dubbo.provider.default.version}")String providerVersion) {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(providerTimeout);
        providerConfig.setRetries(retries);
        providerConfig.setMonitor(monitorConfig);
        providerConfig.setApplication(applicationConfig);
        providerConfig.setRegistry(registryConfig);
        providerConfig.setProtocol(protocolConfig);
        providerConfig.setDelay(delay);
        providerConfig.setVersion(providerVersion);
        return providerConfig;
    }

    /**
     * dubbo消费
     * @param applicationConfig
     * @param registryConfig
     * @param monitorConfig
     * @return
     */
    @Bean(name="defaultConsumer")
    public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
                                         MonitorConfig monitorConfig,
                                         @Value("${dubbo.provider.timeout}") Integer providerTimeout,
                                         @Value("${dubbo.provider.retries}")Integer retries,
                                         @Value("${dubbo.consume.service.check}") Boolean serviceCheck,
                                         @Value("${dubbo.consumer.default.version}")String consumerVersion) {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(providerTimeout);
        consumerConfig.setRetries(retries);
        consumerConfig.setMonitor(monitorConfig);
        consumerConfig.setApplication(applicationConfig);
        consumerConfig.setRegistry(registryConfig);
        consumerConfig.setCheck(serviceCheck);
        consumerConfig.setVersion(consumerVersion);
        return consumerConfig;
    }
}

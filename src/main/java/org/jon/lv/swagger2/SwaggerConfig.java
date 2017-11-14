package org.jon.lv.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package org.jon.lv.swagger2.SwaggerConfig
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/19 10:45
 * version V1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    //http://localhost:8098/swagger-ui.html

   /**
     * 使用enableMVC注解的话,该配置必须,否则无法映射资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Bean
    public Docket createRestApi() {

        ParameterBuilder tokenParams = new ParameterBuilder();
        tokenParams.name("X-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        ParameterBuilder TimeParams = new ParameterBuilder();
        TimeParams.name("X-Timestamp").description("时间戳").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        ParameterBuilder signParams = new ParameterBuilder();
        signParams.name("X-Sign").description("签名").modelRef(new ModelRef("string")).parameterType("header").required(true).build();

        List<Parameter> headerParams = new ArrayList<Parameter>();
        headerParams.add(tokenParams.build());
        headerParams.add(TimeParams.build());
        headerParams.add(signParams.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jon.lv.controller"))
                .build()
                .globalOperationParameters(headerParams);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("jon","http://","316476844.com");
        return new ApiInfoBuilder()
                .title("Spring Data")
                .description("Spring Data 学习记录")
                .contact(contact)
                .version("1.0")
                .build();
    }
}

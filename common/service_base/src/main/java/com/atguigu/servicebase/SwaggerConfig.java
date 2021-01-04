package com.atguigu.servicebase;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:24 2020/12/1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(webApiInfo())
                .groupName("zcw")
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    //配置swagger信息 = apiInfo
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("网站-设备维修API文档")
                .description("本文档描述了设备维修微服务接口定义")
                .version("1.0")
                .contact(new Contact("andrewBar", "http://atguigu.com", "1107210105@qq.com"))
                .build();
    }

}

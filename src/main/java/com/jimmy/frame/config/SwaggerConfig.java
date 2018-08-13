package com.jimmy.frame.config;

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
 * @version: V1.0
 * @author: Jimmy
 * @className: SwaggerConfig
 * @description: Swagger配置文件
 * @data: 2018-08-01 19:14
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "Zhongyuan Wang";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("frameModular")
                .select()
                //加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.jimmy.frame"))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
                //.ignoredParameterTypes(ApiIgnore.class)
                //.enableUrlTemplating(true);
    }

    @Bean
    public Docket createMonitorRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("wmsModular")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jimmy.wms"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("API文档")
                //设置文档的描述
                .description("W Rapid Development Framework项目API文档")
                //设置文档的版本信息
                .version(VERSION)
                //作者信息
                .contact(new Contact(AUTHOR, "https://my.csdn.net/qq_16962599", "wangzhongzhi521@qq.com"))
                //设置项目地址信息
                .termsOfServiceUrl("https://my.csdn.net/qq_16962599")
                //设置项目许可证信息
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}

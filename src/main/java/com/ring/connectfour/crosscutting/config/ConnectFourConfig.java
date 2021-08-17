package com.ring.connectfour.crosscutting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class ConnectFourConfig {

    @Bean
    public Docket connectFourConfigApi() {
        Set<String> responseProduceType = new HashSet<String>();
        responseProduceType.add("application/json");
        responseProduceType.add("application/xml");
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .produces(responseProduceType)
                .consumes(responseProduceType)
                .apiInfo(apiInfo());

    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ConnectFour Service")
                .description("APIResful Gateway belong to ConnectFourConfig app which you can find all signatures, operations and other activities relate to ConnectFourConfig app.")
                .license("ConnectFourConfig API License")
                .licenseUrl("moballiachi")
                .termsOfServiceUrl("moballiachi")
                .version("1.0.0")
                .contact(new Contact("","", "moballiachi@gmail.com"))
                .build();
    }
}

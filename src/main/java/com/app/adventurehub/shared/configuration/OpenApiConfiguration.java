package com.app.adventurehub.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("AdventureHub API")
                        .version("1.0.0")
                        .termsOfService("https://adventurehub.com/tos")
                        .license(new License().name("Apache 2.0 License").url("https://adventurehub.com/license"))
                        .contact(new Contact()
                                .url("https://adventurehub.studio")
                                .name("ADVENTUREHUB.studio")));
    }
}

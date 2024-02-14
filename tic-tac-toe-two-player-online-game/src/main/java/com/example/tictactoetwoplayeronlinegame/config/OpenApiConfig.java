package com.example.tictactoetwoplayeronlinegame.config;

import com.example.tictactoetwoplayeronlinegame.controller.InvitationController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Tic Tac Toe Two Player Game API Collection")
                        .version("1.0.0").description("This is the collection of APIs that are used to make the game"));
    }

}

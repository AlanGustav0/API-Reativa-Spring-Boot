package com.digitalinnovationone.apiheroes.config;


import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


public class CosmosConfig {



    @Bean
    public RouterFunction<ServerResponse> getHeroes(HeroesHandler heroesService){
        return RouterFunctions
                .route(GET("/apiheroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::findAll)
                .andRoute(GET("/apiheroes/{id}").and(accept(MediaType.APPLICATION_JSON)), heroesService::findById)
                .andRoute(POST("/apiheroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::save);

    }







}

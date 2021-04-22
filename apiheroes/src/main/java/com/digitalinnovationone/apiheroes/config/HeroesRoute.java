package com.digitalinnovationone.apiheroes.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class HeroesRoute {


    @Bean
    public RouterFunction<ServerResponse> route(HeroesHandler heroesService){
        return RouterFunctions
                .route(GET("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::findAll)
                .andRoute(GET("/heroes/{id}").and(accept(MediaType.APPLICATION_JSON)), heroesService::findById)
                .andRoute(POST("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::save);
                //.andRoute(DELETE("/heroes/{id}").and(accept(MediaType.APPLICATION_JSON)), heroesService::deleteByIdHero);

    }







}

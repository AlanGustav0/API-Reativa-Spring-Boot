package com.digitalinnovationone.apiheroes.functional_controller;


import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


//Esta classe é responsável por criar a rota dos métodos contidos na classe HeroesHandler
//@Configuration
public class HeroesRoute {


    //@Bean
    public RouterFunction<ServerResponse> route(HeroesHandler heroesService){
        return RouterFunctions
                .route(GET("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::findAll)
                .andRoute(GET("/heroes/{id}").and(accept(MediaType.APPLICATION_JSON)), heroesService::findById)
                .andRoute(POST("/heroes").and(accept(MediaType.APPLICATION_JSON)), heroesService::save);
              

    }







}

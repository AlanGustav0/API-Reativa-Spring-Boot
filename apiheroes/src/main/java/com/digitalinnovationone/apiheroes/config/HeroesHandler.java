package com.digitalinnovationone.apiheroes.config;


import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.service.HeroesService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;


@Component
public class HeroesHandler<T extends ServerResponse>{

    @Autowired
    HeroesService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Heroes.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Heroes.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Heroes> playlist = request.bodyToMono(Heroes.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(service::save), Heroes.class));
    }
}

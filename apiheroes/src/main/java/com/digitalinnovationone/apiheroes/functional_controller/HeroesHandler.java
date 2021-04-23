package com.digitalinnovationone.apiheroes.functional_controller;


import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;


/*Esta classe trata-se de um Bean que é gerenciado pelo Spring, por este motivo usamos o "@Component", ela
é a maneira funcional de realizar as mesmas ações que a classe controller realiza, mas para um fluxo reativo
 */
//@Component
public class HeroesHandler {

    @Autowired
    HeroesService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Heroes.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Heroes.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Heroes> hero = request.bodyToMono(Heroes.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(hero.flatMap(service::save), Heroes.class));
    }


}

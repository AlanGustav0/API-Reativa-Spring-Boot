package com.digitalinnovationone.apiheroes.service;


import com.digitalinnovationone.apiheroes.document.Heroes;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//Interface Service que implementa os métodos de findAll, find, save e delete
public interface HeroesService {

    Flux<Heroes> findAll();

    Mono<Heroes> findById(String id);

    Mono<Heroes> save(Heroes heroes);

    Mono<Void> deleteByIdHero(String id);
}

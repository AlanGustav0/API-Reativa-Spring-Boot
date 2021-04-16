package com.digitalinnovationone.apiheroes.service;


import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.repository.HeroesRepositoryCosmos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

    @Autowired
    private HeroesRepositoryCosmos heroesRepository;

    public Flux<Heroes> findAll(){
        return heroesRepository.findAll();
    }

    public Mono<Heroes> findById(String id){
        return heroesRepository.findById(id);
    }

    public Mono<Heroes> save(Heroes heroes){
        return heroesRepository.save(heroes);
    }

    public Mono<Boolean> deleteByIdHero(String id){
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}

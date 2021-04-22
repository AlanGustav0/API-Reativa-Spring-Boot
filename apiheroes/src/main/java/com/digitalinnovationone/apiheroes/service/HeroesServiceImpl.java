package com.digitalinnovationone.apiheroes.service;

import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesServiceImpl implements HeroesService {

    @Autowired
    HeroesRepository heroesRepository;


    @Override
    public Flux<Heroes> findAll() {
        return heroesRepository.findAll();
    }

    @Override
    public Mono<Heroes> findById(String id) {
        return heroesRepository.findById(id);
    }

    @Override
    public Mono<Heroes> save(Heroes heroes) {
        return heroesRepository.save(heroes);
    }

    @Override
    public Mono<Void> deleteByIdHero(String id) {
        return heroesRepository.deleteById(id);
    }
}

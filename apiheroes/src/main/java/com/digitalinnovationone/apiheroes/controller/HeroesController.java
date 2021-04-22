package com.digitalinnovationone.apiheroes.controller;

import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.digitalinnovationone.apiheroes.constants.HerosConstant.HEROES_ENDPOINT_LOCAL;

/*Classe controller onde implementamos os endpoints, estes serão os métodos responsáveis por fazer de fato
as ações de buscas todos os dados, salvar por ID, deletar por ID e criar um novo herói.
 */
//@RestController
public class HeroesController {

    @Autowired
    HeroesService heroesService;

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllHeroes(){
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL+"/{id}")
    public Mono<Heroes> findByIdHero(@PathVariable String id){
        return heroesService.findById(id);
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes){
        return heroesService.save(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL+"/id")
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<HttpStatus> deleteByHeroId(@PathVariable String id){
        return Mono.just(HttpStatus.OK);
    }


}

package com.digitalinnovationone.apiheroes.repository;

import com.digitalinnovationone.apiheroes.document.Heroes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HeroesRepository extends ReactiveMongoRepository<Heroes,String>{
}

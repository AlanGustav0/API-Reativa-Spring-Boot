package com.digitalinnovationone.apiheroes.config;

import java.util.UUID;
import com.digitalinnovationone.apiheroes.document.Heroes;
import com.digitalinnovationone.apiheroes.repository.HeroesRepositoryCosmos;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
@AllArgsConstructor
public class HeroesData  implements CommandLineRunner {

	private final HeroesRepositoryCosmos heroesRepositoryCosmos;

    public void run(String... args) throws Exception {

        String universe = "Marvel";
        int films = 3;

        heroesRepositoryCosmos.deleteAll()
                .thenMany(
                        Flux.just("Thor")
                                .map(name -> new Heroes(UUID.randomUUID().toString(), name,universe,films))
                                .flatMap(heroesRepositoryCosmos::save))
                .subscribe(System.out::println);
    }
}

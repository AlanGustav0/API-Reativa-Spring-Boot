package com.digitalinnovationone.apiheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ApiheroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiheroesApplication.class, args);

		System.out.println("Super Webflux Turn On!");

		Flux<String> colorFlux = Flux.just("black", "white", "blue");

		colorFlux
				.log()
				.map(String::toUpperCase);
	}

}

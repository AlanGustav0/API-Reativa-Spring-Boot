package com.digitalinnovationone.apiheroes;


//@Component
//@AllArgsConstructor
//public class HeroesData  implements CommandLineRunner {
//
//    //Instanciamos o repository para ter acesso aos métodos da interface repository
//    @Autowired
//	private final HeroesRepositoryCosmos heroesRepositoryCosmos;
//
//    public void run(String... args) throws Exception {
//
//        String universe = "DC";
//        int films = 3;
//
//        //Pega toda a lista de heroes e apaga, para posteriormente através de de um fluxo de stream, pegar os dados e salvar no banco de dados
//        heroesRepositoryCosmos.deleteAll()
//                .thenMany(
//                        Flux.just("Thor")
//                                .map(name -> new Heroes("1", name,universe,films))
//                                .flatMap(heroesRepositoryCosmos::save))
//                .subscribe(System.out::println);
//
//        heroesRepositoryCosmos.deleteAll()
//                .thenMany(
//                        Flux.just("Batman")
//                                .map(name -> new Heroes("2", name,universe,films))
//                                .flatMap(heroesRepositoryCosmos::save))
//                .subscribe(System.out::println);
//    }
//}

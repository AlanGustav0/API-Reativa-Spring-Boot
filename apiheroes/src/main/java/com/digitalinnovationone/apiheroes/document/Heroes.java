package com.digitalinnovationone.apiheroes.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class Heroes {

    @Id
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String universe;
    @Getter @Setter
    private int films;

}

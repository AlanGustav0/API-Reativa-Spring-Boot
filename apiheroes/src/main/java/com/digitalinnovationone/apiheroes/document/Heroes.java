package com.digitalinnovationone.apiheroes.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Heroes {

    @Id
    @Generated
    private String id;
    private String name;
    private String universe;
    private int films;

}

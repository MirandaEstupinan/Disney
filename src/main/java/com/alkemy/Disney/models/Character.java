package com.alkemy.Disney.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Setter(AccessLevel.NONE)
    private long id;

    private String name;
    private int age;
    private double weight;
    private String history;
    private String image;


    @OneToMany(mappedBy="character", orphanRemoval = true, fetch=FetchType.EAGER)
    private Set<MoSeCharacter> moSeCharacters  = new HashSet<>();

    public Character(String name, int age, double weight, String history, String image) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.image = image;
    }

/*    public Character(String name, int age, double weight, String history, String image, Set<MoSeCharacter> moSeCharacters) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.image = image;
        this.moSeCharacters = moSeCharacters;
    }*/

   /* public Character(String name, String image){
        this.name = name;
        this.image = image;
    }*/
}

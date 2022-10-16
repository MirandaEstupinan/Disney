package com.alkemy.Disney.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MoSeCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Setter(AccessLevel.NONE)
    private long id;

    @ManyToOne
    @JoinColumn(name="character_id")
    private Character character;
    @ManyToOne
    @JoinColumn(name="MovieSerie_id")
    private MovieSerie movieSerie;

    private String nameCharacter;
    private String nameMovieSerie;
    private String typeGender;


    public MoSeCharacter(Character character, MovieSerie movieSerie) {
        this.character = character;
        this.movieSerie = movieSerie;
        this.nameCharacter = character.getName();
        this.nameMovieSerie = movieSerie.getTitle();
    }
}

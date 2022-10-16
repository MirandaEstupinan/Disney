package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.Character;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CharacterDTO {

    private Long id;
    private String name;
    private String image;
    private double weight;
    private String history;
    private int age;

    private List <String> movieSerie;

    public CharacterDTO(Character character) {
        this.name = character.getName();
        this.image = character.getImage();
        this.weight = character.getWeight();
        this.history = character.getHistory();
        this.age = character.getAge();
        this.id = character.getId();
        this.movieSerie = character.getMoSeCharacters().stream().map(moSeCharacter -> moSeCharacter.getMovieSerie()).map(movieSerie1 -> movieSerie1.getTitle()).collect(Collectors.toList());
    }
}

package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.MoSeCharacter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MoSeCharacterDTO {
    private long id;
    private String nameCharacter;
    private String nameMovieSerie;

    public MoSeCharacterDTO(MoSeCharacter moSeCharacter) {
        this.id = moSeCharacter.getId();
        this.nameCharacter = moSeCharacter.getCharacter().getName();
        this.nameMovieSerie = moSeCharacter.getMovieSerie().getTitle();
    }
}

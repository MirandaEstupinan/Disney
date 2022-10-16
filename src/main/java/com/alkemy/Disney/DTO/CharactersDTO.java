package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.Character;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CharactersDTO {
    private String name;
    private String image;

    public CharactersDTO(Character character) {
        this.name = character.getName();
        this.image = character.getImage();
    }


}

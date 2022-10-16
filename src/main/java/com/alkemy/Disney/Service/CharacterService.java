package com.alkemy.Disney.Service;


import com.alkemy.Disney.models.Character;

import java.util.List;

public interface CharacterService {
   public void saveCharacter(Character character);
   public List<Character> getCharacter();

    Character getCharacterById(Long id);

    void deleteCharacter(Character character);



    List <Character> findByName (String name);

    List <Character> findByAge(int age);

    List <Character> findByWeight(double weight);
}

package com.alkemy.Disney.Service.ImplementationService;

import com.alkemy.Disney.Service.CharacterService;
import com.alkemy.Disney.models.Character;
import com.alkemy.Disney.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterImplementationService implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    @Override
    public List<Character> getCharacter() {
        return characterRepository.findAll();
    }

    @Override
    public Character getCharacterById(Long id){
        return characterRepository.findById(id).get();
    }

    @Override
    public void deleteCharacter(Character character){
        characterRepository.delete(character);
    }

    @Override
    public List <Character> findByName(String name){
        return characterRepository.findAllByName(name);
    }

    @Override
    public List <Character> findByAge (int age){
        return characterRepository.findAllByAge(age);
    }

    @Override
    public List <Character> findByWeight (double weight){
        return characterRepository.findAllByWeight(weight);
    }


}

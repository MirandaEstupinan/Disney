package com.alkemy.Disney.repositories;

import com.alkemy.Disney.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CharacterRepository  extends JpaRepository<Character,Long> {

    List<Character> findAllByName(String name);

    List<Character> findAllByAge(int age);

    List<Character> findAllByWeight(double weight);
}

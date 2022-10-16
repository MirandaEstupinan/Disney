package com.alkemy.Disney.repositories;

import com.alkemy.Disney.models.Character;
import com.alkemy.Disney.models.MovieSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MovieSerieRepository extends JpaRepository<MovieSerie,Long> {

    List<MovieSerie> findAllByTitle(String title);
}

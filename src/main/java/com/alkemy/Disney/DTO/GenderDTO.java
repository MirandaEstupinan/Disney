package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.Gender;
import com.alkemy.Disney.models.MovieSerie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class GenderDTO {
    private long id;
    private String name;
    private String image;
    private Set<MovieSerieDTO> moviesSerie;

    public GenderDTO(Gender gender) {
        this.id = gender.getId();
        this.name = gender.getName();
        this.image = gender.getImage();
        this.moviesSerie = gender.getMovieSeries().stream().map(movieSerie -> new MovieSerieDTO(movieSerie)).collect(Collectors.toSet());
    }
}

package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.MovieSerie;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MovieDTO {

    private String image;
    private String title;
    private LocalDate creationDate;

    public MovieDTO(MovieSerie movieSerie){
        this.title = movieSerie.getTitle();
        this.image = movieSerie.getImage();
        this.creationDate = movieSerie.getCreationDate();
    }
}

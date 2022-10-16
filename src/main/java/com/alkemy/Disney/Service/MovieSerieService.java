package com.alkemy.Disney.Service;

import com.alkemy.Disney.models.MovieSerie;

import java.util.List;

public interface MovieSerieService {
    public MovieSerie saveMovieSerie(MovieSerie movieSerie);
    public List<MovieSerie> getMovieSerie();

    MovieSerie getMovieSerieById(Long id);


    void deleteMovieSerie(MovieSerie movieSerie);

    List <MovieSerie> findAllByTitle(String title);
}

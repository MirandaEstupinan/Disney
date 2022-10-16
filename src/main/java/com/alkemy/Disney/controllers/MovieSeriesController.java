package com.alkemy.Disney.controllers;

import com.alkemy.Disney.DTO.CharacterDTO;
import com.alkemy.Disney.DTO.CharactersDTO;
import com.alkemy.Disney.DTO.MovieDTO;
import com.alkemy.Disney.DTO.MovieSerieDTO;
import com.alkemy.Disney.Service.*;
import com.alkemy.Disney.models.*;
import com.alkemy.Disney.models.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieSeriesController {

    public final ClientService clientService;
    public final CharacterService characterService;
    public final MoSeCharacterService moSeCharacterService;
    public final MovieSerieService movieSerieService;
    public final GenderService genderService;


    @GetMapping("/movies")
    public List<MovieDTO> getMovies(@RequestParam (required = false) String title,@RequestParam (required = false) Long genderId, @RequestParam (required = false) String order){

        if(order != null){
            if(order.equals("ASC")) {
                List<MovieDTO> movieSerieList = movieSerieService.getMovieSerie().stream().map(movieSerie -> new MovieDTO(movieSerie)).collect(Collectors.toList());
                movieSerieList.sort(Comparator.comparing(MovieDTO::getCreationDate));
                return movieSerieList;
            }
            if(order.equals("DESC")) {
                List<MovieDTO> movieSerieList = movieSerieService.getMovieSerie().stream().map(movieSerie -> new MovieDTO(movieSerie)).collect(Collectors.toList());
                movieSerieList.sort(Comparator.comparing(MovieDTO::getCreationDate).reversed());
                return movieSerieList;
            }
        }

        if(title != null){
            return movieSerieService.findAllByTitle(title).stream().map(movieSerie -> new MovieDTO(movieSerie)).collect(Collectors.toList());
        }
        if(genderId != null){
            return genderService.getGenderById(genderId).getMovieSeries().stream().map(movieSerie -> new MovieDTO(movieSerie)).collect(Collectors.toList());
        }


        return movieSerieService.getMovieSerie().stream().filter(movieSerie -> movieSerie.getTypeMovieSerie().equals(TypeMovieSerie.MOVIE)).map(movieSerie -> new MovieDTO(movieSerie)).collect(Collectors.toList());
    }

    @GetMapping("/movie/details")
    public Set <MovieSerieDTO> getMovieDetails(){
        return movieSerieService.getMovieSerie().stream().map(movieSerie -> new MovieSerieDTO(movieSerie)).collect(Collectors.toSet());
    }

    @PostMapping("/movieSerie/created")
    public ResponseEntity<Object> createMovie(Authentication authentication, @RequestParam Long characterId, @RequestParam Long genderId, @RequestBody MovieSerieDTO movieSerieDTO){
        Gender gender = genderService.getGenderById(genderId);
        Character character = characterService.getCharacterById(characterId);


        MovieSerie movieSerie = new MovieSerie(movieSerieDTO.getImage(),movieSerieDTO.getTitle(),movieSerieDTO.getCreationDate(),movieSerieDTO.getQualification(),gender,movieSerieDTO.getTypeMovieSerie());
        movieSerieService.saveMovieSerie(movieSerie);
        MoSeCharacter newMoSeCharacter = new MoSeCharacter(character,movieSerie);
        moSeCharacterService.saveMoSeCharacter(newMoSeCharacter);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/movieSerie/edit")
    public ResponseEntity<Object> edit(Authentication authentication,@RequestBody MovieSerieDTO movieSerieDTO, @RequestParam Long movieSerieId) {
        Client admin = clientService.findUserByEmail(authentication.getName());
        MovieSerie movieSerie = movieSerieService.getMovieSerieById(movieSerieId);

        if (admin == null) {
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }

        movieSerie.setImage(movieSerieDTO.getImage());
        movieSerie.setTitle(movieSerieDTO.getTitle());
        movieSerie.setCreationDate(movieSerieDTO.getCreationDate());
        movieSerie.setQualification(movieSerieDTO.getQualification());
        movieSerieService.saveMovieSerie(movieSerie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/movie/delete")
    public ResponseEntity<Object> deleteCharacter(@RequestParam Long movieSerieId,Authentication authentication){
        Client client = clientService.findUserByEmail(authentication.getName());
        MovieSerie movieSerie = movieSerieService.getMovieSerieById(movieSerieId);

        if(client == null){
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }
        if(movieSerie == null){
            return new ResponseEntity<>("Character does not exist", HttpStatus.FORBIDDEN);
        }
        movieSerieService.deleteMovieSerie(movieSerie);
        return new ResponseEntity<>("Movie Deleted",HttpStatus.OK);
    }


}

package com.alkemy.Disney.controllers;
import com.alkemy.Disney.DTO.CharacterDTO;
import com.alkemy.Disney.DTO.CharactersDTO;
import com.alkemy.Disney.Service.*;
import com.alkemy.Disney.models.*;
import com.alkemy.Disney.models.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CharacterController {

    public final ClientService clientService;
    public final CharacterService characterService;
    public final MoSeCharacterService moSeCharacterService;
    public final MovieSerieService movieSerieService;
    public final GenderService genderService;




    @GetMapping("/characters")
    public Set<CharactersDTO> getCharacter(@RequestParam (required = false) String name, @RequestParam(required = false) Integer age, @RequestParam (required = false) Double weight, Long movieSerieId) {
        if(name != null){
           return characterService.findByName(name).stream().map(character -> new CharactersDTO(character)).collect(Collectors.toSet());
        }
        if(age != null){
            return characterService.findByAge(age).stream().map(character -> new CharactersDTO(character)).collect(Collectors.toSet());
        }
        if(weight != null){
            return characterService.findByWeight(weight).stream().map(character -> new CharactersDTO(character)).collect(Collectors.toSet());
        }
        if(movieSerieId != null){
            return movieSerieService.getMovieSerieById(movieSerieId).getMoSeCharacters().stream().map(moSeCharacter -> new CharactersDTO(moSeCharacter.getCharacter())).collect(Collectors.toSet());
        }
       return characterService.getCharacter().stream().map(character -> new CharactersDTO(character)).collect(Collectors.toSet());
    }

    @PostMapping("/create/character")
        public ResponseEntity<Object> createCharacter(Authentication authentication, @RequestBody CharacterDTO characterDTO, @RequestParam Long movieSerieId){
        Client client = clientService.findUserByEmail(authentication.getName());
        MovieSerie movieSerie = movieSerieService.getMovieSerieById(movieSerieId);


        if(client == null){
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }
        if(characterDTO.getName().isEmpty() ){
            return new ResponseEntity<>("Name is empty", HttpStatus.FORBIDDEN);
        }
        if(characterDTO.getHistory().isEmpty() ){
            return new ResponseEntity<>("History is empty", HttpStatus.FORBIDDEN);
        }
        if(characterDTO.getAge() <= 0){
            return new ResponseEntity<>("Age is empty", HttpStatus.FORBIDDEN);
        }
        if(characterDTO.getImage().isEmpty()){
            return new ResponseEntity<>("Image is empty", HttpStatus.FORBIDDEN);
        }
        if(characterDTO.getWeight() <= 0){
            return new ResponseEntity<>("Weight is empty", HttpStatus.FORBIDDEN);
        }

        Character character = new Character(characterDTO.getName(), characterDTO.getAge(), characterDTO.getWeight(), characterDTO.getHistory(), characterDTO.getImage());
        characterService.saveCharacter(character);
        MoSeCharacter moSeCharacter = new MoSeCharacter(character, movieSerie);
        moSeCharacterService.saveMoSeCharacter(moSeCharacter);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit/character")
    public ResponseEntity<Object> editCharacter(Authentication authentication, @RequestParam String name,@RequestParam int age, @RequestParam double weight,
    @RequestParam String history, @RequestParam String image, @RequestParam long id){
        Client client = clientService.findUserByEmail(authentication.getName());
        Character character = characterService.getCharacterById(id);
         Set <Long> characterId = characterService.getCharacter().stream().map(character1 -> character1.getId()).collect(Collectors.toSet());

         if(client == null){
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }
        if(!characterId.contains(id)){
            return new ResponseEntity<>("id does not exist", HttpStatus.FORBIDDEN);
        }

        character.setAge(age);
        character.setImage(image);
        character.setName(name);
        character.setHistory(history);
        character.setWeight(weight);
        characterService.saveCharacter(character);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/character/delete")
    public ResponseEntity<Object> deleteCharacter(@RequestParam Long characterId,Authentication authentication){
        Client client = clientService.findUserByEmail(authentication.getName());
        Character character = characterService.getCharacterById(characterId);

       if(client == null){
            return new ResponseEntity<>("Client does not exist", HttpStatus.FORBIDDEN);
        }
        if(character == null){
            return new ResponseEntity<>("Character does not exist", HttpStatus.FORBIDDEN);
        }
        characterService.deleteCharacter(character);
        return new ResponseEntity<>("Character Deleted",HttpStatus.OK);
    }

    @GetMapping("character/details")
    public Set<CharacterDTO> getCharacterDetails(){
        return characterService.getCharacter().stream().map(character -> new CharacterDTO(character)).collect(Collectors.toSet());
    }


}

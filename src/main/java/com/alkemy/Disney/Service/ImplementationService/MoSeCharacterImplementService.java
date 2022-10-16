package com.alkemy.Disney.Service.ImplementationService;

import com.alkemy.Disney.Service.MoSeCharacterService;
import com.alkemy.Disney.models.MoSeCharacter;
import com.alkemy.Disney.repositories.MoSeCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoSeCharacterImplementService implements MoSeCharacterService {
    @Autowired
    private MoSeCharacterRepository moSeCharacterRepository;

    @Override
    public MoSeCharacter saveMoSeCharacter(MoSeCharacter moSeCharacter){
        return moSeCharacterRepository.save(moSeCharacter);
    }
    @Override
    public List<MoSeCharacter> getMoSeCharacter() {
        return moSeCharacterRepository.findAll();
    }

    @Override
    public void deleteMoSeCharacter(MoSeCharacter moSeCharacter){
        moSeCharacterRepository.delete(moSeCharacter);
    }

    @Override
    public MoSeCharacter getMoSeCharacterById(Long id){
        return moSeCharacterRepository.findById(id).get();
    }
}

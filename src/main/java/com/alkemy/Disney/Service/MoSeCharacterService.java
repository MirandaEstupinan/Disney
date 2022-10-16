package com.alkemy.Disney.Service;

import com.alkemy.Disney.models.Character;
import com.alkemy.Disney.models.MoSeCharacter;

import java.util.List;

public interface MoSeCharacterService {
    public MoSeCharacter saveMoSeCharacter(MoSeCharacter moSeCharacter);
    public List<MoSeCharacter> getMoSeCharacter();



    void deleteMoSeCharacter(MoSeCharacter moSeCharacter);

    MoSeCharacter getMoSeCharacterById(Long id);
}

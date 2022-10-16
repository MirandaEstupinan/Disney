package com.alkemy.Disney.Service.ImplementationService;

import com.alkemy.Disney.Service.GenderService;
import com.alkemy.Disney.models.Gender;
import com.alkemy.Disney.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderImplementationService implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Gender saveGender(Gender gender){
        return genderRepository.save(gender);
    }
    @Override
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }


    @Override
    public void deleteGender(Gender gender){
        genderRepository.delete(gender);
    }

    @Override
    public Gender getGenderById(Long Id){
        return genderRepository.findById(Id).get();
    }
}

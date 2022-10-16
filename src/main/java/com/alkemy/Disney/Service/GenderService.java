package com.alkemy.Disney.Service;

import com.alkemy.Disney.models.Gender;

import java.util.List;

public interface GenderService {
    public Gender saveGender(Gender gender);
    public List<Gender> getGenders();

    void deleteGender(Gender gender);

    Gender getGenderById(Long Id);
}

package com.alkemy.Disney.repositories;

import com.alkemy.Disney.models.MoSeCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoSeCharacterRepository extends JpaRepository<MoSeCharacter,Long> {
}

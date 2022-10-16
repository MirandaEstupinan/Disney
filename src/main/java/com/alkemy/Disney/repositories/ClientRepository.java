package com.alkemy.Disney.repositories;

import com.alkemy.Disney.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.userdetails.User;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
}
package com.alkemy.Disney.Service;

import com.alkemy.Disney.models.Client;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface ClientService {
    public Client getUserById(Long Id);
    public Client findUserByEmail(String email);
    public List<Client> getClients();
    public  Client saveClient(Client client);
}

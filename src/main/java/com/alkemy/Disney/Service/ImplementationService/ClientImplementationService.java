package com.alkemy.Disney.Service.ImplementationService;

import com.alkemy.Disney.Service.ClientService;
import com.alkemy.Disney.models.Client;
import com.alkemy.Disney.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImplementationService implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getUserById(Long Id){
        return clientRepository.findById(Id).get();
    }
    @Override
    public Client findUserByEmail(String email){
        return clientRepository.findByEmail(email);
    }
    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
    @Override
    public Client saveClient(Client client){
       return clientRepository.save(client);
    }
}

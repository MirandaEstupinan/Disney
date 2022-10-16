package com.alkemy.Disney.DTO;

import com.alkemy.Disney.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
    }
}

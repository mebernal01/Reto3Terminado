package com.boat.repository;

import com.boat.model.ClientModel;
import com.boat.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClient() {
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer id) {
        return clientCrudRepository.findById(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
    public void delete(ClientModel clientModel){
        clientCrudRepository.delete(clientModel);
    }

    public ClientModel update(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
}

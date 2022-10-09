package com.boat.service;

import com.boat.model.AdminModel;
import com.boat.model.ClientModel;
import com.boat.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClient() {
        return clientRepository.getAllClient();
    }

    public Optional<ClientModel> getClient(Integer id) {
        return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel) {
        if (clientModel.getIdClient() == null) {
             return clientRepository.saveClient(clientModel);
        } else {
            Optional<ClientModel> clientEncontrado = getClient(clientModel.getIdClient());
            if (clientEncontrado.isEmpty()) {
                return clientRepository.saveClient(clientModel);
            } else {
                return clientModel;
            }
        }
    }
    public ClientModel update(ClientModel clientModel){
        if(clientModel.getIdClient() != null){
            Optional<ClientModel>clientEncontrado = getClient(clientModel.getIdClient());
            if (!clientEncontrado.isEmpty()) {
                if(clientModel.getName()!=null){
                    clientEncontrado.get().setName(clientModel.getName());
                }
                if(clientModel.getAge()!=null){
                    clientEncontrado.get().setAge(clientModel.getAge());
                }
                if(clientModel.getPassword()!=null){
                    clientEncontrado.get().setPassword(clientModel.getPassword());
                }
                return clientRepository.saveClient(clientEncontrado.get());
            }

        }
        return clientModel;
    }
    public boolean delete(int id){
        Boolean respuesta = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
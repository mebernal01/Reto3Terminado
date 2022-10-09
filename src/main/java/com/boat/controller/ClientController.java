package com.boat.controller;

import com.boat.model.ClientModel;
import com.boat.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<ClientModel> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional <ClientModel> getClient(@PathVariable int id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel saveClient(@RequestBody ClientModel clientModel){
        return clientService.saveClient(clientModel);
    }

}

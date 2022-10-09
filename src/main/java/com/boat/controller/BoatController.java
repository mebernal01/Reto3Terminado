package com.boat.controller;


import com.boat.model.BoatModel;
import com.boat.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<BoatModel> getAll(){
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoat(@PathVariable("id") Integer id){ //
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel save(@RequestBody BoatModel boatModel){
        return boatService.save(boatModel);
    }

}



package com.boat.service;

import com.boat.model.AdminModel;
import com.boat.model.BoatModel;
import com.boat.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<BoatModel> getAll() {
        return boatRepository.getAll();
    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatRepository.getBoatModel(id);
    }

    public BoatModel save(BoatModel boat) {
        return boatRepository.save(boat);
    }

    public boolean deleteBoat(Integer id) {
        Boolean resultado = getBoat(id).map(boatPorEliminar ->{
            boatRepository.delete(boatPorEliminar);
            return true;
        }).orElse(false);

        return resultado;
    }

    public BoatModel update(BoatModel boat) {
        if(boat.getId() != null){
            Optional<BoatModel>boatEncontrado = boatRepository.getBoatModel(boat.getId());
            if(!boatEncontrado.isEmpty()){
                if(boat.getBrand() != null){
                    boatEncontrado.get(). setBrand(boat.getBrand());
                }
                if(boat.getName() != null ){
                    boatEncontrado.get().setName(boat.getName());
                }
                if(boat.getYear() != null ){
                    boatEncontrado.get().setYear(boat.getYear());
                }
                if(boat.getDescription() != null ){
                    boatEncontrado.get().setDescription(boat.getDescription());
                }
                return boatRepository.save(boatEncontrado.get());
            }
        }
        return boat;
    }
    public boolean delete(Integer id){
        Boolean respuesta = getBoat(id).map(elemento ->{
            boatRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}

package com.boat.repository;

import com.boat.model.BoatModel;
import com.boat.repository.crudrepository.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {

    @Autowired //inyeccion de dependecias este se encarga de inicializar el Crud
    private BoatCrudRepository boatCrudRepository;

    public List<BoatModel> getAll(){
        return (List<BoatModel>) boatCrudRepository.findAll();
    }

    public Optional<BoatModel> getBoatModel(Integer id){
        return boatCrudRepository.findById(id);
    }

    public BoatModel save(BoatModel boat){
        return boatCrudRepository.save(boat);
    }

    public void delete(BoatModel boat){
        boatCrudRepository.delete(boat);
    }
}

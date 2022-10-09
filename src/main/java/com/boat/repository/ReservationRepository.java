package com.boat.repository;

import com.boat.model.ReservationModel;
import com.boat.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll(){
        return(List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getById(int id){
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel save(ReservationModel reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(ReservationModel reservation){
        reservationCrudRepository.delete(reservation);
    }
}
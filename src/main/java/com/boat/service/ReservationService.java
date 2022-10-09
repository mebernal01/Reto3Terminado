package com.boat.service;

import com.boat.model.ReservationModel;
import com.boat.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<ReservationModel> getReservation(int id) {
        return reservationRepository.getById(id);
    }

    public ReservationModel save(ReservationModel reservation) {
        return reservationRepository.save(reservation);
    
    }

    public ReservationModel update(ReservationModel reservation) {
        if(reservation.getIdReservation() != null){
            Optional<ReservationModel>reservationEncontrado = reservationRepository.getById(reservation.getIdReservation());
            if(!reservationEncontrado.isEmpty()){
                if (reservation.getStartDate()!=null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationEncontrado.get());
            }
        }
        return reservation;
    }
    public boolean delete(int id){
        Boolean respuesta = getReservation(id).map(elemento ->{
            reservationRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
package com.boat.service;

import com.boat.model.ReservationModel;
import com.boat.model.custom.CountClient;
import com.boat.model.custom.StatusAmount;
import com.boat.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }

    // Listar las reservaciones canceladas y las completadas
    public StatusAmount getStatusReport() {
        List<ReservationModel> completed = reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        StatusAmount statAmt = new StatusAmount(completed.size(), cancelled.size());
        return statAmt;
    }

    // Listar reservaciones entre un periodo de fechas
    public List<ReservationModel> getReservationPeriod(String d1, String d2) {
        // Formatear fecha
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }


}
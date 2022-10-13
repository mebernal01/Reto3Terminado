package com.boat.repository.crudrepository;

import com.boat.model.ReservationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
    @Query("SELECT r.client, COUNT(r.client) FROM ReservationModel AS r GROUP BY r.client ORDER BY COUNT(r.client) desc")
    public List<Object[]> countTotalReservationByClient();

    // Reservaciones entre dos fechas
    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // Resevaciones canceladas y completadas (Atributo 'status')
    public List<ReservationModel> findAllByStatus(String status);



}
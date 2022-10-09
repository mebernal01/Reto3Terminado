package com.boat.repository.crudrepository;

import com.boat.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
}

package com.boat.repository.crudrepository;

import com.boat.model.BoatModel;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrudRepository extends CrudRepository<BoatModel, Integer> {
}

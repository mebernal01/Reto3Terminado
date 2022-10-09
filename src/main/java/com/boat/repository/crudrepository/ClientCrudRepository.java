package com.boat.repository.crudrepository;

import com.boat.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel,Integer> {

}

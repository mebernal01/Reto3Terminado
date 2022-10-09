package com.boat.repository.crudrepository;

import com.boat.model.AdminModel;
import org.springframework.data.repository.CrudRepository;


public interface AdminCrudRepository extends CrudRepository<AdminModel, Integer> {

}

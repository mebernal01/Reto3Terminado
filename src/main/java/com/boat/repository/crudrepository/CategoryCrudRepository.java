package com.boat.repository.crudrepository;

import com.boat.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {

}

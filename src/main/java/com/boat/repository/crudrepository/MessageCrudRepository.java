package com.boat.repository.crudrepository;

import com.boat.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {

}

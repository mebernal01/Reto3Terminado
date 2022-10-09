package com.boat.repository;

import com.boat.model.MessageModel;
import com.boat.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

  @Autowired
  private MessageCrudRepository messageCrudRepository;

  public List<MessageModel> getAllMessage(){
      return (List<MessageModel>) messageCrudRepository.findAll();
  }

  public Optional<MessageModel> getMessage(Integer id) {
      return messageCrudRepository.findById(id);
  }

  public MessageModel save(MessageModel messageModel){
      return messageCrudRepository.save(messageModel);
  }

  public void delete(MessageModel messageModel){
      messageCrudRepository.delete(messageModel);

  }

  public MessageModel update(MessageModel messageModel){
      return messageCrudRepository.save(messageModel);
  }
}

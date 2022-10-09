package com.boat.service;

import com.boat.model.MessageModel;
import com.boat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessage() {
        return messageRepository.getAllMessage();
    }

    public Optional<MessageModel> getMessage(Integer id) {
        return messageRepository.getMessage(id);
    }
    public MessageModel save(MessageModel message) {
        return messageRepository.save(message);
    }

    public boolean delete(Integer id) {
        Boolean resultado = getMessage(id).map(messagePorEliminar ->{
            messageRepository.delete(messagePorEliminar);
            return true;
        }).orElse(false);

        return resultado;
    }

    public MessageModel update(MessageModel message) {
        if(message.getIdMessage() != null){
            Optional<MessageModel>mesageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if(!mesageEncontrado.isEmpty()){
                if(message.getMessageText() != null){
                    mesageEncontrado.get(). setMessageText(message.getMessageText());
                }
                return messageRepository.save(mesageEncontrado.get());
            }
        }
        return message;
    }
    public boolean delete(int id){
        Boolean respuesta = getMessage(id).map(elemento ->{
            messageRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
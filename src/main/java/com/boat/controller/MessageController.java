package com.boat.controller;

import com.boat.model.MessageModel;
import com.boat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;
    @GetMapping("/all")
    @Column(name ="email", nullable = false, length = 250)
    public List<MessageModel> getAllMessage(){
        return messageService.getAllMessage();
    }

    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable Integer id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel save(@RequestBody MessageModel messageModel){
        return messageService.save(messageModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return messageService.delete(id);
    }

    @PutMapping("/update")
    public MessageModel update(@RequestBody MessageModel messageModel){
        return messageService.update(messageModel);
    }



}

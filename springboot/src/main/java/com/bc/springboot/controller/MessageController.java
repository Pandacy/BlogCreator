package com.bc.springboot.controller;

import com.bc.springboot.model.Message;
import com.bc.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/message", produces = "application/json")
public class MessageController {
    @Autowired
    private MessageService messageService;

    public MessageController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Message>> getMessageById(@PathVariable final int id) {
        return ResponseEntity.ok(messageService.getByBlogId(id));
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessage(){
        List<Message> allMessage = messageService.getMessages();
        return ResponseEntity.ok(allMessage);
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody final Message messageFromRequest) {
        messageService.AddMessage(messageFromRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(messageService.getMessageById(messageFromRequest.getId())).toUri();
        return ResponseEntity.created(uri).body(messageFromRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Message> put(@RequestBody final Message messageFromRequest, @PathVariable final int id) {
        messageFromRequest.setId(id);
        messageService.UpdateMessage(messageFromRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(messageFromRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(messageFromRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Message>> delete(@PathVariable final int id){
        messageService.DeleteMessage(id);
        List<Message> allMessages = messageService.getMessages();
        return ResponseEntity.ok(allMessages);
    }
}

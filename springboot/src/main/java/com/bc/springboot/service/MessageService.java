package com.bc.springboot.service;

import com.bc.springboot.model.Message;
import com.bc.springboot.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private IMessageRepository messageRepository;

    public void AddMessage(Message message)
    {
        messageRepository.save(message);
    }

    public List<Message> getMessages()
    {
        return messageRepository.findAll();
    }

    public Message getMessageById(int id)
    {
        return messageRepository.findById(id).orElse(null);
    }

    public Message getByBlogId(int id) {
        return messageRepository.findByBlogId(id);
    }

    public String DeleteMessage(int id){
        messageRepository.deleteById(id);
        return "Object Deleted";
    }

    public Message UpdateMessage(Message message){
        Message messageData = messageRepository.findById(message.getId()).orElse(null);
        messageData.setContent(message.getContent());
        messageData.setVotes(message.getVotes());
        return messageRepository.save(messageData);
    }
}

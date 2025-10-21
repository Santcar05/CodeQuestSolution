package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.ChatMessage;
import org.javeriana.codequest.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public void save(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }

    public void delete(ChatMessage chatMessage) {
        chatMessageRepository.delete(chatMessage);
    }

    public void deleteById(Long id) {
        chatMessageRepository.deleteById(id);
    }

    public ChatMessage findById(Long id) {
        return chatMessageRepository.findById(id).orElse(null);
    }

    public List<ChatMessage> findAll() {
        return chatMessageRepository.findAll();
    }

}

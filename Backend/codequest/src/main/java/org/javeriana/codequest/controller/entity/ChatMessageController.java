package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.ChatMessage;
import org.javeriana.codequest.service.entity.ChatMessageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/chatMessages")
public class ChatMessageController {

    private ChatMessageService chatMessageService;

    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/all")
    public List<ChatMessage> findAll() {
        return chatMessageService.findAll();
    }

    @GetMapping("/{id}")
    public ChatMessage findById(@PathVariable Long id) {
        return chatMessageService.findById(id);
    }

}

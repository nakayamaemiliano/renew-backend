package com.example.RenewApp2.Service;

import com.example.RenewApp2.Entity.Chat;
import com.example.RenewApp2.Repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> listarChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> obtenerChatPorId(Integer id) {
        return chatRepository.findById(id);
    }

    public Chat crearChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public void eliminarChat(Integer id) {
        chatRepository.deleteById(id);
    }
}

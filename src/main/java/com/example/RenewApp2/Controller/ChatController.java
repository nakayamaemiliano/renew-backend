package com.example.RenewApp2.Controller;

import com.example.RenewApp2.Entity.Chat;
import com.example.RenewApp2.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public ResponseEntity<List<Chat>> listarChats() {
        List<Chat> chats = chatService.listarChats();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> obtenerChatPorId(@PathVariable Integer id) {
        Optional<Chat> chat = chatService.obtenerChatPorId(id);
        return chat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chat> crearChat(@RequestBody Chat chat) {
        Chat nuevoChat = chatService.crearChat(chat);
        return new ResponseEntity<>(nuevoChat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarChat(@PathVariable Integer id) {
        chatService.eliminarChat(id);
        return ResponseEntity.noContent().build();
    }

}

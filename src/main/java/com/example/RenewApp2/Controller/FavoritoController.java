package com.example.RenewApp2.Controller;

import com.example.RenewApp2.Entity.Favorito;
import com.example.RenewApp2.Service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("favoritos")
@CrossOrigin(origins = "http://localhost:5173")
public class FavoritoController {
    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public List<Favorito> listarFavoritos() {
        return favoritoService.listarFavoritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> obtenerFavoritoPorId(@PathVariable Integer id) {
        Optional<Favorito> favorito = favoritoService.obtenerFavoritoPorId(id);
        return favorito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Favorito> crearFavorito(@RequestBody Favorito favorito) {
        Favorito nuevoFavorito = favoritoService.crearFavorito(favorito);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFavorito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFavorito(@PathVariable Integer id) {
        favoritoService.eliminarFavorito(id);
        return ResponseEntity.noContent().build();
    }

}

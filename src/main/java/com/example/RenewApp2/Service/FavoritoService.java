package com.example.RenewApp2.Service;

import com.example.RenewApp2.Entity.Favorito;
import com.example.RenewApp2.Repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> listarFavoritos() {
        return favoritoRepository.findAll();
    }

    public Optional<Favorito> obtenerFavoritoPorId(Integer id) {
        return favoritoRepository.findById(id);
    }

    public Favorito crearFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void eliminarFavorito(Integer id) {
        favoritoRepository.deleteById(id);
    }
}

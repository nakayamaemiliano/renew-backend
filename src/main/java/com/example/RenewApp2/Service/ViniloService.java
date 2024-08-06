package com.example.RenewApp2.Service;

import com.example.RenewApp2.Entity.Vinilo;
import com.example.RenewApp2.Repository.ViniloRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ViniloService {
    @Autowired
    ViniloRepository viniloRepository;

    public List<Vinilo> listarVinilos() {

        return viniloRepository.findAll();
    }

    public Optional<Vinilo> obtenerViniloPorId(Integer id) {

        return viniloRepository.findById(id);
    }

    public Vinilo crearVinilo(Vinilo vinilo) {

        return viniloRepository.save(vinilo);
    }

    public Vinilo actualizarVinilo(Integer id, Vinilo viniloActualizado) {
        Vinilo vinilo = viniloRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vinilo con ID " + id + " no encontrado"));
        vinilo.setNombre(viniloActualizado.getNombre());
        vinilo.setArtista(viniloActualizado.getArtista());
        vinilo.setGenero(viniloActualizado.getGenero());
        vinilo.setAnio(viniloActualizado.getAnio());
        vinilo.setPrecio(viniloActualizado.getPrecio());

        return viniloRepository.save(vinilo);
    }

    public void eliminarVinilo(Integer id) {

        viniloRepository.deleteById(id);
    }

}

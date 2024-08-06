package com.example.RenewApp2.Controller;

import com.example.RenewApp2.Entity.Vinilo;
import com.example.RenewApp2.Service.ViniloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinilos")
@CrossOrigin(origins = "http://localhost:5173")
public class ViniloController {

    @Autowired
    private ViniloService viniloService;

    @GetMapping
    public List<Vinilo> listarVinilos() {
        return viniloService.listarVinilos();
    }

    @GetMapping("/{id}")
    public Vinilo obtenerViniloPorId(@PathVariable Integer id) {
        return viniloService.obtenerViniloPorId(id).orElseThrow();
    }

    @PostMapping
    public Vinilo crearVinilo(@RequestBody Vinilo vinilo) {
        return viniloService.crearVinilo(vinilo);
    }

    @PutMapping("/{id}")
    public Vinilo actualizarVinilo(@PathVariable Integer id, @RequestBody Vinilo viniloActualizado) {
        return viniloService.actualizarVinilo(id, viniloActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarVinilo(@PathVariable Integer id) {
        viniloService.eliminarVinilo(id);
    }


}

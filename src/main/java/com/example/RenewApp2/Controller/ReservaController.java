package com.example.RenewApp2.Controller;

import com.example.RenewApp2.Entity.Reserva;
import com.example.RenewApp2.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:5173")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Integer id) {
        return reservaService.obtenerReservaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Integer id, @RequestBody Reserva reservaActualizada) {
        try {
            Reserva reserva = reservaService.actualizarReserva(id, reservaActualizada);
            return ResponseEntity.ok(reserva);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
}

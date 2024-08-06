package com.example.RenewApp2.Service;

import com.example.RenewApp2.Entity.Reserva;
import com.example.RenewApp2.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerReservaPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow();
        reserva.setUsuario(reservaActualizada.getUsuario());
        reserva.setVinilo(reservaActualizada.getVinilo());
        reserva.setFechaReserva(reservaActualizada.getFechaReserva());
        reserva.setCantidad(reservaActualizada.getCantidad());
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }


}

package com.example.proyecto_android.Service;

import com.example.proyecto_android.Model.Jugador;
import com.example.proyecto_android.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> findById(Integer id) {
        return jugadorRepository.findById(id);
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteById(Integer id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> findJugadoresByEquipo(Integer idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }

    public List<Jugador> findJugadoresConMasDeXGoles(Integer goles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(goles);
    }
}
package com.example.proyecto_android.Service;

import com.example.proyecto_android.Model.EstadisticaJugador;
import com.example.proyecto_android.Repository.EstadisticaJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticaJugadorService {

    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    public List<EstadisticaJugador> findAll() {
        return estadisticaJugadorRepository.findAll();
    }

    public Optional<EstadisticaJugador> findById(Integer id) {
        return estadisticaJugadorRepository.findById(id);
    }

    public EstadisticaJugador save(EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    public void deleteById(Integer id) {
        estadisticaJugadorRepository.deleteById(id);
    }

    public Integer totalGolesPorEquipo(Integer idEquipo) {
        return estadisticaJugadorRepository.totalGolesPorEquipo(idEquipo);
    }
}
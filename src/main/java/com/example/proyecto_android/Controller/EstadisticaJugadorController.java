package com.example.proyecto_android.Controller;

import com.example.proyecto_android.Model.EstadisticaJugador;
import com.example.proyecto_android.Service.EstadisticaJugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@RequiredArgsConstructor
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService estadisticaJugadorService;

    @GetMapping
    public List<EstadisticaJugador> findAll() {
        return estadisticaJugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> findById(@PathVariable Integer id) {
        return estadisticaJugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstadisticaJugador save(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorService.save(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> update(@PathVariable Integer id, @RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorService.findById(id).map(e -> {
            estadistica.setIdEstadistica(id);
            return ResponseEntity.ok(estadisticaJugadorService.save(estadistica));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        estadisticaJugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 3: Total de goles por equipo
    @GetMapping("/goles/equipo/{idEquipo}")
    public Integer totalGolesPorEquipo(@PathVariable Integer idEquipo) {
        return estadisticaJugadorService.totalGolesPorEquipo(idEquipo);
    }
}
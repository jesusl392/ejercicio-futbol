package com.example.proyecto_android.Controller;

import com.example.proyecto_android.Model.Jugador;
import com.example.proyecto_android.Service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    public List<Jugador> findAll() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> findById(@PathVariable Integer id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador save(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(@PathVariable Integer id, @RequestBody Jugador jugador) {
        return jugadorService.findById(id).map(j -> {
            jugador.setIdJugador(id);
            return ResponseEntity.ok(jugadorService.save(jugador));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        jugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 1: Jugadores por equipo
    @GetMapping("/equipo/{idEquipo}")
    public List<Jugador> findByEquipo(@PathVariable Integer idEquipo) {
        return jugadorService.findJugadoresByEquipo(idEquipo);
    }

    // Consulta 2: Jugadores con más de X goles
    @GetMapping("/goles/{goles}")
    public List<Jugador> findByGoles(@PathVariable Integer goles) {
        return jugadorService.findJugadoresConMasDeXGoles(goles);
    }
}
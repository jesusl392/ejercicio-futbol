package com.example.proyecto_android.Controller;

import com.example.proyecto_android.Model.Partido;
import com.example.proyecto_android.Service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService partidoService;

    @GetMapping
    public List<Partido> findAll() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> findById(@PathVariable Integer id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido save(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> update(@PathVariable Integer id, @RequestBody Partido partido) {
        return partidoService.findById(id).map(p -> {
            partido.setIdPartido(id);
            return ResponseEntity.ok(partidoService.save(partido));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 4: Resultados con nombres de equipos
    @GetMapping("/resultados")
    public List<Object[]> findResultados() {
        return partidoService.findResultadosPartidos();
    }
}
package com.example.proyecto_android.Controller;

import com.example.proyecto_android.Model.Entrenador;
import com.example.proyecto_android.Service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> findAll() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> findById(@PathVariable Integer id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador save(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        return entrenadorService.findById(id).map(e -> {
            entrenador.setIdEntrenador(id);
            return ResponseEntity.ok(entrenadorService.save(entrenador));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        entrenadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
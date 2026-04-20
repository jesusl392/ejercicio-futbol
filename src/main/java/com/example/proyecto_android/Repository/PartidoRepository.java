package com.example.proyecto_android.Repository;

import com.example.proyecto_android.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    // Consulta 4: Resultados de todos los partidos con nombres de equipos
    @Query(value = "SELECT p.id_partido, p.fecha, p.estadio, " +
            "el.nombre AS equipo_local, ev.nombre AS equipo_visita, " +
            "p.goles_local, p.goles_visita " +
            "FROM partido p " +
            "JOIN equipo el ON p.equipo_local = el.id_equipo " +
            "JOIN equipo ev ON p.equipo_visita = ev.id_equipo", nativeQuery = true)
    List<Object[]> findResultadosPartidos();
}
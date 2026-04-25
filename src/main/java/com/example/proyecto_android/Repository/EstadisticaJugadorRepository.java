package com.example.proyecto_android.Repository;

import com.example.proyecto_android.Model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Integer> {

    // Consulta 3: Total de goles de un equipo en todos sus partidos
    @Query(value = "SELECT COALESCE(SUM(e.goles),0) FROM estadistica_jugador e " +
            "JOIN jugador j ON e.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("idEquipo") Integer idEquipo);
}
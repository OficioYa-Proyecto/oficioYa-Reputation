package edu.eci.dosw.oficioya.reputation.repository;

import java.util.UUID;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.eci.dosw.oficioya.reputation.domain.ServicioCalificable;

public interface ServicioCalificableRepository extends JpaRepository<ServicioCalificable, Integer> {

    Optional<ServicioCalificable> findBySolicitudId(UUID solicitudId);

    /** Servicios cumplidos (avisados por Service) de cada trabajador: filas {trabajadorId, total}. */
    @Query("select s.trabajadorId, count(s) from ServicioCalificable s where s.trabajadorId in :ids group by s.trabajadorId")
    List<Object[]> contarCumplidosPorTrabajador(@Param("ids") Collection<UUID> trabajadorIds);
}

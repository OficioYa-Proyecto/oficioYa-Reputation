package edu.eci.dosw.oficioya.reputation.repository;

import java.util.UUID;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.dosw.oficioya.reputation.domain.ReputacionTrabajador;

public interface ReputacionTrabajadorRepository extends JpaRepository<ReputacionTrabajador, Integer> {

    long countByEstado(edu.eci.dosw.oficioya.reputation.domain.EstadoTrabajador estado);

    Optional<ReputacionTrabajador> findByTrabajadorId(UUID trabajadorId);

    List<ReputacionTrabajador> findByTrabajadorIdIn(Collection<UUID> trabajadorIds);
}

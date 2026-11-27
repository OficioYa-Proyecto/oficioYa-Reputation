package edu.eci.dosw.oficioya.reputation.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.dosw.oficioya.reputation.domain.EstadoReporte;
import edu.eci.dosw.oficioya.reputation.domain.EstadoTrabajador;
import edu.eci.dosw.oficioya.reputation.domain.ReglasReputacion;
import edu.eci.dosw.oficioya.reputation.domain.Resena;
import edu.eci.dosw.oficioya.reputation.dto.EstadisticasReputacionResponse;
import edu.eci.dosw.oficioya.reputation.exception.SolicitudInvalidaException;
import edu.eci.dosw.oficioya.reputation.repository.ReporteResenaRepository;
import edu.eci.dosw.oficioya.reputation.repository.ResenaRepository;
import edu.eci.dosw.oficioya.reputation.repository.ReputacionTrabajadorRepository;

/**
 * Estadísticas agregadas de calificaciones y reportes para Reporting (RF-06 de Reporting).
 */
@Service
public class EstadisticasService {

    private final ResenaRepository resenaRepository;
    private final ReporteResenaRepository reporteRepository;
    private final ReputacionTrabajadorRepository reputacionTrabajadorRepository;

    public EstadisticasService(ResenaRepository resenaRepository, ReporteResenaRepository reporteRepository,
                               ReputacionTrabajadorRepository reputacionTrabajadorRepository) {
        this.resenaRepository = resenaRepository;
        this.reporteRepository = reporteRepository;
        this.reputacionTrabajadorRepository = reputacionTrabajadorRepository;
    }

    /** Reseñas visibles y reportes creados entre las dos fechas (ambas inclusive), y los trabajadores pausados hoy. */
    @Transactional(readOnly = true)
    public EstadisticasReputacionResponse calcular(LocalDate desde, LocalDate hasta) {
        if (desde.isAfter(hasta)) {
            throw new SolicitudInvalidaException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        LocalDateTime inicio = desde.atStartOfDay();
        LocalDateTime fin = hasta.plusDays(1).atStartOfDay().minusNanos(1);
        List<Integer> puntuaciones = resenaRepository.findByVisibleTrueAndFechaCreacionBetween(inicio, fin).stream()
                .map(Resena::getPuntuacion).toList();
        long reportados = reporteRepository.countByFechaReporteBetween(inicio, fin);
        long resueltos = reporteRepository.countByFechaReporteBetweenAndEstado(inicio, fin, EstadoReporte.RESUELTO);
        return new EstadisticasReputacionResponse(puntuaciones.size(), ReglasReputacion.promedio(puntuaciones),
                reportados, reportados - resueltos, resueltos,
                reputacionTrabajadorRepository.countByEstado(EstadoTrabajador.PAUSADO));
    }
}

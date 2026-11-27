package edu.eci.dosw.oficioya.reputation.dto;

import java.util.List;

/**
 * Datos agregados de un periodo para Reporting (vía Orchestrator). Sin datos personales.
 * {@code trabajadoresPausados} es el estado actual (no depende del periodo): Worker no los lista porque están ocultos.
 * {@code cumplidosPorTrabajador}: servicios cumplidos en el periodo por cuenta de trabajador.
 * {@code usuariosConActividadPorDia}: personas distintas por día con un servicio cumplido o una reseña.
 */
public record EstadisticasReputacionResponse(
        long totalResenas,
        double calificacionPromedio,
        long resenasReportadas,
        long reportesPendientes,
        long reportesResueltos,
        long trabajadoresPausados,
        List<CumplidosTrabajadorResponse> cumplidosPorTrabajador,
        List<ActividadDiaResponse> usuariosConActividadPorDia) {
}

package edu.eci.dosw.oficioya.reputation.dto;

/**
 * Datos agregados de un periodo para Reporting (vía Orchestrator). Sin datos personales.
 * {@code trabajadoresPausados} es el estado actual (no depende del periodo): Worker no los lista porque están ocultos.
 */
public record EstadisticasReputacionResponse(
        long totalResenas,
        double calificacionPromedio,
        long resenasReportadas,
        long reportesPendientes,
        long reportesResueltos,
        long trabajadoresPausados) {
}

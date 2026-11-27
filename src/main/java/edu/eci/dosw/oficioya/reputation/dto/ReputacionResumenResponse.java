package edu.eci.dosw.oficioya.reputation.dto;

import java.util.UUID;

/**
 * Resumen que consume Search (vía Orchestrator) para ordenar los resultados por reputación.
 * {@code trabajosCompletados} cuenta los servicios cumplidos que Service le avisó a Reputation.
 */
public record ReputacionResumenResponse(UUID trabajadorId, double reputacion, int totalResenas,
                                        int trabajosCompletados) {
}

package edu.eci.dosw.oficioya.reputation.dto;

import java.util.UUID;

/**
 * Servicios cumplidos de un trabajador en un periodo (según los avisos de Service). Reporting le pone el oficio con
 * los datos de Worker. Solo el id de la cuenta y un conteo: ningún dato personal.
 */
public record CumplidosTrabajadorResponse(UUID trabajadorId, long cantidad) {
}

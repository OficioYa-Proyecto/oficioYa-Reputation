package edu.eci.dosw.oficioya.reputation.dto;

/**
 * Personas distintas con actividad en Reputation un día: tuvieron un servicio cumplido (como trabajador o como
 * contratante) o escribieron una reseña. Solo la fecha (AAAA-MM-DD) y el conteo: ningún dato personal.
 */
public record ActividadDiaResponse(String fecha, long cantidad) {
}

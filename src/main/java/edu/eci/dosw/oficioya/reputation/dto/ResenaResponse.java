package edu.eci.dosw.oficioya.reputation.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.eci.dosw.oficioya.reputation.domain.Resena;
import edu.eci.dosw.oficioya.reputation.domain.TipoParte;

/**
 * Reseña de solo lectura. {@code autorId} es la cuenta en Users de quien la escribió: el front la usa para mostrar
 * su nombre y su foto, y así la reseña queda vinculada a una persona real. Nunca incluye correo ni teléfono.
 */
public record ResenaResponse(
        UUID codigo,
        UUID solicitudId,
        UUID autorId,
        TipoParte tipoAutor,
        TipoParte tipoCalificado,
        UUID calificadoId,
        int puntuacion,
        String comentario,
        LocalDateTime fechaCreacion) {

    public static ResenaResponse desde(Resena resena) {
        return new ResenaResponse(resena.getCodigo(), resena.getServicio().getSolicitudId(), resena.getAutorId(),
                resena.getTipoAutor(),
                resena.getTipoCalificado(), resena.getCalificadoId(), resena.getPuntuacion(), resena.getComentario(),
                resena.getFechaCreacion());
    }
}

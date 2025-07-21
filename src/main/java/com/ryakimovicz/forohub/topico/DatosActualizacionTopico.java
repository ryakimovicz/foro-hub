package com.ryakimovicz.forohub.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
) {
}
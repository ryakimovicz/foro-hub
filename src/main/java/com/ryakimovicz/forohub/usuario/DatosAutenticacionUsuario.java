package com.ryakimovicz.forohub.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank @Email String login,
        @NotBlank String contrasena
) {}
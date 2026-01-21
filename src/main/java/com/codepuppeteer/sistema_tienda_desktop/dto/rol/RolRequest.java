package com.codepuppeteer.sistema_tienda_desktop.dto.rol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RolRequest(
        @NotBlank(message = "El nombre del rol es obligatorio")
        @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
        String nombreRol,

        @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
        String descripcion,

        Boolean activo
) {}
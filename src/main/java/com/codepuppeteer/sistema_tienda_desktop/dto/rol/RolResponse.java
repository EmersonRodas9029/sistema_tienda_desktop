package com.codepuppeteer.sistema_tienda_desktop.dto.rol;

import java.time.LocalDateTime;

public record RolResponse(
        Integer id,
        String nombreRol,
        String descripcion,
        Boolean activo,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaActualizacion
) {}
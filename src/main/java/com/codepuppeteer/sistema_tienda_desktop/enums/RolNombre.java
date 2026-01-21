package com.codepuppeteer.sistema_tienda_desktop.enums;

public enum RolNombre {
    ADMIN,
    GERENTE,
    VENDEDOR,
    ALMACENERO;

    public static RolNombre fromString(String nombre) {
        try {
            return RolNombre.valueOf(nombre.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rol no válido: " + nombre);
        }
    }
}
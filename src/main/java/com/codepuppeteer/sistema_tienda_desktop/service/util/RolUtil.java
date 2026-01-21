package com.codepuppeteer.sistema_tienda_desktop.service.util;

import com.codepuppeteer.sistema_tienda_desktop.entity.Rol;
import com.codepuppeteer.sistema_tienda_desktop.enums.RolNombre;

public class RolUtil {

    private RolUtil() {
        // Utility class, no instancias
    }

    public static boolean isAdmin(Rol rol) {
        return rol != null && RolNombre.ADMIN.name().equals(rol.getNombreRol());
    }

    public static boolean isGerente(Rol rol) {
        return rol != null && RolNombre.GERENTE.name().equals(rol.getNombreRol());
    }

    public static boolean isVendedor(Rol rol) {
        return rol != null && RolNombre.VENDEDOR.name().equals(rol.getNombreRol());
    }

    public static boolean isAlmacenero(Rol rol) {
        return rol != null && RolNombre.ALMACENERO.name().equals(rol.getNombreRol());
    }

    public static boolean hasPermission(Rol rol, RolNombre requiredRol) {
        if (rol == null) return false;

        RolNombre rolActual = RolNombre.fromString(rol.getNombreRol());

        // Jerarquía de permisos (de mayor a menor)
        switch (requiredRol) {
            case ADMIN:
                return rolActual == RolNombre.ADMIN;
            case GERENTE:
                return rolActual == RolNombre.ADMIN || rolActual == RolNombre.GERENTE;
            case VENDEDOR:
                return rolActual == RolNombre.ADMIN || rolActual == RolNombre.GERENTE || rolActual == RolNombre.VENDEDOR;
            case ALMACENERO:
                return rolActual == RolNombre.ADMIN || rolActual == RolNombre.GERENTE || rolActual == RolNombre.ALMACENERO;
            default:
                return false;
        }
    }

    public static String getRolDisplayName(String nombreRol) {
        try {
            RolNombre rol = RolNombre.fromString(nombreRol);
            return switch (rol) {
                case ADMIN -> "Administrador";
                case GERENTE -> "Gerente";
                case VENDEDOR -> "Vendedor";
                case ALMACENERO -> "Almacenero";
            };
        } catch (IllegalArgumentException e) {
            return nombreRol;
        }
    }
}
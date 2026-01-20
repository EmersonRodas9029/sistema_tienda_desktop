-- V4__Create_proveedores_table.sql
CREATE TABLE IF NOT EXISTS proveedores (
                                           proveedor_id INT PRIMARY KEY AUTO_INCREMENT,
                                           nombre_proveedor VARCHAR(150) NOT NULL,
    ruc VARCHAR(20) UNIQUE,
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion VARCHAR(255),
    contacto_nombre VARCHAR(100),
    contacto_telefono VARCHAR(20),
    activo BOOLEAN DEFAULT TRUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
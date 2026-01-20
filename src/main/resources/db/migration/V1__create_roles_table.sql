-- V1__Create_roles_table.sql
CREATE TABLE IF NOT EXISTS roles (
                                     rol_id INT PRIMARY KEY AUTO_INCREMENT,
                                     nombre_rol VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );
-- V2__Create_usuarios_table.sql
CREATE TABLE IF NOT EXISTS usuarios (
                                        usuario_id INT PRIMARY KEY AUTO_INCREMENT,
                                        username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    rol_id INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultimo_login TIMESTAMP NULL,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (rol_id) REFERENCES roles(rol_id)
    );

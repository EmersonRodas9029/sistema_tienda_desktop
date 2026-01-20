-- V12__Create_clientes_table.sql
CREATE TABLE IF NOT EXISTS clientes (
                                        cliente_id INT PRIMARY KEY AUTO_INCREMENT,
                                        identificacion VARCHAR(20) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion VARCHAR(255),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
    );
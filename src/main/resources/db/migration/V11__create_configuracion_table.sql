-- V11__Create_configuracion_sistema_table.sql
CREATE TABLE IF NOT EXISTS configuracion_sistema (
                                                     config_id INT PRIMARY KEY AUTO_INCREMENT,
                                                     clave VARCHAR(100) NOT NULL UNIQUE,
    valor TEXT,
    tipo VARCHAR(50),
    descripcion VARCHAR(255),
    editable BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

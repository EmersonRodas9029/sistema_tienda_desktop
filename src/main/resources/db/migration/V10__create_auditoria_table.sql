-- V10__Create_auditoria_cambios_table.sql
CREATE TABLE IF NOT EXISTS auditoria_cambios (
                                                 auditoria_id INT PRIMARY KEY AUTO_INCREMENT,
                                                 tabla_afectada VARCHAR(100) NOT NULL,
    registro_id INT NOT NULL,
    accion ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
    datos_anteriores JSON,
    datos_nuevos JSON,
    usuario_id INT NOT NULL,
    fecha_cambio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    );
-- V9__Create_logs_sistema_table.sql
CREATE TABLE IF NOT EXISTS logs_sistema (
                                            log_id INT PRIMARY KEY AUTO_INCREMENT,
                                            nivel_log ENUM('INFO', 'WARNING', 'ERROR', 'DEBUG') DEFAULT 'INFO',
    modulo VARCHAR(100),
    accion VARCHAR(200),
    descripcion TEXT,
    usuario_id INT NULL,
    ip_address VARCHAR(45),
    user_agent TEXT,
    fecha_log TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    );
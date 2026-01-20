-- V6__Create_inventario_table.sql
CREATE TABLE IF NOT EXISTS inventario (
                                          inventario_id INT PRIMARY KEY AUTO_INCREMENT,
                                          producto_id INT NOT NULL,
                                          tipo_movimiento ENUM('ENTRADA', 'SALIDA', 'AJUSTE') NOT NULL,
    cantidad INT NOT NULL,
    cantidad_anterior INT NOT NULL,
    cantidad_nueva INT NOT NULL,
    motivo VARCHAR(255),
    referencia VARCHAR(100),
    usuario_id INT NOT NULL,
    fecha_movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (producto_id) REFERENCES productos(producto_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    );

-- V8__Create_detalles_venta_table.sql
CREATE TABLE IF NOT EXISTS detalles_venta (
                                              detalle_id INT PRIMARY KEY AUTO_INCREMENT,
                                              venta_id INT NOT NULL,
                                              producto_id INT NOT NULL,
                                              cantidad INT NOT NULL,
                                              precio_unitario DECIMAL(10,2) NOT NULL,
    descuento_unitario DECIMAL(10,2) DEFAULT 0,
    subtotal DECIMAL(10,2) NOT NULL,
    iva DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (venta_id) REFERENCES ventas(venta_id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(producto_id)
    );
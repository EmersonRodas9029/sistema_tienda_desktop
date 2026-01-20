-- V7__Create_ventas_table.sql
CREATE TABLE IF NOT EXISTS ventas (
                                      venta_id INT PRIMARY KEY AUTO_INCREMENT,
                                      numero_factura VARCHAR(50) UNIQUE,
    cliente_nombre VARCHAR(200),
    cliente_identificacion VARCHAR(20),
    cliente_telefono VARCHAR(20),
    cliente_email VARCHAR(100),
    subtotal DECIMAL(10,2) NOT NULL,
    iva DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) DEFAULT 0,
    total DECIMAL(10,2) NOT NULL,
    forma_pago ENUM('EFECTIVO', 'TARJETA', 'TRANSFERENCIA', 'MIXTO') DEFAULT 'EFECTIVO',
    estado ENUM('PENDIENTE', 'COMPLETADA', 'CANCELADA', 'DEVUELTA') DEFAULT 'COMPLETADA',
    usuario_id INT NOT NULL,
    observaciones TEXT,
    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
    );
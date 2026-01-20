-- V5__Create_productos_table.sql
CREATE TABLE IF NOT EXISTS productos (
                                         producto_id INT PRIMARY KEY AUTO_INCREMENT,
                                         codigo_producto VARCHAR(50) NOT NULL UNIQUE,
    nombre_producto VARCHAR(200) NOT NULL,
    descripcion TEXT,
    categoria_id INT NOT NULL,
    precio_compra DECIMAL(10,2) NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    proveedor_id INT NULL,
    unidad_medida VARCHAR(20) DEFAULT 'UNIDAD',
    stock_minimo INT DEFAULT 10,
    stock_maximo INT DEFAULT 100,
    tiene_iva BOOLEAN DEFAULT TRUE,
    porcentaje_iva DECIMAL(5,2) DEFAULT 12.00,
    imagen_url VARCHAR(500),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id),
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(proveedor_id)
    );
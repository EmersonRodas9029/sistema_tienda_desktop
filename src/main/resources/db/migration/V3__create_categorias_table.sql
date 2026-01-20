-- V3__Create_categorias_table.sql
CREATE TABLE IF NOT EXISTS categorias (
                                          categoria_id INT PRIMARY KEY AUTO_INCREMENT,
                                          nombre_categoria VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    categoria_padre_id INT NULL,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (categoria_padre_id) REFERENCES categorias(categoria_id)
    );
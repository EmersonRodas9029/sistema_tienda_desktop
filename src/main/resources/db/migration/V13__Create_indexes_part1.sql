-- V13__Create_indexes_part1.sql
-- Índices para usuarios
CREATE INDEX idx_usuarios_username ON usuarios(username);
CREATE INDEX idx_usuarios_email ON usuarios(email);
CREATE INDEX idx_usuarios_activo ON usuarios(activo);
CREATE INDEX idx_usuarios_rol ON usuarios(rol_id);

-- Índices para productos
CREATE INDEX idx_productos_codigo ON productos(codigo_producto);
CREATE INDEX idx_productos_nombre ON productos(nombre_producto);
CREATE INDEX idx_productos_categoria ON productos(categoria_id);
CREATE INDEX idx_productos_activo ON productos(activo);
CREATE INDEX idx_productos_proveedor ON productos(proveedor_id);
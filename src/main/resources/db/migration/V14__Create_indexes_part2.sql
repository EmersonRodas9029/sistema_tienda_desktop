-- V14__Create_indexes_part2.sql
-- Índices para ventas
CREATE INDEX idx_ventas_fecha ON ventas(fecha_venta);
CREATE INDEX idx_ventas_usuario ON ventas(usuario_id);
CREATE INDEX idx_ventas_estado ON ventas(estado);
CREATE INDEX idx_ventas_numero_factura ON ventas(numero_factura);
CREATE INDEX idx_ventas_cliente_ident ON ventas(cliente_identificacion);

-- Índices para detalles_venta
CREATE INDEX idx_detalles_venta_producto ON detalles_venta(producto_id);
CREATE INDEX idx_detalles_venta_venta ON detalles_venta(venta_id);

-- Índices para inventario
CREATE INDEX idx_inventario_producto ON inventario(producto_id);
CREATE INDEX idx_inventario_fecha ON inventario(fecha_movimiento);
CREATE INDEX idx_inventario_usuario ON inventario(usuario_id);
CREATE INDEX idx_inventario_tipo ON inventario(tipo_movimiento);

-- Índices para logs
CREATE INDEX idx_logs_fecha ON logs_sistema(fecha_log);
CREATE INDEX idx_logs_nivel ON logs_sistema(nivel_log);
CREATE INDEX idx_logs_usuario ON logs_sistema(usuario_id);

-- Índices para auditoría
CREATE INDEX idx_auditoria_tabla ON auditoria_cambios(tabla_afectada);
CREATE INDEX idx_auditoria_fecha ON auditoria_cambios(fecha_cambio);
CREATE INDEX idx_auditoria_usuario ON auditoria_cambios(usuario_id);
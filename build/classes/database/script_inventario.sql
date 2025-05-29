-- CREACIÓN DE LA TABLA EQUIPO
CREATE TABLE Equipo (
    id_equipo INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(100),
    marca VARCHAR(100),
    modelo VARCHAR(100),
    serie VARCHAR(100),
    estado VARCHAR(50),
    fecha_ingreso DATE
);

-- INSERCIÓN DE REGISTROS DE PRUEBA
INSERT INTO Equipo (nombre, tipo, marca, modelo, serie, estado, fecha_ingreso)
VALUES 
('Laptop HP', 'Portátil', 'HP', 'Pavilion 15', 'SN12345', 'Operativo', '2025-05-01'),
('Monitor LG', 'Periférico', 'LG', 'UltraWide', 'SN67890', 'En mantenimiento', '2025-05-10'),
('Router Cisco', 'Red', 'Cisco', 'RV340', 'SN99887', 'Operativo', '2025-05-20');

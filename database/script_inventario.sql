CREATE DATABASE InventarioTI
GO

USE InventarioTI
-- Tabla: Administrador
CREATE TABLE Administrador (
    id_admin INT PRIMARY KEY IDENTITY(1,1),
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(100) NOT NULL
);

-- Tabla: Usuario
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    correo VARCHAR(100),
    area VARCHAR(50)
);

-- Tabla: Equipo
CREATE TABLE Equipo (
    id_equipo INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50),
    marca VARCHAR(50),
    modelo VARCHAR(50),
    serie VARCHAR(50),
    estado VARCHAR(30),
    fecha_ingreso DATE
);

-- Tabla: Asignacion
CREATE TABLE Asignacion (
    id_asignacion INT PRIMARY KEY IDENTITY(1,1),
    id_equipo INT NOT NULL,
    id_usuario INT NOT NULL,
    fecha_asignacion DATE NOT NULL,
    fecha_retiro DATE NULL,
    motivo_retiro VARCHAR(255) NULL,
    CONSTRAINT FK_Asignacion_Equipo FOREIGN KEY (id_equipo) REFERENCES Equipo(id_equipo),
    CONSTRAINT FK_Asignacion_Usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Tabla: Historial
CREATE TABLE Historial (
    id_historial INT PRIMARY KEY IDENTITY(1,1),
    id_asignacion INT NOT NULL,
    id_admin INT NOT NULL,
    accion VARCHAR(100) NOT NULL,
    fecha DATETIME NOT NULL,
    usuario_accion VARCHAR(100),
    detalle TEXT,
    CONSTRAINT FK_Historial_Asignacion FOREIGN KEY (id_asignacion) REFERENCES Asignacion(id_asignacion),
    CONSTRAINT FK_Historial_Admin FOREIGN KEY (id_admin) REFERENCES Administrador(id_admin)
);
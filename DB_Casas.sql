Drop database if exists DB_Casas;
CREATE DATABASE DB_Casas;
use DB_Casas;

CREATE TABLE Propietario (
    codigoPropietario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) NOT NULL
);

CREATE TABLE Propiedad (
    codigoPropiedad INT PRIMARY KEY AUTO_INCREMENT,
    tipo ENUM('Casa', 'Apartamento') NOT NULL,  
    direccion VARCHAR(250) NOT NULL,
    numeroHabitaciones INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    codigoPropietario INT,  
    CONSTRAINT fk_codigoPropietario FOREIGN KEY (codigoPropietario) REFERENCES Propietario(codigoPropietario)
);

INSERT INTO Propietario (nombre, telefono) VALUES
( 'Kirian Martinez', '7555-1234'),
( 'Xavier Portillo', '6555-5678'),
( 'Brency Rivas', '8555-9012'),
('Rodrigo Mendez', '9555-3456'),
( 'Rodrigo Garcia', '2555-7890'),
( 'Diego Molina', '3555-2109'),
( 'Dana Bobadilla', '3555-6543'),
( 'Sophia Pinelo', '4555-8765'),
( 'Ximena Estrada', '7555-4321'),
( 'Pedri Gonzales', '4555-9876');

INSERT INTO Propiedad (tipo, direccion, numeroHabitaciones, precio, codigoPropietario) VALUES
('Casa', 'Zona 10, 4a Avenida 12-45, Ciudad de Guatemala', 4, 350000.00, 1),
('Apartamento', 'Zona 14, Avenida Las Américas 5-23, Ciudad de Guatemala', 2, 180000.00, 2),
('Casa', 'Zona 15, Colonia Vista Hermosa I, 8a Calle 7-33', 3, 275000.00, 3),
('Apartamento', 'Zona 13, Boulevard Liberación 6-10', 1, 95000.00, 4),
('Casa', 'Carretera a El Salvador, Km 12.5, Condominio Las Luces', 5, 520000.00, 5),
('Apartamento', 'Zona 16, Cayalá, Edificio Verona', 3, 210000.00, 6),
('Casa', 'Antigua Guatemala, Calle del Arco 3-25', 6, 750000.00, 7),
('Apartamento', 'Zona 11, Calzada Roosevelt 20-35, Torres San Juan', 2, 195000.00, 8),
('Casa', 'Zona 1, Calle Martí 14-08', 3, 285000.00, 9),
('Apartamento', 'Zona 9, Avenida Reforma 6-55', 4, 320000.00, 10);

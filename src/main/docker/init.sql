CREATE DATABASE IF NOT EXISTS quarkus_db;
USE quarkus_db;

CREATE TABLE IF NOT EXISTS estudiante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    telefono INT NOT NULL
);

INSERT INTO estudiante (nombre, apellido, password, telefono) 
VALUES ('Carlos', 'Mamani', 'pass123', 71234567);
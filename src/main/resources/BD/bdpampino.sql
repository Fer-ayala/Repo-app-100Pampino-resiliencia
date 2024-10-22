create database bdpampino_ef;
use bdpampino_ef;

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);


CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);

CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol),
	CONSTRAINT user_role_FK FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
	CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES rol(idrol)
);

CREATE TABLE productos (
    idproducto INT auto_increment NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NULL,
    precio DECIMAL(10, 2) NOT NULL,
    disponible BOOL NOT NULL DEFAULT TRUE,
    CONSTRAINT productos_pk PRIMARY KEY (idproducto)
);


/* Inserción de datos */
INSERT INTO rol (idrol, nomrol) VALUES
(1, 'ADMIN'),
(2, 'COORDINADOR');

-- Registros para la tabla usuario
#contraseña de juan --> juancontrasena
#contraseña de maria --> mariacontrasena
INSERT INTO usuario (nomusuario, email, password, nombres, apellidos, activo)
VALUES
('juanperez', 'juan.perez@example.com', '$2a$12$QRMxXD7Pok3uTd992NqeeOpmyXbqteb6PvBb5I6CosxfM2mS5tO1K', 'Juan', 'Pérez', TRUE),
('maria.lopez', 'maria.lopez@example.com', '$2a$12$mlb0PL4f8DDYP5dVsaggcOMmTnHhogXmRYxLa9Oyl1f97ZbDwsSN6', 'María', 'López', TRUE);

INSERT INTO usuario_rol values 
(1,1),
(1,2),
(2,2);

-- Registros para la tabla productos
INSERT INTO productos (nombre, descripcion, precio, disponible)
VALUES
('Queso Andino', 'Queso fresco hecho en la región de los Andes', 12.50, TRUE),
('Leche Fresca', 'Leche orgánica de vacas pastoreadas en los campos de Pampas', 5.20, TRUE),
('Yogur Natural', 'Yogur sin azúcares añadidos y bajo en grasa', 3.80, TRUE),
('Mantequilla Artesanal', 'Mantequilla hecha a mano con crema fresca', 7.30, TRUE),
('Pan de Maíz', 'Pan artesanal de maíz con un toque de dulce', 2.50, TRUE),
('Pan Integral', 'Pan hecho con harina integral 100% orgánica', 3.00, TRUE),
('Queso Parmesano', 'Queso parmesano envejecido, ideal para pastas', 15.00, TRUE),
('Crema de Leche', 'Crema espesa para repostería y cocina', 4.60, TRUE),
('Pan Ciabatta', 'Pan estilo italiano con una corteza crujiente', 3.20, TRUE),
('Leche Deslactosada', 'Leche sin lactosa para personas intolerantes', 6.00, TRUE);

select * from usuario;
Select * from rol;
select * from usuario_rol;
select * from productos;
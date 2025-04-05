CREATE DATABASE biblioteca_db;


CREATE TABLE usuarios (
    ID_usuario INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellidos VARCHAR(40) NOT NULL,
    usuario VARCHAR(15) NOT NULL,
    pass VARCHAR(50) NOT NULL
);

CREATE TABLE info_usuario (
    ID_FK_usuario INT NOT NULL,
    semilla VARCHAR NOT NULL,
    cartera INT NOT NULL,
    fecha_registro DATE NOT NULL,
    ultimo_registro DATE NOT NULL,
    PRIMARY KEY pk_usuarios_seguridad PRIMARY KEY (ID_FK_usuario),
    FOREIGN KEY (ID_FK_usuario) REFERENCES usuarios(ID_usuario) ON DELETE CASCADE
);

CREATE TABLE biblioteca (
    ID_biblioteca INT PRIMARY KEY NOT NULL,
    ID_FK_usuario INT NOT NULL,
    ultimo_registro DATE NOT NULL,
    FOREIGN KEY (ID_FK_usuario) REFERENCES usuarios(ID_usuario) ON DELETE CASCADE
);

CREATE TABLE libro (
    ID_libro VARCHAR PRIMARY KEY NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    fecha_publi DATE NOT NULL,
    precio DOUBLE PRECISION NOT NULL,
    descuento INT,
    DRM BOOLEAN NOT NULL,
    n_paginas INT NOT NULL,
    sinopsis VARCHAR NOT NULL,
    n_votos INT NOT NULL,
    valoracion INT NOT NULL,
    URLibro VARCHAR NOT NULL,
    URLportada VARCHAR NOT NULL,
    ID_FK_saga INT NOT NULL,
    FOREIGN KEY (ID_FK_saga) REFERENCES saga(ID_saga) ON DELETE CASCADE
);

CREATE TABLE saga (
    ID_saga INT PRIMARY KEY NOT NULL,
    saga VARCHAR(50) NOT NULL
)

CREATE TABLE autor (
    ID_autor INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(20),
    apellidos VARCHAR(40)
);

CREATE TABLE idioma(
    ID_idioma INT PRIMARY KEY NOT NULL,
    idioma varchar(20)
);

CREATE TABLE genero(
    ID_genero INT PRIMARY KEY NOT NULL,
    genero varchar(20)
);

CREATE TABLE editorial (
    ID_editorial VARCHAR PRIMARY KEY NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono INT NOT NULL,
    contacto VARCHAR(80),
    web VARCHAR,
    ID_FK_usuario INT NOT NULL,
    FOREIGN KEY (ID_FK_usuario) REFERENCES usuarios(ID_usuario) ON DELETE CASCADE;
);

CREATE TABLE biblio_libro (
    ID_FK_biblioteca INT NOT NULL,
    ID_FK_libro VARCHAR NOT NULL,
    fecha_compra DATE NOT NULL,
    PRIMARY KEY (ID_FK_biblioteca, ID_FK_libro),
    FOREIGN KEY (ID_FK_biblioteca) REFERENCES biblioteca(ID_biblioteca) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

CREATE TABLE libro_edit (
    ID_FK_editorial VARCHAR NOT NULL,
    ID_FK_libro VARCHAR NOT NULL,
    fecha_alta DATE NOT NULL,
    PRIMARY KEY (ID_FK_editorial, ID_FK_libro),
    FOREIGN KEY (ID_FK_editorial) REFERENCES editorial(ID_editorial) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

CREATE TABLE libro_genero (
    ID_FK_libro VARCHAR NOT NULL,
    ID_FK_genero INT NOT NULL,
    PRIMARY KEY (ID_FK_genero, ID_FK_libro),
    FOREIGN KEY (ID_FK_genero) REFERENCES genero(ID_genro) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

CREATE TABLE libro_idioma (
    ID_FK_libro VARCHAR NOT NULL,
    ID_FK_idioma INT NOT NULL,
    PRIMARY KEY (ID_FK_idioma, ID_FK_libro),
    FOREIGN KEY (ID_FK_idioma) REFERENCES idioma(ID_idioma) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

CREATE TABLE libro_autor (
    ID_FK_libro VARCHAR NOT NULL,
    ID_FK_autor INT NOT NULL,
    PRIMARY KEY (ID_FK_autor, ID_FK_libro),
    FOREIGN KEY (ID_FK_autor) REFERENCES autor(ID_autor) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);
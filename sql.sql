CREATE DATABASE biblioteca_db;

\c biblioteca_db;

CREATE TABLE usuarios (
    ID_usuario INT PRIMARY KEY NOT NULL,
    nombre VARCHAR NOT NULL,
    apellidos VARCHAR NOT NULL,
    usuario VARCHAR NOT NULL,
    correo VARCHAR NOT NULL,
    pass VARCHAR NOT NULL
);

CREATE TABLE info (
    ID_info INT PRIMARY KEY NOT NULL,
    ID_FK_usuario INT NOT NULL,
    salt VARCHAR NOT NULL,
    cartera DOUBLE NOT NULL,
    FOREIGN KEY (ID_FK_usuario) REFERENCES usuarios(ID_usuario) ON DELETE CASCADE
);

CREATE TABLE biblioteca (
    ID_biblioteca INT PRIMARY KEY NOT NULL,
    ID_FK_usuario INT NOT NULL,
    cantidad_libros INT NOT NULL,
    FOREIGN KEY (ID_FK_usuario) REFERENCES usuarios(ID_usuario) ON DELETE CASCADE
);

CREATE TABLE libro (
    ID_libro INT PRIMARY KEY NOT NULL,
    titulo VARCHAR NOT NULL,
    idioma VARCHAR[] NOT NULL,
    genero VARCHAR[] NOT NULL,
    fecha_publi DATE NOT NULL,
    autores VARCHAR[] NOT NULL,
    precio DOUBLE PRECISION NOT NULL,
    DRM BOOLEAN NOT NULL,
    N_paginas INT NOT NULL,
    sinopsis VARCHAR NOT NULL,
    valoracion VARCHAR NOT NULL,
    URLibro VARCHAR NOT NULL,
    URLportada VARCHAR NOT NULL
);

CREATE TABLE editorial (
    ID_editorial INT PRIMARY KEY NOT NULL,
    nombre VARCHAR NOT NULL,
    NIF VARCHAR NOT NULL,
    direccion VARCHAR NOT NULL,
    correo VARCHAR NOT NULL,
    telefono INT NOT NULL,
    contacto VARCHAR,
    web VARCHAR
);

CREATE TABLE biblio_libro (
    ID_FK_biblioteca INT NOT NULL,
    ID_FK_libro INT NOT NULL,
    fecha_compra DATE NOT NULL,
    PRIMARY KEY (ID_FK_biblioteca, ID_FK_libro),
    FOREIGN KEY (ID_FK_biblioteca) REFERENCES biblioteca(ID_biblioteca) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

CREATE TABLE libro_edit (
    ID_FK_editorial INT NOT NULL,
    ID_FK_libro INT NOT NULL,
    fecha_alta DATE NOT NULL,
    PRIMARY KEY (ID_FK_editorial, ID_FK_libro),
    FOREIGN KEY (ID_FK_editorial) REFERENCES editorial(ID_editorial) ON DELETE CASCADE,
    FOREIGN KEY (ID_FK_libro) REFERENCES libro(ID_libro) ON DELETE CASCADE
);

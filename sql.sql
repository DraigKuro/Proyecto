-- crear la base de datos si no existe
create database if not exists biblioteca_db;

-- usar la base de datos
use biblioteca_db;

-- crear la tabla usuarios si no existe
create table if not exists usuarios (
    id_usuario int primary key not null,
    nombre varchar(255) not null,
    apellidos varchar(255) not null,
    usuario varchar(255) not null,
    correo varchar(255) not null,
    pass varchar(255) not null
);

-- crear la tabla info si no existe
create table if not exists info (
    id_info int primary key not null,
    id_fk_usuario int not null,
    salt varchar(255) not null,
    cartera double not null,
    foreign key (id_fk_usuario) references usuarios(id_usuario) on delete cascade
);

-- crear la tabla biblioteca si no existe
create table if not exists biblioteca (
    id_biblioteca int primary key not null,
    id_fk_usuario int not null,
    cantidad_libros int not null,
    foreign key (id_fk_usuario) references usuarios(id_usuario) on delete cascade
);

-- crear la tabla libro si no existe
create table if not exists libro (
    id_libro int primary key not null,
    titulo varchar(255) not null,
    idioma varchar(255) not null,
    genero varchar(255) not null,
    fecha_publi date not null,
    autores varchar(255) not null,
    precio double not null,
    drm boolean not null,
    n_paginas int not null,
    sinopsis varchar(255) not null,
    valoracion varchar(255) not null,
    urllibro varchar(255) not null,
    urlportada varchar(255) not null
);
-- crear la tabla editorial si no existe
create table if not exists editorial (
id_editorial int primary key not null,
nombre varchar(255) not null,
nif varchar(255) not null,
direccion varchar(255) not null,
correo varchar(255) not null,
telefono int not null,
contacto varchar(255),
web varchar(255)
);

-- crear la tabla biblio_libro si no existe
create table if not exists biblio_libro (
id_fk_biblioteca int not null,
id_fk_libro int not null,
fecha_compra date not null,
primary key (id_fk_biblioteca, id_fk_libro),
foreign key (id_fk_biblioteca) references biblioteca(id_biblioteca) on delete cascade,
foreign key (id_fk_libro) references libro(id_libro) on delete cascade
);

-- crear la tabla libro_edit si no existe
create table if not exists libro_edit (
id_fk_editorial int not null,
id_fk_libro int not null,
fecha_alta date not null,
primary key (id_fk_editorial, id_fk_libro),
foreign key (id_fk_editorial) references editorial(id_editorial) on delete cascade,
foreign key (id_fk_libro) references libro(id_libro) on delete cascade
);
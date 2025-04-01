--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.0

-- Started on 2025-04-01 18:57:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE biblioteca_db;
--
-- TOC entry 4841 (class 1262 OID 16547)
-- Name: biblioteca_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE biblioteca_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Latin America.1252';


ALTER DATABASE biblioteca_db OWNER TO postgres;

\connect biblioteca_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4842 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 16701)
-- Name: biblio_libro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.biblio_libro (
    id_fk_biblioteca integer NOT NULL,
    id_fk_libro integer NOT NULL,
    fecha_compra date NOT NULL
);


ALTER TABLE public.biblio_libro OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16677)
-- Name: biblioteca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.biblioteca (
    id_biblioteca integer NOT NULL,
    id_fk_usuario integer NOT NULL,
    cantidad_libros integer NOT NULL
);


ALTER TABLE public.biblioteca OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16694)
-- Name: editorial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editorial (
    id_editorial integer NOT NULL,
    nombre character varying(255) NOT NULL,
    nif character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    telefono integer NOT NULL,
    contacto character varying(255),
    web character varying(255)
);


ALTER TABLE public.editorial OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16667)
-- Name: info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.info (
    id_info integer NOT NULL,
    id_fk_usuario integer NOT NULL,
    salt character varying(255) NOT NULL,
    cartera double precision NOT NULL
);


ALTER TABLE public.info OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16687)
-- Name: libro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro (
    id_libro integer NOT NULL,
    titulo character varying(255) NOT NULL,
    idioma character varying(255) NOT NULL,
    genero character varying(255) NOT NULL,
    fecha_publi date NOT NULL,
    autores character varying(255) NOT NULL,
    precio double precision NOT NULL,
    drm boolean NOT NULL,
    n_paginas integer NOT NULL,
    sinopsis character varying(255) NOT NULL,
    valoracion character varying(255) NOT NULL,
    urllibro character varying(255) NOT NULL,
    urlportada character varying(255) NOT NULL
);


ALTER TABLE public.libro OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16716)
-- Name: libro_edit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_edit (
    id_fk_editorial integer NOT NULL,
    id_fk_libro integer NOT NULL,
    fecha_alta date NOT NULL
);


ALTER TABLE public.libro_edit OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16660)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    nombre character varying(255) NOT NULL,
    apellidos character varying(255) NOT NULL,
    usuario character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    pass character varying(255) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 4834 (class 0 OID 16701)
-- Dependencies: 222
-- Data for Name: biblio_libro; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4831 (class 0 OID 16677)
-- Dependencies: 219
-- Data for Name: biblioteca; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4833 (class 0 OID 16694)
-- Dependencies: 221
-- Data for Name: editorial; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4830 (class 0 OID 16667)
-- Dependencies: 218
-- Data for Name: info; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4832 (class 0 OID 16687)
-- Dependencies: 220
-- Data for Name: libro; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4835 (class 0 OID 16716)
-- Dependencies: 223
-- Data for Name: libro_edit; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4829 (class 0 OID 16660)
-- Dependencies: 217
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4675 (class 2606 OID 16705)
-- Name: biblio_libro biblio_libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_pkey PRIMARY KEY (id_fk_biblioteca, id_fk_libro);


--
-- TOC entry 4669 (class 2606 OID 16681)
-- Name: biblioteca biblioteca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_pkey PRIMARY KEY (id_biblioteca);


--
-- TOC entry 4673 (class 2606 OID 16700)
-- Name: editorial editorial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editorial
    ADD CONSTRAINT editorial_pkey PRIMARY KEY (id_editorial);


--
-- TOC entry 4667 (class 2606 OID 16671)
-- Name: info info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.info
    ADD CONSTRAINT info_pkey PRIMARY KEY (id_info);


--
-- TOC entry 4677 (class 2606 OID 16720)
-- Name: libro_edit libro_edit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_pkey PRIMARY KEY (id_fk_editorial, id_fk_libro);


--
-- TOC entry 4671 (class 2606 OID 16693)
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id_libro);


--
-- TOC entry 4665 (class 2606 OID 16666)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 4680 (class 2606 OID 16706)
-- Name: biblio_libro biblio_libro_id_fk_biblioteca_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_id_fk_biblioteca_fkey FOREIGN KEY (id_fk_biblioteca) REFERENCES public.biblioteca(id_biblioteca) ON DELETE CASCADE;


--
-- TOC entry 4681 (class 2606 OID 16711)
-- Name: biblio_libro biblio_libro_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4679 (class 2606 OID 16682)
-- Name: biblioteca biblioteca_id_fk_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_id_fk_usuario_fkey FOREIGN KEY (id_fk_usuario) REFERENCES public.usuarios(id_usuario) ON DELETE CASCADE;


--
-- TOC entry 4678 (class 2606 OID 16672)
-- Name: info info_id_fk_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.info
    ADD CONSTRAINT info_id_fk_usuario_fkey FOREIGN KEY (id_fk_usuario) REFERENCES public.usuarios(id_usuario) ON DELETE CASCADE;


--
-- TOC entry 4682 (class 2606 OID 16721)
-- Name: libro_edit libro_edit_id_fk_editorial_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_id_fk_editorial_fkey FOREIGN KEY (id_fk_editorial) REFERENCES public.editorial(id_editorial) ON DELETE CASCADE;


--
-- TOC entry 4683 (class 2606 OID 16726)
-- Name: libro_edit libro_edit_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


-- Completed on 2025-04-01 18:57:29

--
-- PostgreSQL database dump complete
--


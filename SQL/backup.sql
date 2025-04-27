--
-- PostgreSQL database cluster dump
--

-- Started on 2025-04-27 15:11:53

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.0

-- Started on 2025-04-27 15:11:54

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

-- Completed on 2025-04-27 15:11:54

--
-- PostgreSQL database dump complete
--

--
-- Database "biblioteca_db" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.0

-- Started on 2025-04-27 15:11:54

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
-- TOC entry 4922 (class 1262 OID 16547)
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
-- TOC entry 5 (class 2615 OID 16980)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 4923 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS '';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 17002)
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    id_autor integer NOT NULL,
    nombre character varying(255),
    apellidos character varying(255)
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17001)
-- Name: autor_id_autor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autor_id_autor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.autor_id_autor_seq OWNER TO postgres;

--
-- TOC entry 4925 (class 0 OID 0)
-- Dependencies: 221
-- Name: autor_id_autor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autor_id_autor_seq OWNED BY public.autor.id_autor;


--
-- TOC entry 232 (class 1259 OID 17087)
-- Name: biblio_libro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.biblio_libro (
    id_fk_biblioteca integer NOT NULL,
    id_fk_libro character varying(255) NOT NULL,
    fecha_compra date DEFAULT CURRENT_DATE NOT NULL,
    precio numeric(38,2) NOT NULL
);


ALTER TABLE public.biblio_libro OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 17058)
-- Name: biblioteca; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.biblioteca (
    id_biblioteca integer NOT NULL,
    id_fk_usuario integer NOT NULL,
    ultimo_registro timestamp without time zone
);


ALTER TABLE public.biblioteca OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 17057)
-- Name: biblioteca_id_biblioteca_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.biblioteca_id_biblioteca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.biblioteca_id_biblioteca_seq OWNER TO postgres;

--
-- TOC entry 4926 (class 0 OID 0)
-- Dependencies: 229
-- Name: biblioteca_id_biblioteca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.biblioteca_id_biblioteca_seq OWNED BY public.biblioteca.id_biblioteca;


--
-- TOC entry 231 (class 1259 OID 17071)
-- Name: deseado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deseado (
    id_fk_usuario integer NOT NULL,
    id_fk_libro character varying(255) NOT NULL,
    fecha_registro date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.deseado OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 17043)
-- Name: editorial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editorial (
    id_editorial character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL,
    contacto character varying(255),
    web character varying(255),
    id_fk_usuario integer NOT NULL
);


ALTER TABLE public.editorial OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17018)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero (
    id_genero integer NOT NULL,
    genero character varying(255)
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17017)
-- Name: genero_id_genero_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genero_id_genero_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.genero_id_genero_seq OWNER TO postgres;

--
-- TOC entry 4927 (class 0 OID 0)
-- Dependencies: 225
-- Name: genero_id_genero_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genero_id_genero_seq OWNED BY public.genero.id_genero;


--
-- TOC entry 224 (class 1259 OID 17009)
-- Name: idioma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.idioma (
    id_idioma integer NOT NULL,
    idioma character varying(255)
);


ALTER TABLE public.idioma OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17008)
-- Name: idioma_id_idioma_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idioma_id_idioma_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idioma_id_idioma_seq OWNER TO postgres;

--
-- TOC entry 4928 (class 0 OID 0)
-- Dependencies: 223
-- Name: idioma_id_idioma_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.idioma_id_idioma_seq OWNED BY public.idioma.id_idioma;


--
-- TOC entry 227 (class 1259 OID 17026)
-- Name: libro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro (
    id_libro character varying(255) NOT NULL,
    titulo character varying(255) NOT NULL,
    fecha_publi date NOT NULL,
    precio numeric(38,2) NOT NULL,
    descuento smallint,
    drm boolean DEFAULT false NOT NULL,
    n_paginas integer NOT NULL,
    sinopsis character varying(255),
    n_votos integer DEFAULT 0,
    valoracion smallint,
    urlibro character varying(255) NOT NULL,
    urlportada character varying(255) NOT NULL,
    id_fk_saga integer,
    CONSTRAINT libro_descuento_check CHECK (((descuento >= 0) AND (descuento <= 100))),
    CONSTRAINT libro_n_paginas_check CHECK ((n_paginas > 0)),
    CONSTRAINT libro_valoracion_check CHECK (((valoracion >= 0) AND (valoracion <= 5)))
);


ALTER TABLE public.libro OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 17149)
-- Name: libro_autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_autor (
    id_fk_libro character varying(255) NOT NULL,
    id_fk_autor integer NOT NULL,
    orden_autor smallint
);


ALTER TABLE public.libro_autor OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 17103)
-- Name: libro_edit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_edit (
    id_fk_editorial character varying(255) NOT NULL,
    id_fk_libro character varying(255) NOT NULL,
    fecha_alta date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.libro_edit OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 17119)
-- Name: libro_genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_genero (
    id_fk_libro character varying(255) NOT NULL,
    id_fk_genero integer NOT NULL
);


ALTER TABLE public.libro_genero OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 17134)
-- Name: libro_idioma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_idioma (
    id_fk_libro character varying(255) NOT NULL,
    id_fk_idioma integer NOT NULL
);


ALTER TABLE public.libro_idioma OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16993)
-- Name: saga; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.saga (
    id_saga integer NOT NULL,
    nombre_saga character varying(255) NOT NULL
);


ALTER TABLE public.saga OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16992)
-- Name: saga_id_saga_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.saga_id_saga_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.saga_id_saga_seq OWNER TO postgres;

--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 219
-- Name: saga_id_saga_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.saga_id_saga_seq OWNED BY public.saga.id_saga;


--
-- TOC entry 218 (class 1259 OID 16982)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying(255) NOT NULL,
    apellidos character varying(255) NOT NULL,
    usuario character varying(255) NOT NULL,
    pass character varying(255) NOT NULL,
    semilla character varying(255) NOT NULL,
    cartera numeric(38,2) DEFAULT 0.00 NOT NULL,
    fecha_registro timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    ultimo_registro timestamp without time zone
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16981)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 4930 (class 0 OID 0)
-- Dependencies: 217
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 4702 (class 2604 OID 17005)
-- Name: autor id_autor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor ALTER COLUMN id_autor SET DEFAULT nextval('public.autor_id_autor_seq'::regclass);


--
-- TOC entry 4707 (class 2604 OID 17061)
-- Name: biblioteca id_biblioteca; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca ALTER COLUMN id_biblioteca SET DEFAULT nextval('public.biblioteca_id_biblioteca_seq'::regclass);


--
-- TOC entry 4704 (class 2604 OID 17021)
-- Name: genero id_genero; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero ALTER COLUMN id_genero SET DEFAULT nextval('public.genero_id_genero_seq'::regclass);


--
-- TOC entry 4703 (class 2604 OID 17012)
-- Name: idioma id_idioma; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.idioma ALTER COLUMN id_idioma SET DEFAULT nextval('public.idioma_id_idioma_seq'::regclass);


--
-- TOC entry 4701 (class 2604 OID 16996)
-- Name: saga id_saga; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saga ALTER COLUMN id_saga SET DEFAULT nextval('public.saga_id_saga_seq'::regclass);


--
-- TOC entry 4698 (class 2604 OID 16985)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 4724 (class 2606 OID 17007)
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id_autor);


--
-- TOC entry 4748 (class 2606 OID 17180)
-- Name: biblio_libro biblio_libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_pkey PRIMARY KEY (id_fk_biblioteca, id_fk_libro);


--
-- TOC entry 4742 (class 2606 OID 17065)
-- Name: biblioteca biblioteca_id_fk_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_id_fk_usuario_key UNIQUE (id_fk_usuario);


--
-- TOC entry 4744 (class 2606 OID 17063)
-- Name: biblioteca biblioteca_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_pkey PRIMARY KEY (id_biblioteca);


--
-- TOC entry 4746 (class 2606 OID 17187)
-- Name: deseado deseado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deseado
    ADD CONSTRAINT deseado_pkey PRIMARY KEY (id_fk_usuario, id_fk_libro);


--
-- TOC entry 4738 (class 2606 OID 17051)
-- Name: editorial editorial_id_fk_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editorial
    ADD CONSTRAINT editorial_id_fk_usuario_key UNIQUE (id_fk_usuario);


--
-- TOC entry 4740 (class 2606 OID 17194)
-- Name: editorial editorial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editorial
    ADD CONSTRAINT editorial_pkey PRIMARY KEY (id_editorial);


--
-- TOC entry 4731 (class 2606 OID 17208)
-- Name: genero genero_genero_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_genero_key UNIQUE (genero);


--
-- TOC entry 4733 (class 2606 OID 17023)
-- Name: genero genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id_genero);


--
-- TOC entry 4727 (class 2606 OID 17210)
-- Name: idioma idioma_idioma_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.idioma
    ADD CONSTRAINT idioma_idioma_key UNIQUE (idioma);


--
-- TOC entry 4729 (class 2606 OID 17014)
-- Name: idioma idioma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.idioma
    ADD CONSTRAINT idioma_pkey PRIMARY KEY (id_idioma);


--
-- TOC entry 4756 (class 2606 OID 17266)
-- Name: libro_autor libro_autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT libro_autor_pkey PRIMARY KEY (id_fk_libro, id_fk_autor);


--
-- TOC entry 4750 (class 2606 OID 17280)
-- Name: libro_edit libro_edit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_pkey PRIMARY KEY (id_fk_editorial, id_fk_libro);


--
-- TOC entry 4752 (class 2606 OID 17289)
-- Name: libro_genero libro_genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_genero
    ADD CONSTRAINT libro_genero_pkey PRIMARY KEY (id_fk_genero, id_fk_libro);


--
-- TOC entry 4754 (class 2606 OID 17296)
-- Name: libro_idioma libro_idioma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_idioma
    ADD CONSTRAINT libro_idioma_pkey PRIMARY KEY (id_fk_idioma, id_fk_libro);


--
-- TOC entry 4736 (class 2606 OID 17212)
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id_libro);


--
-- TOC entry 4720 (class 2606 OID 17303)
-- Name: saga saga_nombre_saga_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saga
    ADD CONSTRAINT saga_nombre_saga_key UNIQUE (nombre_saga);


--
-- TOC entry 4722 (class 2606 OID 16998)
-- Name: saga saga_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.saga
    ADD CONSTRAINT saga_pkey PRIMARY KEY (id_saga);


--
-- TOC entry 4716 (class 2606 OID 16989)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 4718 (class 2606 OID 17174)
-- Name: usuario usuario_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_usuario_key UNIQUE (usuario);


--
-- TOC entry 4725 (class 1259 OID 17176)
-- Name: idx_autor_nombre_apellidos; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_autor_nombre_apellidos ON public.autor USING btree (nombre, apellidos);


--
-- TOC entry 4734 (class 1259 OID 17250)
-- Name: idx_libro_titulo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_libro_titulo ON public.libro USING btree (titulo);


--
-- TOC entry 4714 (class 1259 OID 17170)
-- Name: idx_usuario_nombre_apellidos; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_usuario_nombre_apellidos ON public.usuario USING btree (nombre, apellidos);


--
-- TOC entry 4762 (class 2606 OID 17093)
-- Name: biblio_libro biblio_libro_id_fk_biblioteca_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_id_fk_biblioteca_fkey FOREIGN KEY (id_fk_biblioteca) REFERENCES public.biblioteca(id_biblioteca) ON DELETE CASCADE;


--
-- TOC entry 4763 (class 2606 OID 17213)
-- Name: biblio_libro biblio_libro_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblio_libro
    ADD CONSTRAINT biblio_libro_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4759 (class 2606 OID 17066)
-- Name: biblioteca biblioteca_id_fk_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.biblioteca
    ADD CONSTRAINT biblioteca_id_fk_usuario_fkey FOREIGN KEY (id_fk_usuario) REFERENCES public.usuario(id_usuario) ON DELETE CASCADE;


--
-- TOC entry 4760 (class 2606 OID 17218)
-- Name: deseado deseado_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deseado
    ADD CONSTRAINT deseado_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4761 (class 2606 OID 17077)
-- Name: deseado deseado_id_fk_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deseado
    ADD CONSTRAINT deseado_id_fk_usuario_fkey FOREIGN KEY (id_fk_usuario) REFERENCES public.usuario(id_usuario) ON DELETE CASCADE;


--
-- TOC entry 4758 (class 2606 OID 17052)
-- Name: editorial editorial_id_fk_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editorial
    ADD CONSTRAINT editorial_id_fk_usuario_fkey FOREIGN KEY (id_fk_usuario) REFERENCES public.usuario(id_usuario) ON DELETE CASCADE;


--
-- TOC entry 4770 (class 2606 OID 17159)
-- Name: libro_autor libro_autor_id_fk_autor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT libro_autor_id_fk_autor_fkey FOREIGN KEY (id_fk_autor) REFERENCES public.autor(id_autor) ON DELETE CASCADE;


--
-- TOC entry 4771 (class 2606 OID 17267)
-- Name: libro_autor libro_autor_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT libro_autor_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4764 (class 2606 OID 17274)
-- Name: libro_edit libro_edit_id_fk_editorial_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_id_fk_editorial_fkey FOREIGN KEY (id_fk_editorial) REFERENCES public.editorial(id_editorial) ON DELETE CASCADE;


--
-- TOC entry 4765 (class 2606 OID 17281)
-- Name: libro_edit libro_edit_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_edit
    ADD CONSTRAINT libro_edit_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4766 (class 2606 OID 17124)
-- Name: libro_genero libro_genero_id_fk_genero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_genero
    ADD CONSTRAINT libro_genero_id_fk_genero_fkey FOREIGN KEY (id_fk_genero) REFERENCES public.genero(id_genero) ON DELETE CASCADE;


--
-- TOC entry 4767 (class 2606 OID 17290)
-- Name: libro_genero libro_genero_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_genero
    ADD CONSTRAINT libro_genero_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4757 (class 2606 OID 17038)
-- Name: libro libro_id_fk_saga_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_id_fk_saga_fkey FOREIGN KEY (id_fk_saga) REFERENCES public.saga(id_saga) ON DELETE SET NULL;


--
-- TOC entry 4768 (class 2606 OID 17139)
-- Name: libro_idioma libro_idioma_id_fk_idioma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_idioma
    ADD CONSTRAINT libro_idioma_id_fk_idioma_fkey FOREIGN KEY (id_fk_idioma) REFERENCES public.idioma(id_idioma) ON DELETE CASCADE;


--
-- TOC entry 4769 (class 2606 OID 17297)
-- Name: libro_idioma libro_idioma_id_fk_libro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_idioma
    ADD CONSTRAINT libro_idioma_id_fk_libro_fkey FOREIGN KEY (id_fk_libro) REFERENCES public.libro(id_libro) ON DELETE CASCADE;


--
-- TOC entry 4924 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;


-- Completed on 2025-04-27 15:11:54

--
-- PostgreSQL database dump complete
--

-- Completed on 2025-04-27 15:11:54

--
-- PostgreSQL database cluster dump complete
--


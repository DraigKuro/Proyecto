package com.tutienda.libros.api.utils;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.models.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroDTO toDto(Libro libro) {
        if (libro == null) {
            return null;
        }
        LibroDTO dto = new LibroDTO();
        copyPropertiesToDto(libro, dto);
        return dto;
    }

    public Libro toEntity(LibroDTO dto) {
        if (dto == null) {
            return null;
        }
        Libro libro = new Libro();
        copyPropertiesToEntity(dto, libro);
        return libro;
    }

    private void copyPropertiesToDto(Libro libro, LibroDTO dto) {
        dto.setIdLibro(libro.getIdLibro());
        dto.setTitulo(libro.getTitulo());
        dto.setFechaPubli(libro.getFechaPubli());
        dto.setPrecio(libro.getPrecio());
        dto.setDescuento(libro.getDescuento());
        dto.setDrm(libro.getDrm());
        dto.setnPaginas(libro.getNPaginas());
        dto.setSinopsis(libro.getSinopsis());
        dto.setnVotos(libro.getNVotos());
        dto.setValoracion(libro.getValoracion());
        dto.setUrlLibro(libro.getUrlibro());
        dto.setUrlPortada(libro.getUrlportada());
    }

    private void copyPropertiesToEntity(LibroDTO dto, Libro libro) {
        libro.setIdLibro(dto.getIdLibro());
        libro.setTitulo(dto.getTitulo());
        libro.setFechaPubli(dto.getFechaPubli());
        libro.setPrecio(dto.getPrecio());
        libro.setDescuento(dto.getDescuento());
        libro.setDrm(dto.isDrm());
        libro.setNPaginas(dto.getnPaginas());
        libro.setSinopsis(dto.getSinopsis());
        libro.setNVotos(dto.getnVotos());
        libro.setValoracion(dto.getValoracion());
        libro.setUrlibro(dto.getUrlLibro());
        libro.setUrlportada(dto.getUrlPortada());
    }
}

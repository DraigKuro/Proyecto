package com.tutienda.libros.api.mappers;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.models.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroDTO toDto(Libro libro) {
        LibroDTO dto = new LibroDTO();
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
        dto.setUrlLibro(libro.getUrlibro());  // Cambiado a urlLibro (consistente con DTO)
        dto.setUrlPortada(libro.getUrlportada()); // Cambiado a urlPortada
        return dto;
    }

    public Libro toEntity(LibroDTO dto) {
        Libro libro = new Libro();
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
        libro.setUrlibro(dto.getUrlLibro());  // Cambiado a getUrlLibro()
        libro.setUrlportada(dto.getUrlPortada()); // Cambiado a getUrlPortada()
        return libro;
    }
}
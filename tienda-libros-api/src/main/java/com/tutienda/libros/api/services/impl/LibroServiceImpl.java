package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.dto.LibroDTO;
import com.tutienda.libros.api.mappers.LibroMapper;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.repositories.LibroRepository;
import com.tutienda.libros.api.services.LibroService;
import com.tutienda.libros.api.utils.FileStorageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;
    private final FileStorageUtil fileStorageUtil;

    @Value("${app.uploads.portadas-dir}")
    private String portadasDir;

    @Value("${app.uploads.libros-dir}")
    private String librosDir;

    public LibroServiceImpl(LibroRepository libroRepository,
            LibroMapper libroMapper,
            FileStorageUtil fileStorageUtil) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
        this.fileStorageUtil = fileStorageUtil;
    }

    @Override
    public List<Libro> buscarPorTituloContiene(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public Libro buscarPorId(String idLibro) {
        return libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public Libro crearLibro(Libro libro) {
        // Validación simple (puedes añadir más)
        if (libroRepository.existsById(libro.getIdLibro())) {
            throw new RuntimeException("El libro ya existe");
        }
        return libroRepository.save(libro);
    }

    // Método adicional para crear desde DTO (usado por el controlador)
    @Override
    public Libro crearLibroDesdeDTO(LibroDTO libroDTO) throws IOException {
        procesarArchivos(libroDTO);
        Libro libro = libroMapper.toEntity(libroDTO);
        return crearLibro(libro);
    }

    @Override
    public Libro actualizarLibro(String idLibro, Libro libroActualizado) {
        return libroRepository.findById(idLibro)
                .map(libroExistente -> {
                    // Actualizar campos permitidos
                    libroExistente.setTitulo(libroActualizado.getTitulo());
                    libroExistente.setFechaPubli(libroActualizado.getFechaPubli());
                    libroExistente.setPrecio(libroActualizado.getPrecio());
                    // ... otros campos ...
                    return libroRepository.save(libroExistente);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    // Método adicional para actualizar desde DTO
    @Override
    public Libro actualizarLibroDesdeDTO(String idLibro, LibroDTO libroDTO) throws IOException {
        procesarArchivos(libroDTO);
        Libro libroActualizado = libroMapper.toEntity(libroDTO);
        return actualizarLibro(idLibro, libroActualizado);
    }

    @Override
    public void eliminarLibro(String idLibro) {
        if (!libroRepository.existsById(idLibro)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteById(idLibro);
    }

    private void procesarArchivos(LibroDTO libroDTO) throws IOException {
        if (libroDTO.getArchivoPortada() != null) {
            String nombreArchivo = fileStorageUtil.guardarArchivo(
                    libroDTO.getArchivoPortada(),
                    portadasDir,
                    "portada_"
            );
            libroDTO.setUrlPortada("/archivos/portadas/" + nombreArchivo);
        }

        if (libroDTO.getArchivoLibro() != null) {
            String nombreArchivo = fileStorageUtil.guardarArchivo(
                    libroDTO.getArchivoLibro(),
                    librosDir,
                    "libro_"
            );
            libroDTO.setUrlLibro("/archivos/libros/" + nombreArchivo);
        }
    }
}

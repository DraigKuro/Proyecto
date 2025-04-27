package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.models.Autor;
import com.tutienda.libros.api.models.Genero;
import com.tutienda.libros.api.models.Idioma;
import com.tutienda.libros.api.models.Libro;
import com.tutienda.libros.api.models.LibroAutor;
import com.tutienda.libros.api.models.Saga;
import com.tutienda.libros.api.repositories.LibroRepository;
import com.tutienda.libros.api.repositories.SagaRepository;
import com.tutienda.libros.api.services.LibroService;
import com.tutienda.libros.api.dto.LibroDTO;

import com.tutienda.libros.api.utils.LibroMapper;
import com.tutienda.libros.api.utils.FileStorageUtil;
import com.tutienda.libros.api.utils.LibroSpecifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private final LibroRepository libroRepository;
    private final SagaRepository sagaRepository;

    private final LibroMapper libroMapper;
    private final FileStorageUtil fileStorageUtil;

    @Value("${app.uploads.portadas-dir}")
    private String portadasDir;

    @Value("${app.uploads.libros-dir}")
    private String librosDir;

    public LibroServiceImpl(LibroRepository libroRepository,
            SagaRepository sagaRepository,
            LibroMapper libroMapper,
            FileStorageUtil fileStorageUtil) {
        this.libroRepository = libroRepository;
        this.sagaRepository = sagaRepository;
        this.libroMapper = libroMapper;
        this.fileStorageUtil = fileStorageUtil;
    }

    @Override
    public Libro crearLibro(Libro libro) {
        // Validación simple (puedes añadir más)
        if (libroRepository.existsById(libro.getIdLibro())) {
            throw new RuntimeException("El libro ya existe");
        }
        return libroRepository.save(libro);
    }

    @Override
    public Libro crearLibroDesdeDTO(LibroDTO libroDTO) throws IOException {
        procesarArchivos(libroDTO);
        Libro libro = libroMapper.toEntity(libroDTO);

        if (libroDTO.getGenero() != null) {
            Genero genero = libroDTO.getGenero();
            libro.getGeneroCollection().add(genero);
        }

        if (libroDTO.getIdioma() != null) {
            Idioma idioma = libroDTO.getIdioma();
            libro.getIdiomaCollection().add(idioma);
        }

        if (libroDTO.getSaga() != null) {
            Saga saga = libroDTO.getSaga();
            if (sagaRepository.existsById(saga.getIdSaga())) {
                libro.setIdFkSaga(saga);
            } else {
                sagaRepository.save(saga);
                libro.setIdFkSaga(saga);
            }
        }

        // 4. Manejar autores a través de LibroAutor
        if (libroDTO.getAutores() != null && !libroDTO.getAutores().isEmpty()) {
            if (libro.getLibroAutorCollection() == null) {
                libro.setLibroAutorCollection(new ArrayList<>());
            }
            // Iterar sobre los autores del DTO
            for (Autor autor : libroDTO.getAutores()) {
                LibroAutor libroAutor = new LibroAutor();
                libroAutor.setLibro(libro);
                libroAutor.setAutor(autor);
                libro.getLibroAutorCollection().add(libroAutor);
            }
        }

        return crearLibro(libro);
    }

    @Override
    public Libro buscarPorId(String idLibro) {
        return libroRepository.findById(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public List<Libro> buscarLibrosConFiltros(
            String nombreLibro,
            String nombreAutor,
            String nombreGenero,
            String nombreSaga,
            LocalDate fechaPublicacion,
            Double valoracionMin,
            Double valoracionMax,
            BigDecimal precioMin,
            BigDecimal precioMax,
            String nombreIdioma
    ) {
        return libroRepository.findAll(LibroSpecifications.buscarLibros(
                nombreLibro,
                nombreAutor,
                nombreGenero,
                nombreSaga,
                fechaPublicacion,
                valoracionMin,
                valoracionMax,
                precioMin,
                precioMax,
                nombreIdioma
        ));
    }

    @Override
    public Libro actualizarLibro(String idLibro, Libro libroActualizado) {
        if (libroActualizado == null) {
            throw new IllegalArgumentException("El libro actualizado no puede ser null");
        }

        return libroRepository.findById(idLibro)
                .map(libroExistente -> {
                    updateLibroFields(libroExistente, libroActualizado);
                    return libroRepository.save(libroExistente);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + idLibro));
    }

// Método auxiliar para actualizar campos
    private void updateLibroFields(Libro libroExistente, Libro libroActualizado) {
        Optional.ofNullable(libroActualizado.getTitulo()).ifPresent(libroExistente::setTitulo);
        Optional.ofNullable(libroActualizado.getFechaPubli()).ifPresent(libroExistente::setFechaPubli);
        Optional.ofNullable(libroActualizado.getPrecio()).ifPresent(libroExistente::setPrecio);
        Optional.ofNullable(libroActualizado.getDescuento()).ifPresent(libroExistente::setDescuento);
        if (libroActualizado.getDrm() != libroExistente.getDrm()) {
            libroExistente.setDrm(libroActualizado.getDrm());
        }
        if (libroActualizado.getNPaginas() != 0) {
            libroExistente.setNPaginas(libroActualizado.getNPaginas());
        }
        Optional.ofNullable(libroActualizado.getSinopsis()).ifPresent(libroExistente::setSinopsis);
        Optional.ofNullable(libroActualizado.getNVotos()).ifPresent(libroExistente::setNVotos);
        Optional.ofNullable(libroActualizado.getValoracion()).ifPresent(libroExistente::setValoracion);
        Optional.ofNullable(libroActualizado.getUrlibro()).ifPresent(libroExistente::setUrlibro);
        Optional.ofNullable(libroActualizado.getUrlportada()).ifPresent(libroExistente::setUrlportada);
    }

    @Override
    public Libro actualizarLibroDesdeDTO(String idLibro, LibroDTO libroDTO) throws IOException {
        if (libroDTO == null) {
            throw new IllegalArgumentException("El DTO del libro no puede ser null");
        }

        // Procesar archivos y mapear DTO a entidad
        procesarArchivos(libroDTO);
        Libro libroActualizado = libroMapper.toEntity(libroDTO);

        // Manejar relaciones
        libroActualizado.setGeneroCollection(new ArrayList<>());
        Optional.ofNullable(libroDTO.getGenero()).ifPresent(genero -> libroActualizado.getGeneroCollection().add(genero));

        libroActualizado.setIdiomaCollection(new ArrayList<>());
        Optional.ofNullable(libroDTO.getIdioma()).ifPresent(idioma -> libroActualizado.getIdiomaCollection().add(idioma));

        Optional.ofNullable(libroDTO.getSaga()).ifPresent(libroActualizado::setIdFkSaga);

        // Manejar autores
        libroActualizado.setLibroAutorCollection(new ArrayList<>());
        Optional.ofNullable(libroDTO.getAutores())
                .filter(autores -> !autores.isEmpty())
                .ifPresent(autores -> autores.forEach(autor -> {
            LibroAutor libroAutor = new LibroAutor();
            libroAutor.setLibro(libroActualizado);
            libroAutor.setAutor(autor);
            libroActualizado.getLibroAutorCollection().add(libroAutor);
        }));

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

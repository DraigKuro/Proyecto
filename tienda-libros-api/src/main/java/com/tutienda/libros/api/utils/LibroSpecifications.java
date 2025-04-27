package com.tutienda.libros.api.utils;

import com.tutienda.libros.api.models.Libro;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LibroSpecifications {

    public static Specification<Libro> buscarLibros(
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
        return (root, query, criteriaBuilder) -> {
            query.distinct(true); // para no duplicar libros con varios autores

            Predicate predicate = criteriaBuilder.conjunction(); // empieza con un "true" que vas combinando

            if (nombreLibro != null && !nombreLibro.isBlank()) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombreLibro.toLowerCase() + "%"));
            }

            if (nombreAutor != null && !nombreAutor.isBlank()) {
                Join<Object, Object> libroAutorJoin = root.join("libro_autor", JoinType.LEFT).join("autor", JoinType.LEFT);
                Predicate nombreAutorPredicate = criteriaBuilder.like(criteriaBuilder.lower(libroAutorJoin.get("nombre")), "%" + nombreAutor.toLowerCase() + "%");
                Predicate apellidoAutorPredicate = criteriaBuilder.like(criteriaBuilder.lower(libroAutorJoin.get("apellido")), "%" + nombreAutor.toLowerCase() + "%");
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(nombreAutorPredicate, apellidoAutorPredicate));
            }

            if (nombreGenero != null && !nombreGenero.isBlank()) {
                Join<Object, Object> generoJoin = root.join("genero", JoinType.LEFT);
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.like(criteriaBuilder.lower(generoJoin.get("nombre")), "%" + nombreGenero.toLowerCase() + "%"));
            }

            if (nombreSaga != null && !nombreSaga.isBlank()) {
                Join<Object, Object> sagaJoin = root.join("saga", JoinType.LEFT);
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.like(criteriaBuilder.lower(sagaJoin.get("nombre")), "%" + nombreSaga.toLowerCase() + "%"));
            }

            if (fechaPublicacion != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.equal(root.get("fechaPublicacion"), fechaPublicacion));
            }

            if (valoracionMin != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.greaterThanOrEqualTo(root.get("valoracion"), valoracionMin));
            }

            if (valoracionMax != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.lessThanOrEqualTo(root.get("valoracion"), valoracionMax));
            }

            if (precioMin != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.greaterThanOrEqualTo(root.get("precio"), precioMin));
            }

            if (precioMax != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.lessThanOrEqualTo(root.get("precio"), precioMax));
            }

            if (nombreIdioma != null && !nombreIdioma.isBlank()) {
                Join<Object, Object> idiomaJoin = root.join("idioma", JoinType.LEFT);
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.like(criteriaBuilder.lower(idiomaJoin.get("nombre")), "%" + nombreIdioma.toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}

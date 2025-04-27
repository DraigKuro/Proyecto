package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.models.Genero;
import com.tutienda.libros.api.repositories.GeneroRepository;
import com.tutienda.libros.api.services.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> obtenerGeneros() {
        return generoRepository.findAll();
    }
}
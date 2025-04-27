package com.tutienda.libros.api.services.impl;

import com.tutienda.libros.api.models.Idioma;
import com.tutienda.libros.api.repositories.IdiomaRepository;
import com.tutienda.libros.api.services.IdiomaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaServiceImpl implements IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Override
    public List<Idioma> obtenerIdiomas() {
        return idiomaRepository.findAll();
    }
}

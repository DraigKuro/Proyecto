package com.tutienda.libros.api.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class FileStorageConfig implements WebMvcConfigurer {

    @Value("${app.uploads.root-directory}")
    private String uploadRootDir;

    @Value("${app.uploads.portadas}")
    private String portadasDir;

    @Value("${app.uploads.libros}")
    private String librosDir;

    @PostConstruct
    public void init() {
        // Crear directorios si no existen
        new File(uploadRootDir + File.separator + portadasDir).mkdirs();
        new File(uploadRootDir + File.separator + librosDir).mkdirs();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/portadas/**")
                .addResourceLocations("file:" + uploadRootDir + File.separator + portadasDir + File.separator);

        registry.addResourceHandler("/libros/**")
                .addResourceLocations("file:" + uploadRootDir + File.separator + librosDir + File.separator);
    }
}

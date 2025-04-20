package com.tutienda.libros.api.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorageUtil {

    public String guardarArchivo(MultipartFile archivo, String directorio, String prefijo) throws IOException {
        String extension = archivo.getOriginalFilename()
                               .substring(archivo.getOriginalFilename().lastIndexOf("."));
        String nombreArchivo = prefijo + UUID.randomUUID() + extension;
        Path rutaCompleta = Paths.get(directorio, nombreArchivo);
        
        Files.createDirectories(rutaCompleta.getParent());
        Files.write(rutaCompleta, archivo.getBytes());
        
        return nombreArchivo;
    }
}
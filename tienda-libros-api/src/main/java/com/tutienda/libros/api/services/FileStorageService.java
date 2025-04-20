package com.tutienda.libros.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${app.uploads.root-directory}")
    private String uploadRootDir;

    @Value("${app.uploads.portadas}")
    private String portadasDir;

    @Value("${app.uploads.libros}")
    private String librosDir;

    public String storePortada(MultipartFile file) throws IOException {
        return storeFile(file, portadasDir, "portada_");
    }

    public String storeLibro(MultipartFile file) throws IOException {
        return storeFile(file, librosDir, "libro_");
    }

    private String storeFile(MultipartFile file, String subdir, String prefix) throws IOException {
        String filename = prefix + UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadRootDir, subdir, filename);
        Files.write(filePath, file.getBytes());
        return filename;
    }
}

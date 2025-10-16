package com.abb.abb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DocumentStorageInitializer {

    @Value("${documents.base-dir}")
    private String baseDir;

    @PostConstruct
    public void init() {
        Path path = Paths.get(baseDir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("Dossier documents créé : " + path.toAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException("Impossible de créer le dossier de documents : " + path, e);
            }
        } else {
            System.out.println("Dossier documents existant : " + path.toAbsolutePath());
        }
    }
}

package com.aplicationWork.prova.resources;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aplicationWork.prova.entidades.Produtor;
import com.aplicationWork.prova.services.FileService;


@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<List<Produtor>> uploadFile(@RequestParam("file") MultipartFile file) {
        List<Produtor> result = fileService.processFile(file);
        return ResponseEntity.ok(result);
    }
}


